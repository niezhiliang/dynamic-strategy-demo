package cn.isuyu.dynamic.strategy.controller;

import cn.isuyu.dynamic.strategy.dtos.CACertDTO;
import cn.isuyu.dynamic.strategy.entity.Strategys;
import cn.isuyu.dynamic.strategy.entity.User;
import cn.isuyu.dynamic.strategy.service.IServicesService;
import cn.isuyu.dynamic.strategy.service.IUserService;
import cn.isuyu.dynamic.strategy.strategys.IdentityStrategy;
import cn.isuyu.dynamic.strategy.strategys.StrategyContext;
import cn.isuyu.dynamic.strategy.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/6/4 上午10:33
 */
@RestController
public class IndexController {

    @Autowired
    private IServicesService servicesService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/identity/{sid}/{uid}")
    public String identity(@PathVariable("sid") Integer sid,@PathVariable(value = "uid") Integer uid) throws ClassNotFoundException {

        User user = userService.getById(uid);

        Strategys strategys = servicesService.getUserServiceStrategy(sid,uid);
        Class<IdentityStrategy> identityStrategyClass = (Class<IdentityStrategy>) Class.forName(strategys.getStrategyClass());
        IdentityStrategy identityStrategy = SpringContextUtils.getBean(identityStrategyClass);
        StrategyContext identityContext = new StrategyContext(identityStrategy);

        CACertDTO caCertDTO = new CACertDTO();
        caCertDTO.setName(user.getName());

        identityContext.applyCaCert(caCertDTO);

        return "success";
    }

}
