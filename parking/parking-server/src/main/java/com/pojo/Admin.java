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
 * 后台管理人员
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Admin对象", description="后台管理人员")
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "后台管理人员编号")
    @TableId(value = "Adminno", type = IdType.AUTO)
    private Integer Adminno;

    @ApiModelProperty(value = "账号")
    private String Adminaccount;

    @ApiModelProperty(value = "密码")
    private String Adminpassword;

    @ApiModelProperty(value = "姓名")
    private String Adminname;

    @ApiModelProperty(value = "联系方式")
    private String Adminphonenum;


}
