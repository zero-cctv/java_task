package io.huayu.springboot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.huayu.springboot.store.convert.SysCategoryConvert;
import io.huayu.springboot.store.vo.CategoryVo;
import io.huayu.springboot.system.entity.Category;
import io.huayu.springboot.system.mapper.CategoryMapper;
import io.huayu.springboot.system.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author luyong
 * @since 2020-08-18
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Object findCategoryListById(String p, Serializable id, String fid) {
        int status;
        if (Objects.equals(fid, "")) {
            status = 0;
        } else {
            status = 1;
        }
        QueryWrapper<Category> queryWrapper = new QueryWrapper<Category>();
        queryWrapper.eq("s_id", id).eq("is_jd", 0).eq("status", status);
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);
        ArrayList<CategoryVo> categoryVoArrayList = new ArrayList<>();
        CategoryVo categoryVo = null;
        for (Category category : categoryList) {
            categoryVo = SysCategoryConvert.INSTANCE.CategorytoVo(category);
            categoryVoArrayList.add(categoryVo);
        }
//        LoginSysUserVo loginSysUserVo = SysUserConvert.INSTANCE.sysUserToLoginSysUserVo(sysUser);
        return categoryVoArrayList;
    }
}
