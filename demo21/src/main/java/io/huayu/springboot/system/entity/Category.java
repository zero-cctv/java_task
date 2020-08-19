package io.huayu.springboot.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-08-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Category对象", description = "")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "类别id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String cId;

    @ApiModelProperty(value = "父类id")
    private String fCId;

    @ApiModelProperty(value = "类别名称")
    private String name;

    @ApiModelProperty(value = "图片地址")
    private String image;

    @ApiModelProperty(value = "是否父类，0为子类，1为父类")
    private Boolean isFid;

    @ApiModelProperty(value = "显示状态，0为显示，1为不显示")
    private Boolean status;

    @ApiModelProperty(value = "排序")
    private Integer rank;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除，默认为0，0为未删除")
    private Boolean delete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;


}
