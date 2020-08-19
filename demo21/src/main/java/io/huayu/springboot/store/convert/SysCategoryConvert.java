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

package io.huayu.springboot.store.convert;

import io.huayu.springboot.store.dto.CategoryDto;
import io.huayu.springboot.store.vo.CategoryVo;
import io.huayu.springboot.system.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 系统用户对象转换器
 *
 * @author weiqian
 * @date 2019-10-05
 **/
@Mapper
public interface SysCategoryConvert {

    SysCategoryConvert INSTANCE = Mappers.getMapper(SysCategoryConvert.class);

    /**
     * dto对象CategoryDto转换成登陆用户VO对象
     *
     * @param
     * @return
     */
    CategoryVo CategoryDtotoVo(CategoryDto categoryDto);

    /**
     * 实体类Category对象转换成dto对象CategoryDto
     *
     * @param
     * @return
     */
    CategoryDto CategorytoCategoryDto(Category category);

    /**
     * 实体类Category对象转换成vo对象CategoryVo
     *
     * @param
     * @return
     */
    CategoryVo CategorytoVo(Category category);


}
