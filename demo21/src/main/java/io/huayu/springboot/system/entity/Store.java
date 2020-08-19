package io.huayu.springboot.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
@ApiModel(value="Store对象", description="")
public class Store extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商家店铺id")
    private String id;

    @ApiModelProperty(value = "校园id")
    private String schoolId;

    @ApiModelProperty(value = "店铺名称")
    private String name;

    @ApiModelProperty(value = "店铺地址")
    private String address;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "排序值")
    private Integer rank;

    @ApiModelProperty(value = "访问量")
    private Integer traffic;

    @ApiModelProperty(value = "店铺图片")
    private String image;

    @ApiModelProperty(value = "状态（0为正常，1为冻结）")
    private Boolean isOpen;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除（0为正常，1为删除）")
    @TableField(select = false)
    private Boolean deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
