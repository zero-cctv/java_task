package io.huayu.springboot.store.dto;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Norms  extends BaseEntity {
   @ApiModelProperty(value = "规格名称")
   private String n_name;
   @ApiModelProperty(value = "规格属性的值")
   private ArrayList<String> n_value;
}
