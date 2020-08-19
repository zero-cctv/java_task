package io.huayu.springboot.store.dto.model;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Node extends BaseEntity {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    public Node(String id, String name) {
        this.id = id;
        this.name = name;
    }

}
