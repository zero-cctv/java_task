/*
 * Copyright Huayu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.huayu.springboot.system.vo;

import io.huayu.springboot.framework.shiro.vo.LoginSysUserVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author weiqian
 * @since 2020-03-23
 **/
@Data
@Accessors(chain = true)
@ApiModel("登陆用户信息TokenVO")
public class LoginSysUserTokenVo implements Serializable {
    private static final long serialVersionUID = -4650803752566647697L;

    @ApiModelProperty("token")
    private String token;

    @ApiModelProperty("uid")
    private Integer uid;
    /**
     * 登陆用户对象
     */
    private LoginSysUserVo loginSysUserVo;
}
