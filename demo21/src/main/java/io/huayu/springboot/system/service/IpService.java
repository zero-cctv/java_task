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

package io.huayu.springboot.system.service;

import io.huayu.springboot.framework.common.service.BaseService;
import io.huayu.springboot.framework.pagination.Paging;
import io.huayu.springboot.system.entity.Ip;
import io.huayu.springboot.system.param.IpPageParam;
import io.huayu.springboot.system.vo.IpQueryVo;

import java.io.Serializable;

/**
 * <p>
 * IP地址 服务类
 * </p>
 *
 * @author weiqian
 * @since 2019-10-11
 */
public interface IpService extends BaseService<Ip> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    IpQueryVo getIpById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param ipPageParam
     * @return
     * @throws Exception
     */
    Paging<IpQueryVo> getIpPageList(IpPageParam ipPageParam) throws Exception;

}
