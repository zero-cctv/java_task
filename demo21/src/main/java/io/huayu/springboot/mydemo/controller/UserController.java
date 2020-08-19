package io.huayu.springboot.mydemo.controller;

import io.huayu.springboot.framework.common.api.ApiResult;
import io.huayu.springboot.framework.common.controller.BaseController;
import io.huayu.springboot.mydemo.entity.User;
import io.huayu.springboot.mydemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/userlist1")
@Api("用户管理表 API")
public class UserController extends BaseController {

    @Autowired
    private UserService usersService;

    @Autowired
    private RedisTemplate redisTemplate;


//    /**
//     * 添加用户
//     */
//    @PostMapping("/add")
//    @ApiOperation(value = "添加User对象", notes = "添加用户", response = ApiResult.class)
//    public ApiResult<Boolean> addUserMessages(@Validated @RequestBody User user) throws Exception {
//        String token =  JwtTokenUtil.getToken();
//        String tokenSha256 = DigestUtils.sha256Hex(token);
//        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
//        Integer uid = loginSysUserVo.getUid().intValue();
//        userMessages.setUid(uid);
//        boolean flag = userMessagesService.saveUserMessages(userMessages);
//        return ApiResult.result(flag);
//    }

    /**
     * 通过输入id获取用户信息，返回用户信息
     */
    @GetMapping("/info1/{id}")
    @ApiOperation(value = "获取User详情", notes = "通过输入id获取用户信息，返回用户信息", response = User.class)
    public ApiResult<User> getUser(@PathVariable("id") Long id) throws Exception {
        User user = usersService.showUserByid(id);
        return ApiResult.ok(user);
    }
    /*通过输入的用户，添加用户，返回boolean*/
    @PostMapping("/add1")
    @ApiOperation(value = "添加User", notes = "添加用户", response = Boolean.class)
    public ApiResult<Boolean> addUser(@Validated @RequestBody User user) throws Exception {
        boolean flag=usersService.addUser(user);
        return ApiResult.result(flag);
    }
    /*通过输入用户id，修改用户，并把修改后的用户返回
    * */
    @PatchMapping("/save1")
    @ApiOperation(value = "修改User", notes = "修改用户", response = User.class)
    public ApiResult<User> saveUser(@Validated @RequestBody User user) throws Exception{
        return ApiResult.ok(usersService.saveUser(user));
    }
    /**通过id删除用户，并把删除的用户返回
     * */
    @DeleteMapping("/del1/{id}")
    @ApiOperation(value = "删除User", notes = "删除用户", response = User.class)
    public ApiResult<User> delUser(@PathVariable("id") Long id) throws Exception {
        return ApiResult.ok(usersService.deleteUserByid(id));
    }
}

