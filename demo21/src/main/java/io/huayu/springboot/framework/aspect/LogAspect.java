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

package io.huayu.springboot.framework.aspect;

import io.huayu.springboot.framework.core.aop.AbstractLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Controller Aop
 * 获取响应结果信息
 * </p>
 *
 * @author weiqian
 * @date 2019-10-23
 */
@Slf4j
@Aspect
@Component
public class LogAspect extends AbstractLogAspect {

    /**
     * 切点
     */
    private static final String POINTCUT = "execution(public * io.huayu.springboot..*.controller..*.*(..))";

    @Around(POINTCUT)
    @Override
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return super.handle(joinPoint);
    }

}
