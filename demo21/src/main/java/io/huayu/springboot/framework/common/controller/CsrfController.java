package io.huayu.springboot.framework.common.controller;

import io.huayu.springboot.framework.util.UUIDUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CSRF
 *
 * @author weiqian
 * @date 2019/12/10
 **/
@RestController
public class CsrfController {

    @RequestMapping(value = "/csrf", method = {RequestMethod.GET, RequestMethod.POST})
    public String csrf() {
        return UUIDUtil.getUuid();
    }

}
