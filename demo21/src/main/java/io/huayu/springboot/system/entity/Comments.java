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
@ApiModel(value="Comments对象", description="")
public class Comments extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论id")
    private String id;

    @ApiModelProperty(value = "评论人id")
    private String userId;

    @ApiModelProperty(value = "商品id")
    private String gId;

    @ApiModelProperty(value = "正文")
    private String body;

    @ApiModelProperty(value = "逻辑删除：当这个字段值为0时，说明数据未被删除，提供给用户正常使用，当这个字段值为1是，说明数据已被删除，用户无法正常查到这条数据；设置默认值为0")
    private Boolean delete;

    @ApiModelProperty(value = "图片")
    private String iamge;

    @ApiModelProperty(value = "评论时间")
    private LocalDateTime time;


}
