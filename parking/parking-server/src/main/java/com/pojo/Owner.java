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
 * 业主表
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Owner对象", description="业主表")
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "业主编号")
    @TableId(value = "Ono", type = IdType.AUTO)
    private Integer Ono;

    @ApiModelProperty(value = "姓名")
    private String Oname;

    @ApiModelProperty(value = "联系方式")
    private String Ophonenum;

    @ApiModelProperty(value = "身份证号码")
    private String Oidnum;

    @ApiModelProperty(value = "身份认证标记")
    private String Ocert;

    @ApiModelProperty(value = "实名认证标记")
    private String Ocheck;

    @ApiModelProperty(value = "地址")
    private String Oaddress;

    @ApiModelProperty(value = "邮箱")
    private String Oemail;

    @ApiModelProperty(value = "楼号")
    private String Bname;

    @ApiModelProperty(value = "昵称")
    private String Onickname;

}
