package io.huayu.springboot.mydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.huayu.springboot.mydemo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
