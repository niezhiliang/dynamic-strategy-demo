package cn.isuyu.dynamic.strategy.service;

import cn.isuyu.dynamic.strategy.entity.Services;
import cn.isuyu.dynamic.strategy.entity.Strategys;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @Author NieZhiLiang
* @Email nzlsgg@163.com
* @GitHub https://github.com/niezhiliang
* @Date 2020-06-04
*/
public interface IServicesService extends IService<Services> {

    /**
     * 获取用户的某个服务的策略
     * @param sid
     * @param uid
     * @return
     */
    Strategys getUserServiceStrategy(Integer sid,Integer uid);

}
