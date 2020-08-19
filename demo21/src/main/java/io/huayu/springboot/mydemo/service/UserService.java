package io.huayu.springboot.mydemo.service;

import io.huayu.springboot.framework.common.service.BaseService;
import io.huayu.springboot.mydemo.entity.User;

public interface UserService extends BaseService<User> {
    User showUserByid(Long id) throws Exception;
    boolean addUser(User user) throws Exception;
    User deleteUserByid(Long id) throws Exception;
    User saveUser(User user) throws Exception;
}
