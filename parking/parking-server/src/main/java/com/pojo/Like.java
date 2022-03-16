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
 * 收藏
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Like对象", description="收藏")
public class Like implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收藏编号")
    @TableId(value = "Lno", type = IdType.AUTO)
    private Integer Lno;

    @ApiModelProperty(value = "车位编号")
    private String Pno;

    @ApiModelProperty(value = "区域编号")
    private Integer Ano;

    @ApiModelProperty(value = "楼盘编号")
    private Integer Cno;

    @ApiModelProperty(value = "业主账号")
    private String Oaccount;


}
