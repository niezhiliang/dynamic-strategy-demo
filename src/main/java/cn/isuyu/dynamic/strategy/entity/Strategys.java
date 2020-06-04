package cn.isuyu.dynamic.strategy.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020-06-04
 */
@Data
@Accessors(chain = true)
@TableName("t_strategys")
public class Strategys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务id
     */
    private Integer serviceId;

    /**
     * 策略名称
     */
    private String strategyName;

    /**
     * 策略实现类
     */
    private String strategyClass;

    /**
     * 创建时间
     */
    private Date createTime;


}
