package io.huayu.springboot.store.dto.model;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "规格名称对象", description = "规格名称")
public class TemplateDto extends BaseEntity {
    private String id;
//    @ApiModelProperty(value = "规格名称")
    private String name;
//    @ApiModelProperty(value = "规格属性的值")
    private ArrayList<Node> value;
}