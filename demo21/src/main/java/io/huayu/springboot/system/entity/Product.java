package io.huayu.springboot.system.entity;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@ApiModel(value="Product对象", description="")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    private String pId;

    @ApiModelProperty(value = "类别id")
    private String cId;

    @ApiModelProperty(value = "品牌id")
    private String bId;

    @ApiModelProperty(value = "展示表id")
    private String sId;

    @ApiModelProperty(value = "商家id")
    private String storeId;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "销售值")
    private Integer sell;

    @ApiModelProperty(value = "商品状态 默认0下架状态")
    private Boolean status;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "访问量")
    private Integer traffic;

    @ApiModelProperty(value = "逻辑删除 默认0未删除")
    private Boolean delete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;


}
