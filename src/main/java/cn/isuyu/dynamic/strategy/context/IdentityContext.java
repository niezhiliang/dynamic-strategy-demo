package cn.isuyu.dynamic.strategy.context;

import cn.isuyu.dynamic.strategy.strategys.IdentityStrategy;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/6/4 上午10:37
 */
public class IdentityContext {

    private IdentityStrategy identityStrategy;

    public IdentityContext(IdentityStrategy identityStrategy) {
        this.identityStrategy = identityStrategy;
    }

    public void identity() {
        identityStrategy.identity();
    }
}
