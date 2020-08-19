package io.huayu.springboot.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.huayu.springboot.store.dto.model.TemplateList;
import io.huayu.springboot.system.entity.SpecificationTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * <p>
 * 规格模板 Mapper 接口
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Repository
public interface SpecificationTemplateMapper extends BaseMapper<SpecificationTemplate> {
    //
//    @Select(" SELECT t.id tid,t.`name` t_name,s.id sid,s.`name` s_name,a.id aid,a.`name` a_name,t.create_time,t.update_time FROM specification_template t  JOIN specification s JOIN specification_attribute a  on s.t_id=t.id and s.id=a.s_id where uid=#{id}")
    ArrayList<TemplateList> findTemplatelistByid(String id);

    ArrayList<TemplateList> searchTemplatelistByName(String name);
}
