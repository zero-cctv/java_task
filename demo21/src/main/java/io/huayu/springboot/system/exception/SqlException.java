package io.huayu.springboot.system.exception;

import io.huayu.springboot.framework.common.exception.SpringBootPlusException;

public class SqlException extends SpringBootPlusException {
    public SqlException(String message) {
        super(message);
    }

    public SqlException(Integer errorCode, String message) {
        super(errorCode, message);
    }
}
