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
 * 销售公司
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Saler对象", description="销售公司")
public class Saler implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售公司编号")
    @TableId(value = "Sno", type = IdType.AUTO)
    private Integer Sno;

    @ApiModelProperty(value = "销售公司账号")
    private String Saccount;

    @ApiModelProperty(value = "密码")
    private String Spassword;

    @ApiModelProperty(value = "名称")
    private String Sname;

    @ApiModelProperty(value = "地址")
    private String Saddress;

    @ApiModelProperty(value = "联系方式")
    private String Sphonenum;


}
