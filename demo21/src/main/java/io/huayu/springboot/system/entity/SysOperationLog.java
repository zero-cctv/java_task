package io.huayu.springboot.system.entity;

import io.huayu.springboot.framework.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统操作日志
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysOperationLog对象", description="系统操作日志")
public class SysOperationLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "日志名称")
    private String name;

    @ApiModelProperty(value = "IP")
    private String ip;

    @ApiModelProperty(value = "区域")
    private String area;

    @ApiModelProperty(value = "全路径")
    private String path;

    @ApiModelProperty(value = "访问路径")
    private String url;

    @ApiModelProperty(value = "模块名称")
    private String moduleName;

    @ApiModelProperty(value = "包名")
    private String packageName;

    @ApiModelProperty(value = "类名")
    private String className;

    @ApiModelProperty(value = "方法名称")
    private String methodName;

    @ApiModelProperty(value = "请求方式，GET/POST")
    private String requestMethod;

    @ApiModelProperty(value = "内容类型")
    private String contentType;

    @ApiModelProperty(value = "是否是JSON请求映射参数")
    private Boolean requestBody;

    @ApiModelProperty(value = "请求参数")
    private String param;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "0:其它,1:新增,2:修改,3:删除,4:详情查询,5:所有列表,6:分页列表,7:其它查询,8:上传文件")
    private Integer type;

    @ApiModelProperty(value = "0:失败,1:成功")
    private Boolean success;

    @ApiModelProperty(value = "响应结果状态码")
    private Integer code;

    @ApiModelProperty(value = "响应结果消息")
    private String msg;

    @ApiModelProperty(value = "异常类名称")
    private String exceptionName;

    @ApiModelProperty(value = "异常信息")
    private String exceptionMsg;

    @ApiModelProperty(value = "响应结果")
    private String result;

    @ApiModelProperty(value = "浏览器名称")
    private String browserName;

    @ApiModelProperty(value = "浏览器版本")
    private String browserVersion;

    @ApiModelProperty(value = "浏览器引擎名称")
    private String engineName;

    @ApiModelProperty(value = "浏览器引擎版本")
    private String engineVersion;

    @ApiModelProperty(value = "系统名称")
    private String osName;

    @ApiModelProperty(value = "平台名称")
    private String platformName;

    @ApiModelProperty(value = "是否是手机,0:否,1:是")
    private Boolean mobile;

    @ApiModelProperty(value = "移动端设备名称")
    private String deviceName;

    @ApiModelProperty(value = "移动端设备型号")
    private String deviceModel;

    @ApiModelProperty(value = "是否记录请求参数，0：不记录，1：记录")
    private Boolean recordParam;

    @ApiModelProperty(value = "是否记录响应结果，0:不记录，1:记录")
    private Boolean recordResult;

    @ApiModelProperty(value = "是否记录客户端信息，0：不记录，1：记录")
    private Boolean recordClient;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime updateTime;


}
