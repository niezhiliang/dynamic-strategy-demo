package cn.isuyu.dynamic.strategy.strategys;

import cn.isuyu.dynamic.strategy.dtos.CACertDTO;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/6/4 上午10:38
 */
public interface IdentityStrategy {

    void applyCaCert(CACertDTO dto);

}
