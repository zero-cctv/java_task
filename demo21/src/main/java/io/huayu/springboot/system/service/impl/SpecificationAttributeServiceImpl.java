package io.huayu.springboot.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.huayu.springboot.system.entity.SpecificationAttribute;
import io.huayu.springboot.system.mapper.SpecificationAttributeMapper;
import io.huayu.springboot.system.service.ISpecificationAttributeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 规格属性 服务实现类
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Service
public class SpecificationAttributeServiceImpl extends ServiceImpl<SpecificationAttributeMapper, SpecificationAttribute> implements ISpecificationAttributeService {

}
