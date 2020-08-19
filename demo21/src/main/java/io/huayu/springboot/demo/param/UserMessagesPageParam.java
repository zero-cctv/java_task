package io.huayu.springboot.demo.param;

import io.huayu.springboot.framework.pagination.BasePageOrderParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <pre>
 * 用户留言表 查询参数对象
 * </pre>
 *
 * @author weiqian
 * @date 2020-07-03
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserMessagesPageParam对象", description = "用户留言表查询参数")
public class UserMessagesPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
