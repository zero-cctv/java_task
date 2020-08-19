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

package io.huayu.springboot.framework.shiro.cache;

import io.huayu.springboot.framework.shiro.jwt.JwtToken;
import io.huayu.springboot.framework.shiro.vo.LoginSysUserRedisVo;
import io.huayu.springboot.framework.shiro.vo.LoginSysUserVo;

/**
 * 登陆信息Redis缓存操作服务
 *
 * @author weiqian
 * @date 2020-01-20
 * @since 1.3.0.RELEASE
 **/
public interface LoginRedisService {

    /**
     * 缓存登陆信息
     *
     * @param jwtToken
     * @param loginSysUserVo
     */
    void cacheLoginInfo(JwtToken jwtToken, LoginSysUserVo loginSysUserVo);


    /**
     * 刷新登陆信息
     *
     * @param oldToken
     * @param username
     * @param newJwtToken
     */
    void refreshLoginInfo(String oldToken, String username, JwtToken newJwtToken);

    /**
     * 通过用户名，从缓存中获取登陆用户LoginSysUserRedisVo
     *
     * @param username
     * @return
     */
    LoginSysUserRedisVo getLoginSysUserRedisVo(String username);

    /**
     * 获取登陆用户对象
     *
     * @param username
     * @return
     */
    LoginSysUserVo getLoginSysUserVo(String username);

    /**
     * 通过用户名称获取盐值
     *
     * @param username
     * @return
     */
    String getSalt(String username);

    /**
     * 删除对应用户的Redis缓存
     *
     * @param token
     * @param username
     */
    void deleteLoginInfo(String token, String username);

    /**
     * 判断token在redis中是否存在
     *
     * @param token
     * @return
     */
    boolean exists(String token);

    /**
     * 删除用户所有登陆缓存
     *
     * @param username
     */
    void deleteUserAllCache(String username);

}
