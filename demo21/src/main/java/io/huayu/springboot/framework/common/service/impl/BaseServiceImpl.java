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

package io.huayu.springboot.framework.common.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.huayu.springboot.framework.common.service.BaseService;
import io.huayu.springboot.framework.util.LambdaColumn;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author weiqian
 * @date 2018-11-08
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {


    private Class<?> entityClass;

    {
        Class<?> clazz = this.getClass();
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType){
            Type[] p = ((ParameterizedType) type).getActualTypeArguments();  //取得所有泛型
            this.entityClass= (Class<T>) p[1];
        }
    }

    public String getLambdaColumn(SFunction<T, ?> func) {
        return new LambdaColumn<T>().get(func);
    }

}
