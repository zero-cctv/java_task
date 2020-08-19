
package io.huayu.springboot.framework.shiro.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 登录用户对象，响应给前端
 * </p>
 *
 * @author weiqian
 * @date 2020-03-21
 **/
@Data
@Accessors(chain = true)
public class LoginSysUserVo implements Serializable {

    private static final long serialVersionUID = -1758338570596088158L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("主键")
    private Long uid;

    @ApiModelProperty("Token")
    private String token;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("性别，0：女，1：男，默认1")
    private Integer gender;

    @ApiModelProperty("状态，0：禁用，1：启用，2：锁定")
    private Integer state;

    @ApiModelProperty("手机")
    private String phone;

    @ApiModelProperty("头像")
    private String head;

    @ApiModelProperty("简介")
    private String profile;

    @ApiModelProperty("评价")
    private String rating;

    @ApiModelProperty("部门id")
    private Long departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("权限编码列表")
    private Set<String> permissionCodes;

    @ApiModelProperty(value = "校园id")
    private String sId;
    public Long getUid() {
        return id;
    }

}
