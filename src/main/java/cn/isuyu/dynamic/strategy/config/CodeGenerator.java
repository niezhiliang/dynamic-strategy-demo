//package cn.isuyu.dynamic.strategy.config;
//
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author NieZhiLiang
// * @Email nzlsgg@163.com
// * @GitHub https://github.com/niezhiliang
// * @Date 2020/3/13 上午10:27
// */
//public class CodeGenerator {
//
//    private static String GROUPID = "cn.isuyu.dynamic.strategy";
//
//    private static String TABLE_NAMES =
//            "t_user,t_services,t_strategys,t_user_service_strategy";
//
//
//    private static final String AUTHOR = "NieZhiLiang";
//
//    private static final String URL = "127.0.0.1:3306/dynamic-strategy";
//
//    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
//
//    private static final String USER = "root";
//
//    private static final String PASSWORD = "adminadmin";
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir") +  File.separator;
//
//        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setAuthor(AUTHOR);
//        //使用Date 如果不设置会默认使用LocalDate
//        gc.setDateType(DateType.ONLY_DATE);
//        gc.setOpen(false);
//        //gc.setSwagger2(true);
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://"+ URL + "?useUnicode=true&characterEncoding=utf8");
//        dsc.setSchemaName("tmp");
//        dsc.setDriverName(DRIVER_NAME);
//        dsc.setUsername(USER);
//        dsc.setPassword(PASSWORD);
//        mpg.setDataSource(dsc);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        //pc.setModuleName("stu");
//        pc.setParent(GROUPID);
//        mpg.setPackageInfo(pc);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//        // 如果模板引擎是 freemarker
//        String templatePath = "/templates/mapper.xml.ftl";
//
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/"
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
//
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
////         templateConfig.setEntity("/templates/entity");
////         templateConfig.setService("/templates/service");
////         templateConfig.setServiceImpl("./templates/serviceImpl.java");
////         templateConfig.setController(null);
////        templateConfig.setEntity("./templates/entity.java");
////
//        //这个不设置的话会在mapper文件夹下生成一个xml
//        templateConfig.setXml(null);
//        mpg.setTemplate(templateConfig);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        strategy.setInclude(TABLE_NAMES.split(","));
//        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix("t_");
//        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        mpg.execute();
//    }
//
//}
