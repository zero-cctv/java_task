package io.huayu.springboot.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * 用户留言表 查询结果对象
 * </pre>
 *
 * @author weiqian
 * @date 2020-07-03
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "UserMessagesQueryVo对象", description = "用户留言表查询参数")
public class UserMessagesQueryVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("发布者user id")
    private Integer uid;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String contents;

    @ApiModelProperty("展示图")
    private String images;

    @ApiModelProperty("状态，0：删除，1：正常")
    private Integer status;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

}