package io.huayu.springboot.store.vo;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.huayu.springboot.store.dto.model.TemplateBigDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Pagevo extends BaseEntity {
    private List<TemplateBigDto> arrayList;
    private String total;
    private String current;
    private String size;
}
