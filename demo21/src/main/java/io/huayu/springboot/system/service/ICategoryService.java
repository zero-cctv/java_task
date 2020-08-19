package io.huayu.springboot.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.huayu.springboot.system.entity.Category;

import java.io.Serializable;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author luyong
 * @since 2020-08-18
 */
public interface ICategoryService extends IService<Category> {
    Object findCategoryListById(String p, Serializable id, String fid);
}
