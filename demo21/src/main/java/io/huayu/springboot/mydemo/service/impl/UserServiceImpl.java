package io.huayu.springboot.mydemo.service.impl;

import io.huayu.springboot.framework.common.service.impl.BaseServiceImpl;
import io.huayu.springboot.mydemo.entity.User;
import io.huayu.springboot.mydemo.mapper.UserMapper;
import io.huayu.springboot.mydemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public User showUserByid(Long id) throws Exception {

        return userMapper.selectById(id);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addUser(User user) throws Exception {

        return userMapper.insert(user) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User deleteUserByid(Long id) throws Exception {
        User user=userMapper.selectById(id);
        return userMapper.deleteById(id) == 1?user:null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User saveUser(User user) throws Exception {
        int count=userMapper.updateById(user);
        return  count==1?userMapper.selectById(user.getId()):null;
}
}
