package io.huayu.springboot.store.dto.model;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Template对象", description = "规格模板")
public class TemplateBigDto extends BaseEntity {
    private String id;
//    @ApiModelProperty(value = "模板名称")
    private String name;
//    @ApiModelProperty(value = "规格名称的值")
    private ArrayList<TemplateDto> value;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}