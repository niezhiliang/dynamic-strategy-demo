package cn.isuyu.dynamic.strategy.strategys.impl;

import cn.isuyu.dynamic.strategy.dtos.CACertDTO;
import cn.isuyu.dynamic.strategy.strategys.IdentityStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/6/4 上午10:41
 */
@Component
public class HuBeiCAStrategy implements IdentityStrategy {

    @Override
    public void applyCaCert(CACertDTO dto) {
        System.out.println(dto.getName() + "：使用湖北CA申请证书。。。");
    }
}
