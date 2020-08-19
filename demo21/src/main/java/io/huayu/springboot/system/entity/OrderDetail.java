package io.huayu.springboot.system.entity;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
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
@ApiModel(value="OrderDetail对象", description="")
public class OrderDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单明细id")
    private String id;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "商品id")
    private String pId;

    @ApiModelProperty(value = "模板中间表id")
    private String tmId;

    @ApiModelProperty(value = "数量")
    private Integer num;

    @ApiModelProperty(value = "配送类型（0-自取，1-配送）")
    private Boolean type;

    @ApiModelProperty(value = "总价")
    private BigDecimal sum;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;


}
