package cn.isuyu.dynamic.strategy.service.impl;

import cn.isuyu.dynamic.strategy.entity.User;
import cn.isuyu.dynamic.strategy.mapper.UserMapper;
import cn.isuyu.dynamic.strategy.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {



}
