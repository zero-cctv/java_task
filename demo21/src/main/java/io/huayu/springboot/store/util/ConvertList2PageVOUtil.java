package io.huayu.springboot.store.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class ConvertList2PageVOUtil {
    /**
     * List 转 Page 对象
     *
     * @param list
     * @param page 必须大于0
     * @param size 必须大于0
     * @param <T>
     * @return
     */
    public static <T> Page<T> convertList2PageVO(final List<T> list, final Integer page, final Integer size) throws Exception {
        if (page < 1 && size < 1) {
            throw new Exception("页参数或页大小参数错误！");
        }
        Pageable pageable = new PageR(page - 1, size, null);
        if (CollectionUtils.isEmpty(list)) {
            return new PageImpl<>(new ArrayList<>(0), pageable, 0);
        }
        final List<T> ingredientVOS = list;
        final List<List<T>> partition = Lists.partition(list, pageable.getPageSize());
        List<T> pageContent = partition.get(pageable.getPageNumber());
        return new PageImpl<>(pageContent, pageable, ingredientVOS.size());
    }

    /**
     * List 转 Page 对象
     *
     * @param list
     * @param pageable 分页参数
     * @param <T>
     * @return
     */
    public static <T> Page<T> convertList2PageVO(final List<T> list, final Pageable pageable) {
        if (CollectionUtils.isEmpty(list)) {
            return new PageImpl<>(new ArrayList<>(0), pageable, 0);
        }
        final List<T> ingredientVOS = list;
        final List<List<T>> partition = Lists.partition(list, pageable.getPageSize());
        List<T> pageContent = partition.get(pageable.getPageNumber());
        return new PageImpl<>(pageContent, pageable, ingredientVOS.size());
    }

    /*把list存入页面对象*/
    public static <T> Page<T> listConvertToPage(List<T> list, Pageable pageable) {
        int start = (int) pageable.getOffset();
        int end = (start + pageable.getPageSize()) > list.size() ? list.size() : (start + pageable.getPageSize());
        return new PageImpl<T>(list.subList(start, end), pageable, list.size());
    }

}