package com.pojo;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 委托
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Delegate对象", description="委托")
public class Delegate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目公司编号")
    private Integer Dno;

    @ApiModelProperty(value = "销售公司编号")
    private Integer Sno;


}
