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
import io.huayu.springboot.system.entity.SysRolePermission;
import io.huayu.springboot.system.param.sysrole.SysRolePermissionPageParam;
import io.huayu.springboot.system.vo.SysRolePermissionQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * 角色权限关系 Mapper 接口
 * </pre>
 *
 * @author weiqian
 * @since 2020-03-23
 */
@Repository
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    SysRolePermissionQueryVo getSysRolePermissionById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param sysRolePermissionPageParam
     * @return
     */
    IPage<SysRolePermissionQueryVo> getSysRolePermissionPageList(@Param("page") Page page, @Param("param") SysRolePermissionPageParam sysRolePermissionPageParam);

    /**
     * 根据角色id获取可用的权限编码
     *
     * @param roleId
     * @return
     */
    Set<String> getPermissionCodesByRoleId(@Param("roleId") Long roleId);

    /**
     * 根据角色id获取该对应的所有三级权限ID
     * @param roleId
     * @return
     */
    List<Long> getThreeLevelPermissionIdsByRoleId(@Param("roleId") Long roleId);
}
