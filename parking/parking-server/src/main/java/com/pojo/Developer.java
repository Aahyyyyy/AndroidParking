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
 * 项目公司
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Developer对象", description="项目公司")
public class Developer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目公司编号")
    @TableId(value = "Dno", type = IdType.AUTO)
    private Integer Dno;

    @ApiModelProperty(value = "项目公司账号")
    private String Daccount;

    @ApiModelProperty(value = "项目公司密码")
    private String Dpassword;

    @ApiModelProperty(value = "名称")
    private String Dname;

    @ApiModelProperty(value = "地址")
    private String Daddress;

    @ApiModelProperty(value = "联系方式")
    private String Dphonenum;


}
