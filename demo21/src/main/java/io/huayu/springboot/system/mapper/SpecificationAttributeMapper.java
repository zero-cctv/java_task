package io.huayu.springboot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.huayu.springboot.system.entity.SpecificationAttribute;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * <p>
 * 规格属性 Mapper 接口
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Repository
public interface SpecificationAttributeMapper extends BaseMapper<SpecificationAttribute> {

    Boolean insertlist(ArrayList<String> arrayList);
}
