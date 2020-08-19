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
@ApiModel(value="Order对象", description="")
public class Order extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "收货地址id")
    private String addressId;

    @ApiModelProperty(value = "实付金额")
    private BigDecimal fPrice;

    @ApiModelProperty(value = "运费")
    private BigDecimal postage;

    @ApiModelProperty(value = "订单状态（0-待付款 , 1-待发货,2-待收货,4-待评价，5-已发货,6-买家已付款， 7-交易成功,8-退款成功）")
    private String status;

    @ApiModelProperty(value = "支付时间")
    private LocalDateTime paytime;

    @ApiModelProperty(value = "发货时间")
    private LocalDateTime deliveryTime;

    @ApiModelProperty(value = "订单完成时间")
    private LocalDateTime orderTime;

    @ApiModelProperty(value = "交易完成时间")
    private LocalDateTime dealTime;

    @ApiModelProperty(value = "逻辑删除（当这个字段值为0时，说明数据未被删除，提供给用户正常使用，当这个字段值为1是，说明数据已被删除，用户无法正常查到这条数据；设置默认值为0）")
    private Boolean delete;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;


}
