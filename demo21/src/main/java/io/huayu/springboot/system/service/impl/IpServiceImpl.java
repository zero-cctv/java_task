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

package io.huayu.springboot.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.huayu.springboot.framework.common.service.impl.BaseServiceImpl;
import io.huayu.springboot.framework.pagination.PageUtil;
import io.huayu.springboot.framework.pagination.Paging;
import io.huayu.springboot.system.entity.Ip;
import io.huayu.springboot.system.mapper.IpMapper;
import io.huayu.springboot.system.param.IpPageParam;
import io.huayu.springboot.system.service.IpService;
import io.huayu.springboot.system.vo.IpQueryVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;


/**
 * <p>
 * IP地址 服务实现类
 * </p>
 *
 * @author weiqian
 * @since 2019-10-11
 */
@Slf4j
@Service
public class IpServiceImpl extends BaseServiceImpl<IpMapper, Ip> implements IpService {

    @Autowired
    private IpMapper ipMapper;

    @Override
    public IpQueryVo getIpById(Serializable id) throws Exception {
        return ipMapper.getIpById(id);
    }

    @Override
    public Paging<IpQueryVo> getIpPageList(IpPageParam ipPageParam) throws Exception {
        Page page = PageUtil.getPage(ipPageParam, OrderItem.desc(getLambdaColumn(Ip::getId)));
        IPage<IpQueryVo> iPage = ipMapper.getIpPageList(page, ipPageParam);
        return new Paging(iPage);
    }

}
