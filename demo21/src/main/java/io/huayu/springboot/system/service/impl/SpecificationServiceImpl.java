package io.huayu.springboot.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.huayu.springboot.system.entity.Specification;
import io.huayu.springboot.system.mapper.SpecificationMapper;
import io.huayu.springboot.system.service.ISpecificationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 规格 服务实现类
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Service
public class SpecificationServiceImpl extends ServiceImpl<SpecificationMapper, Specification> implements ISpecificationService {

}
