package com.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 楼盘
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Community对象", description="楼盘")
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "楼盘编号")
    @TableId(value = "Cno", type = IdType.AUTO)
    private Integer Cno;

    @ApiModelProperty(value = "名称")
    private String Cname;

    @ApiModelProperty(value = "地址")
    private String Caddress;

    @ApiModelProperty(value = "照片")
    private String Cphoto;

    @ApiModelProperty(value = "项目公司编号（外键）")
    private Integer Dno;

    @ApiModelProperty(value = "楼盘所在城市")
    private String Ccity;

    @ApiModelProperty(value = "楼盘纬度")
    private BigDecimal Clat;

    @ApiModelProperty(value = "楼盘经度")
    private BigDecimal Clng;


}
