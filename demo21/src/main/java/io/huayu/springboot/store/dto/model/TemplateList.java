package io.huayu.springboot.store.dto.model;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TemplateList extends BaseEntity {
    private String tid;
    private String tName;
    private String sid;
    private String sName;
    private String aid;
    private String aName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
