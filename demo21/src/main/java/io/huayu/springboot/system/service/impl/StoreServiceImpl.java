package io.huayu.springboot.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.huayu.springboot.system.entity.Store;
import io.huayu.springboot.system.mapper.StoreMapper;
import io.huayu.springboot.system.service.IStoreService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements IStoreService {

}
