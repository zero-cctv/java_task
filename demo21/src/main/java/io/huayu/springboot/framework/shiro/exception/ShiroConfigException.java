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

package io.huayu.springboot.framework.shiro.exception;

import io.huayu.springboot.framework.common.exception.SpringBootPlusException;

/**
 * Shiro配置异常
 *
 * @author weiqian
 * @date 2019-09-29
 * @since 1.3.0.RELEASE
 **/
public class ShiroConfigException extends SpringBootPlusException {

    public ShiroConfigException(String message) {
        super(message);
    }

    public ShiroConfigException(Integer errorCode, String message) {
        super(errorCode, message);
    }

}