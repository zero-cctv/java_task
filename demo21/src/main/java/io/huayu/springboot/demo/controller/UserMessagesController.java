package io.huayu.springboot.demo.controller;

import io.huayu.springboot.demo.entity.UserMessages;
import io.huayu.springboot.demo.service.UserMessagesService;
import io.huayu.springboot.demo.vo.UserMessagesQueryVo;
import io.huayu.springboot.framework.common.api.ApiResult;
import io.huayu.springboot.framework.common.controller.BaseController;
import io.huayu.springboot.framework.shiro.util.JwtTokenUtil;
import io.huayu.springboot.framework.shiro.vo.LoginSysUserVo;
import io.huayu.springboot.my_demo.entity.Member;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * 用户留言表 前端控制器
 * </pre>
 *
 * @author weiqian
 * @since 2020-07-03
 */
@Slf4j
@RestController
@RequestMapping("/userMessages")
@Api("用户留言表 API")
public class UserMessagesController extends BaseController {

    @Autowired
    private UserMessagesService userMessagesService;



    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加用户留言表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加UserMessages对象", notes = "添加用户留言表", response = ApiResult.class)
    public ApiResult<Boolean> addUserMessages(@Validated @RequestBody UserMessages userMessages) throws Exception {
        String token =  JwtTokenUtil.getToken();
        String tokenSha256 = DigestUtils.sha256Hex(token);
        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
        Integer uid = loginSysUserVo.getUid().intValue();
        userMessages.setUid(uid);
        boolean flag = userMessagesService.saveUserMessages(userMessages);
        return ApiResult.result(flag);
    }

    /**
     * 获取用户留言表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取UserMessages对象详情", notes = "查看用户留言表", response = UserMessagesQueryVo.class)
    public ApiResult<UserMessagesQueryVo> getUserMessages(@PathVariable("id") Long id) throws Exception {
        UserMessagesQueryVo userMessagesQueryVo = userMessagesService.getUserMessagesById(id);
        return ApiResult.ok(userMessagesQueryVo);
    }

    /**
     * 通过输入id获取会员信息，返回会员信息
     */
    @GetMapping("/memberinfo/{id}")
    @ApiOperation(value = "获取Member对象详情", notes = "通过输入id获取会员信息，返回会员信息", response = Member.class)
    public ApiResult<Member> getMember(@PathVariable("id") Long id) throws Exception {
        Member member = userMessagesService.selectByid(id);
        return ApiResult.ok(member);
    }

}

