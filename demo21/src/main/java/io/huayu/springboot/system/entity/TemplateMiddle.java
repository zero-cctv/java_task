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
 * 模板中间表
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TemplateMiddle对象", description="模板中间表")
public class TemplateMiddle extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "模板中间表id")
    private String id;

    @ApiModelProperty(value = "规格属性id的串联")
    private String sIdId;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "图片")
    private String image;

    @ApiModelProperty(value = "库存")
    private Integer num;

    @ApiModelProperty(value = "重量")
    private BigDecimal weight;


}
