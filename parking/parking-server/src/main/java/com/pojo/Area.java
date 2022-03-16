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
 * 区域
 * </p>
 *
 * @author Aahyyyyy
 * @since 2022-02-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Area对象", description="区域")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "区域编号")
    @TableId(value = "Ano", type = IdType.AUTO)
    private Integer Ano;

    @ApiModelProperty(value = "名称")
    private String Aname;

    @ApiModelProperty(value = "图片")
    private String Aphoto;

    @ApiModelProperty(value = "楼盘编号")
    private Integer Cno;

    @ApiModelProperty(value = "开盘状态")
    private String Astatus;


}
