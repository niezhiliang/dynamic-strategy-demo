package cn.isuyu.dynamic.strategy.service.impl;

import cn.isuyu.dynamic.strategy.entity.Services;
import cn.isuyu.dynamic.strategy.entity.Strategys;
import cn.isuyu.dynamic.strategy.entity.UserServiceStrategy;
import cn.isuyu.dynamic.strategy.mapper.ServicesMapper;
import cn.isuyu.dynamic.strategy.service.IServicesService;
import cn.isuyu.dynamic.strategy.service.IStrategysService;
import cn.isuyu.dynamic.strategy.service.IUserServiceStrategyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
* @Author NieZhiLiang
* @Email nzlsgg@163.com
* @GitHub https://github.com/niezhiliang
* @Date 2020-06-04
*/
@Service
@Slf4j
public class ServicesServiceImpl extends ServiceImpl<ServicesMapper, Services> implements IServicesService {

    @Autowired
    private IUserServiceStrategyService userServiceStrategyService;

    @Autowired
    private IStrategysService strategysService;


    @Override
    public Strategys getUserServiceStrategy(Integer sid, Integer uid) {
        LambdaQueryWrapper<UserServiceStrategy> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserServiceStrategy::getUserId,uid)
                .eq(UserServiceStrategy::getServiceId,sid);

        UserServiceStrategy userServiceStrategy = userServiceStrategyService.getOne(queryWrapper);

        return strategysService.getById(userServiceStrategy.getStrategyId());
    }
}
