package io.huayu.springboot.framework.pagination;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author weiqian
 * @date 2019/12/21
 **/
@Slf4j
public class PageUtil {


    /**
     * 获取mybatisplus分页对象
     *
     * @param basePageParam 分页参数
     * @return
     */
    public static Page getPage(BasePageParam basePageParam) {
        return getPage(basePageParam, null);
    }

    /**
     * 获取mybatisplus分页对象
     *
     * @param basePageParam 分页参数
     * @param defaultOrder  默认排序列
     * @return
     */
    public static Page getPage(BasePageParam basePageParam, OrderItem defaultOrder) {
        Page page = new Page(basePageParam.getPageIndex(), basePageParam.getPageSize());
        setPageOrderParam(basePageParam, defaultOrder, page);
        return page;
    }

    /**
     *
     *
     */


    /**
     * 如果是pageParam是OrderPageParam，并且不为空，则使用前端排序
     * 否则使用默认排序
     *
     * @param basePageParam 分页参数
     * @param defaultOrder  默认排序
     * @param page          分页对象
     */
    public static void setPageOrderParam(BasePageParam basePageParam, OrderItem defaultOrder, Page page) {
        if (basePageParam instanceof BasePageOrderParam) {
            BasePageOrderParam basePageOrderParam = (BasePageOrderParam) basePageParam;
            List<OrderItem> orderItems = basePageOrderParam.getPageSorts();
            if (CollectionUtils.isEmpty(orderItems)) {
                setDefaultOrder(page, defaultOrder);
            } else {
                page.setOrders(orderItems);
            }
        } else {
            setDefaultOrder(page, defaultOrder);
        }
    }

    public static void setDefaultOrder(Page page, OrderItem defaultOrder) {
        if (defaultOrder != null) {
            page.setOrders(Arrays.asList(defaultOrder));
        }
    }


    /**
     * 优化分页limit查询
     * 当不是第一页时，继续使用limit 0,10,表示是相同的条件查询
     * 不同条件查询时，返回的都是第一页
     * 当前页码设置为0
     * limit 0,10
     * 当不是第一页，且lastRowId不为空
     * current=0
     * 4,5,6 lastRowId：6
     * where id > 6 order by id limit 0,3
     *
     * @param basePageParam
     * @param defaultOrder
     * @param optimizeLimit
     * @return
     */
    public static Page getPage(BasePageParam basePageParam, boolean optimizeLimit) {


        return getPage(basePageParam, true, null);
    }

    public static Page getPage(BasePageParam basePageParam, boolean optimizeLimit, String optimizeLimitColumn) {
        if (StringUtils.isBlank(optimizeLimitColumn)) {
            optimizeLimitColumn = "id";
        }
        if (optimizeLimit) {
            Page page = new Page(0, basePageParam.getPageSize());
            page.setOrders(Arrays.asList(OrderItem.desc(optimizeLimitColumn)));
            return page;
        } else {
            return getPage(basePageParam, null);
        }
    }

    public static Long getLastRowLimitValue(IPage page) {
        return getLastRowLimitValue(page, null);
    }

    /**
     * 获取返回结果集中的最后一行的ID
     *
     * @param <T>
     * @param page
     * @param optimizeLimitColumn
     * @return
     */
    public static Long getLastRowLimitValue(IPage page, String optimizeLimitColumn) {
        if (StringUtils.isBlank(optimizeLimitColumn)) {
            optimizeLimitColumn = "id";
        }
        List list = page.getRecords();
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        Object object = list.get(list.size() - 1);
        if (object == null) {
            return null;
        }
        try {
            if (object instanceof Map) {
                Map map = (Map) object;
                return (Long) map.get(optimizeLimitColumn);
            }
            Class cls = object.getClass();
            Field field = cls.getDeclaredField(optimizeLimitColumn);
            field.setAccessible(true);
            return (Long) field.get(object);
        } catch (Exception e) {
            log.warn("lastRowId is null", e);
        }
        return null;
    }

}
