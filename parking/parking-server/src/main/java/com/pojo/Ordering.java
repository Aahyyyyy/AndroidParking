package com.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Ordering对象", description="订单")
public class Ordering implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ORno", type = IdType.AUTO)
    private Integer ORno;

    @ApiModelProperty(value = "业主编号")
    private Integer Ono;

    @ApiModelProperty(value = "车位编号")
    private String Pno;

    @ApiModelProperty(value = "订单金额")
    private Double ORmoney;

    @ApiModelProperty(value = "购买日期")
    private String ORdate;

    @ApiModelProperty(value = "订单状态")
    private String ORstatus;

    @ApiModelProperty(value = "支付方式")
    private String ORpayment;

    private Double ORlast;


}
