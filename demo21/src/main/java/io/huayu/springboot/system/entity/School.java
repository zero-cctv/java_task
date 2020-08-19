package io.huayu.springboot.system.entity;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="School对象", description="")
public class School extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "校园id")
    private String id;

    @ApiModelProperty(value = "校园名称")
    private String name;

    @ApiModelProperty(value = "校园图片")
    private String image;

    @ApiModelProperty(value = "校园电话")
    private String phone;

    @ApiModelProperty(value = "校园地址")
    private String address;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "访问量")
    private Integer traffic;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal management;

    @ApiModelProperty(value = "逻辑删除（0为正常，1为已删除）")
    private Boolean delete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;


}
