package cn.isuyu.dynamic.strategy.strategys;

import cn.isuyu.dynamic.strategy.dtos.CACertDTO;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/6/4 下午2:40
 */
public class StrategyContext {

    private IdentityStrategy identityStrategy;


    public StrategyContext(IdentityStrategy identityStrategy) {
        this.identityStrategy = identityStrategy;
    }


    public void applyCaCert(CACertDTO dto){
        identityStrategy.applyCaCert(dto);
    }
}
