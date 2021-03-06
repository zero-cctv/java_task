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

package io.huayu.springboot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.huayu.springboot.system.entity.SysLog;
import io.huayu.springboot.system.param.SysLogPageParam;
import io.huayu.springboot.system.vo.SysLogQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <p>
 * 系统日志 Mapper 接口
 * </p>
 *
 * @author weiqian
 * @since 2020-03-23
 */
@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    SysLogQueryVo getSysLogById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param sysLogPageParam
     * @return
     */
    IPage<SysLogQueryVo> getSysLogPageList(@Param("page") Page page, @Param("param") SysLogPageParam sysLogPageParam);

}
