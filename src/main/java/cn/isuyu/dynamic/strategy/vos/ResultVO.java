package cn.isuyu.dynamic.strategy.vos;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @GitHub https://github.com/niezhiliang
 * @Date 2020/6/4 上午11:05
 */
@Data
@Accessors(chain = true)
public class ResultVO {

    private int code;

    private Object data;

    private String msg;

    private String seqNo;

}
