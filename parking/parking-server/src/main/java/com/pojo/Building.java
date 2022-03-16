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
 *
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Building对象", description="")
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Bno", type = IdType.AUTO)
    private Integer Bno;

    @ApiModelProperty(value = "楼号")
    private String Bname;

    @ApiModelProperty(value = "楼盘编号")
    private Integer Cno;

    @ApiModelProperty(value = "楼纬度")
    private BigDecimal Blat;

    @ApiModelProperty(value = "楼经度")
    private BigDecimal Blng;


}
