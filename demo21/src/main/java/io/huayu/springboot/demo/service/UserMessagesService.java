package io.huayu.springboot.demo.service;

import io.huayu.springboot.demo.entity.UserMessages;
import io.huayu.springboot.demo.param.UserMessagesPageParam;
import io.huayu.springboot.demo.vo.UserMessagesQueryVo;
import io.huayu.springboot.framework.common.service.BaseService;
import io.huayu.springboot.framework.pagination.Paging;
import io.huayu.springboot.my_demo.entity.Member;

import java.io.Serializable;

/**
 * <pre>
 * 用户留言表 服务类
 * </pre>
 *
 * @author weiqian
 * @since 2020-07-03
 */
public interface UserMessagesService extends BaseService<UserMessages> {

    /**
     * 保存
     *
     * @param userMessages
     * @return
     * @throws Exception
     */
    boolean saveUserMessages(UserMessages userMessages) throws Exception;

    /**
     * 修改
     *
     * @param userMessages
     * @return
     * @throws Exception
     */
    boolean updateUserMessages(UserMessages userMessages) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteUserMessages(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    UserMessagesQueryVo getUserMessagesById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param userMessagesPageParam
     * @return
     * @throws Exception
     */
    Paging<UserMessagesQueryVo> getUserMessagesPageList(UserMessagesPageParam userMessagesPageParam) throws Exception;

    Member selectByid(Long id) throws Exception;
}
