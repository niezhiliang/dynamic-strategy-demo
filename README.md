### 前言
我们公司是做电子合同系统的，电子合同里面最重要的就是CA证书,其中颁发机构有`浙江CA`,`湖北CA`、`天威诚信` 、 `沃通CA`、`CFCA`  不同的行业客户对证书的要求都不一样，普通的客户一般用`天威诚信`或者`湖北CA`就好，有一些金融客户，可能会要求必须使用某个CA机构的比如必须要求`沃通`,为了满足这个需求，想到了设计模式中的策略模式，不同的客户在调用的时候使用不同的策略就行了。

### 策略模式
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604142855437.png)
策略模式是将多个类似的业务公共的部分抽离出来成一个接口类，然后具体的业务由各自的策略类去实现这个接口，在使用的时候由一个上下文对象来协调这些业务需要实现的具体策略，上下文对象里面有个属性为抽离出来的接口，还有个构造函数，在使用的时候只需要创建
具体策略类，然后把这个类交给上下文，去调用相应的策略。

### 解决方案
因为涉及客户动态选择，所以需要用到数据库来维护这些关系，我简单的创建了一下，ER图关系如下

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604143531545.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MDgyMzA0,size_16,color_FFFFFF,t_70)
这里一共创建了四张表，如果只是证书动态选择可以不用创建服务这个表，我们公司的服务有很多个，比如CA证书，实名认证，时间戳等服务，然后策略表里面`strategy_class`是存我们项目中具体策略的实现完整名称的。然后就是`t_user_service_strategy` 这个表，用来记录每个用户每个服务使用的具体策略。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604144554788.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MDgyMzA0,size_16,color_FFFFFF,t_70)
因为是demo我这里就写了三个CA机构的策略，反正代码写完以后，后续直接加策略类，然后再数据库里面添加一下就好了。然后具体在使用的时候用下面这个代码就好。
```java
		//查出当前用户使用的策略
        Strategys strategys = servicesService.getUserServiceStrategy(sid,uid);
        //通过反射得到策略类
        IdentityStrategy identityStrategy = (IdentityStrategy) Class.forName(strategys.getStrategyClass()).newInstance();
        StrategyContext identityContext = new StrategyContext(identityStrategy);
        //调用对应的策略
        identityContext.applyCaCert();
```


这样好像确实没啥问题，但因为我们是web项目，不可能不用spring，这些策略类可能会用到spring容器管理的某一下bean，所以我们也需要将这些策略都交给容器去管理，等到想用的时候直接从容器里面拿就好了，有些同学可能会说这还不简单，直接加个`@Component`注解不就好了，然后需要用的时候直接通过`@Autowired`注入进来不就好了，但是一个接口有多个实现类的时候，使用`@Autowired`注入是会有问题的， 别说用启动的时候就会报异常，具体异常如下：
```java
Field identityStrategy in cn.isuyu.dynamic.strategy.controller.IndexController required a single bean, but 3 were found:
	- huBeiCAStrategy: defined in file [/Users/fxq/Desktop/dynamic-strategy-demo/target/classes/cn/isuyu/dynamic/strategy/strategys/impl/HuBeiCAStrategy.class]
	- woTongCAStrategy: defined in file [/Users/fxq/Desktop/dynamic-strategy-demo/target/classes/cn/isuyu/dynamic/strategy/strategys/impl/WoTongCAStrategy.class]
	- zheJiangCAStrategy: defined in file [/Users/fxq/Desktop/dynamic-strategy-demo/target/classes/cn/isuyu/dynamic/strategy/strategys/impl/ZheJiangCAStrategy.class]
Action:

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
```
异常日志已经说得很明显了，注入的时候只能有一个bean，但是发现了三个，然后还给出了解决方案，告诉我们使用` @Primary`注解来设置一个主要的类，虽然我们在某个类上面加上了` @Primary`注解，启动不会有问题，但是在使用的时候我们会发现注入的永远都是那个加了主角的策略类，治标不治本，不符合我们的需求。

我们先不注入，我们看下这三个策略类是不是放到了spring容器中
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200604152027407.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM4MDgyMzA0,size_16,color_FFFFFF,t_70)
我们可以看到，我们确实把三个策略类都放到容器中了，只是在获取的时候通过`@Autowize`取不出来，既然我们都能放进去，使用注解的方式取不出来的话，我自己想办法取还不行嘛。
平常工作中，我们手动获取spirng容器中的bean也经常遇到，我们写一个工具类，实现`ApplicationContextAware`接口，这个接口会把spring容器的上下文都返回回来，我们拿到了上下文还愁拿不到bean嘛。
```java
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 通过该类获取spring的Bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<?> getType(String name) {
        return applicationContext.getType(name);
    }
}
```
我们把我们的策略交给容器管理了以后，我们调用方式就不能用以前的啦，具体调用就成了下面这个样子啦
```java
        Strategys strategys = servicesService.getUserServiceStrategy(sid,uid);
        Class<IdentityStrategy> identityStrategyClass = (Class<IdentityStrategy>) Class.forName(strategys.getStrategyClass());
        IdentityStrategy identityStrategy = SpringContextUtils.getBean(identityStrategyClass);
        StrategyContext identityContext = new StrategyContext(identityStrategy);
        identityContext.applyCaCert();
```

其实我们再保存数据库具体策略的时候，完全可以只保存容器中bean的名字，但是这样的话如果某一天我们手动给bean加一个名字，我们通过默认的bean名字就拿不到bean，所以我直接保存类全名，不管后面怎么改bean的名称，只要你不改类的包和类名就行。



[源码地址:https://github.com/niezhiliang/dynamic-strategy-demo](https://github.com/niezhiliang/dynamic-strategy-demo)
