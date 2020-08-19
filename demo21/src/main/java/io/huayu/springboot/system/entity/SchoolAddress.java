package io.huayu.springboot.system.entity;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

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
@ApiModel(value="SchoolAddress对象", description="")
public class SchoolAddress extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "校园常用派送地址id")
    private String id;

    @ApiModelProperty(value = "校园地标建筑名称")
    private String name;

    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度")
    private BigDecimal management;

    @ApiModelProperty(value = "逻辑删除（0为正常，1为删除）")
    private Boolean delete;

    @ApiModelProperty(value = "校园id")
    private String schoolId;


}
