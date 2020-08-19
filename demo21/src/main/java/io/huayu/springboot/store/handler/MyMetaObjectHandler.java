package io.huayu.springboot.store.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.huayu.springboot.store.until.DatetimeConvert;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Slf4j
@Component // 一定不要忘记把处理器加到IOC容器中！
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill.....");
        // setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("createTime", new DatetimeConvert().change(), metaObject);
        this.setFieldValByName("updateTime", new DatetimeConvert().change(), metaObject);
    }

    // 更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....");
        this.setFieldValByName("updateTime", new DatetimeConvert().change(), metaObject);
    }
}
