package io.huayu.springboot.my_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

//会员
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Member对象", description = "会员表")
public class Member extends BaseEntity {

    private static final long serialVersionMID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("会员名")
    private String name;

    @ApiModelProperty("会员昵称")
    private String nickname;

    @ApiModelProperty("会员电话")
    private String phoneNum;

    @ApiModelProperty("会员邮箱")
    private String email;
}
