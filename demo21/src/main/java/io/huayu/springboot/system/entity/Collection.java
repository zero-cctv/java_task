package io.huayu.springboot.system.entity;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="Collection对象", description="")
public class Collection extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收藏id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userid;

    @ApiModelProperty(value = "商品id")
    private String gId;


}
