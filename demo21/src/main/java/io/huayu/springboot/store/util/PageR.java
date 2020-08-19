package io.huayu.springboot.store.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageR extends PageRequest {

    protected PageR(int page, int size, Sort sort) {
        super(page, size, sort);
    }
}
