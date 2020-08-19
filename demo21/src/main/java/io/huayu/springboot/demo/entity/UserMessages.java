package io.huayu.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * <pre>
 * 用户留言表
 * </pre>
 *
 * @author weiqian
 * @since 2020-07-03
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserMessages对象", description = "用户留言表")
public class UserMessages extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("发布者user id")
    private Integer uid;

    @ApiModelProperty("标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty("内容")
    @NotBlank(message = "内容不能为空")
    private String contents;

    @ApiModelProperty("展示图")
    private String images;

    @ApiModelProperty("状态，0：删除，1：正常")
    private Integer status;

    @ApiModelProperty("创建时间")
    @Null(message = "创建时间不用传")
    private Date createTime;

    @ApiModelProperty("修改时间")
    @Null(message = "修改时间不用传")
    private Date updateTime;

}
