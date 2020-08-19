package io.huayu.springboot.store.vo;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.huayu.springboot.store.dto.Norms;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * <p>
 * 规格模板
 * </p>
 *
 * @author luyong
 * @since 2020-08-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SpecificationTemplate对象", description = "规格模板")
public class SpecificationTemplateVo extends BaseEntity {


    @ApiModelProperty(value = "规格模板名称")
    private String s_name;
    @ApiModelProperty(value = "规格列表")
    private ArrayList<Norms> array;


}
