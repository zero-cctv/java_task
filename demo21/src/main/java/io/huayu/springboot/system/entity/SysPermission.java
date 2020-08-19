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
 * 系统权限
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysPermission对象", description = "系统权限")
public class SysPermission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "路径")
    private String url;

    @ApiModelProperty(value = "唯一编码")
    private String code;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "类型，1：菜单，2：按钮")
    private Integer type;

    @ApiModelProperty(value = "层级，1：第一级，2：第二级，N：第N级")
    private Integer level;

    @ApiModelProperty(value = "状态，0：禁用，1：启用")
    private Integer state;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "版本")
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
