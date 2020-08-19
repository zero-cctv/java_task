package io.huayu.springboot.system.entity;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品规格属性展示
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SpecificationShow对象", description="商品规格属性展示")
public class SpecificationShow extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品规格属性展示id")
    private String id;

    @ApiModelProperty(value = "商品id")
    private String pId;

    @ApiModelProperty(value = "模板id")
    private String sId;


}
