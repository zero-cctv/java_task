package io.huayu.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.huayu.springboot.demo.entity.UserMessages;
import io.huayu.springboot.demo.param.UserMessagesPageParam;
import io.huayu.springboot.demo.vo.UserMessagesQueryVo;
import io.huayu.springboot.my_demo.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 用户留言表 Mapper 接口
 * </pre>
 *
 * @author weiqian
 * @since 2020-07-03
 */
@Repository
public interface UserMessagesMapper extends BaseMapper<UserMessages> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    UserMessagesQueryVo getUserMessagesById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param userMessagesPageParam
     * @return
     */
    IPage<UserMessagesQueryVo> getUserMessagesPageList(@Param("page") Page page, @Param("param") UserMessagesPageParam userMessagesPageParam);

    @Select("select * from member where id=#{id}")
    Member selectByid(Long id) throws Exception;
}
