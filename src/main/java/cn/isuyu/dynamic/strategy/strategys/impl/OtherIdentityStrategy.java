package cn.isuyu.dynamic.strategy.strategys.impl;

import cn.isuyu.dynamic.strategy.strategys.IdentityStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/6/4 上午10:42
 */
@Component
public class OtherIdentityStrategy implements IdentityStrategy {

    @Override
    public void identity() {
        System.out.println("使用其它方式认证。。。");
    }
}