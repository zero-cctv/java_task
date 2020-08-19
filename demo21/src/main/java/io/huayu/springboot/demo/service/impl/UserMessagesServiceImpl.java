package io.huayu.springboot.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.huayu.springboot.demo.entity.UserMessages;
import io.huayu.springboot.demo.mapper.UserMessagesMapper;
import io.huayu.springboot.demo.param.UserMessagesPageParam;
import io.huayu.springboot.demo.service.UserMessagesService;
import io.huayu.springboot.demo.vo.UserMessagesQueryVo;
import io.huayu.springboot.framework.common.service.impl.BaseServiceImpl;
import io.huayu.springboot.framework.pagination.PageUtil;
import io.huayu.springboot.framework.pagination.Paging;
import io.huayu.springboot.my_demo.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;


/**
 * <pre>
 * 用户留言表 服务实现类
 * </pre>
 *
 * @author weiqian
 * @since 2020-07-03
 */
@Slf4j
@Service
public class UserMessagesServiceImpl extends BaseServiceImpl<UserMessagesMapper, UserMessages> implements UserMessagesService {

    @Autowired
    private UserMessagesMapper userMessagesMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveUserMessages(UserMessages userMessages) throws Exception {
        return super.save(userMessages);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateUserMessages(UserMessages userMessages) throws Exception {
        return super.updateById(userMessages);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteUserMessages(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public UserMessagesQueryVo getUserMessagesById(Serializable id) throws Exception {
        return userMessagesMapper.getUserMessagesById(id);
    }

    @Override
    public Paging<UserMessagesQueryVo> getUserMessagesPageList(UserMessagesPageParam userMessagesPageParam) throws Exception {
        Page page = PageUtil.getPage(userMessagesPageParam, OrderItem.desc(getLambdaColumn(UserMessages::getCreateTime)));
        IPage<UserMessagesQueryVo> iPage = userMessagesMapper.getUserMessagesPageList(page, userMessagesPageParam);
        return new Paging(iPage);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Member selectByid(Long id) throws Exception{
        return userMessagesMapper.selectByid(id);
    }
 }
