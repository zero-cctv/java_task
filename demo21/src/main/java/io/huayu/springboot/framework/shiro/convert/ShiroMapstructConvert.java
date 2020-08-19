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

package io.huayu.springboot.framework.shiro.convert;

import io.huayu.springboot.framework.shiro.jwt.JwtToken;
import io.huayu.springboot.framework.shiro.vo.JwtTokenRedisVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Shiro包下使用mapstruct对象属性复制转换器
 *
 * @author weiqian
 * @date 2020-01-20
 * @since 1.3.0.RELEASE
 **/
@Mapper
public interface ShiroMapstructConvert {

    ShiroMapstructConvert INSTANCE = Mappers.getMapper(ShiroMapstructConvert.class);

    /**
     * JwtToken对象转换成JwtTokenRedisVo
     *
     * @param jwtToken
     * @return
     */
    JwtTokenRedisVo jwtTokenToJwtTokenRedisVo(JwtToken jwtToken);

}
