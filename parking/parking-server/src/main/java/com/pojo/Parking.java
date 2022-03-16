package com.pojo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 车位
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Parking对象", description="车位")
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "车位编号")
    private String Pno;

    @ApiModelProperty(value = "区域编号")
    private Integer Ano;

    @ApiModelProperty(value = "车位长")
    private String Plength;

    @ApiModelProperty(value = "车位宽")
    private String Pwide;

    @ApiModelProperty(value = "建筑面积")
    private String Pbuildarea;

    @ApiModelProperty(value = "使用面积")
    private String Pusearea;

    @ApiModelProperty(value = "销售价格")
    private Double Pprice;

    @ApiModelProperty(value = "车位状态")
    private String Pstatus;

    @ApiModelProperty(value = "销售公司编号")
    private Integer Sno;

    private Integer Bno;


}
