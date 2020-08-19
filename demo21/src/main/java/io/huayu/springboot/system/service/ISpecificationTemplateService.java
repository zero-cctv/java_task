package io.huayu.springboot.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.huayu.springboot.store.vo.SpecificationTemplateVo;
import io.huayu.springboot.store.vo.SpecificationTemplateVoT;
import io.huayu.springboot.system.entity.SpecificationTemplate;

import java.io.Serializable;

/**
 * <p>
 * 规格模板 服务类
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
public interface ISpecificationTemplateService extends IService<SpecificationTemplate> {

    Object findSpecificationTemplateByUId(String p, Serializable id);

    Boolean addSpecificationTemplate(Serializable id, SpecificationTemplateVo specificationTemplateVo) throws Exception;

    Boolean putSpecificationTemplate(SpecificationTemplateVoT specificationTemplateVoT) throws Exception;

    Boolean deleteSpecificationTemplate(String id);

    Object searchTemplateByName(String name);
}
