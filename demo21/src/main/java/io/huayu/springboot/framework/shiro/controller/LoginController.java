
package io.huayu.springboot.framework.shiro.controller;

import io.huayu.springboot.framework.common.api.ApiResult;
import io.huayu.springboot.framework.shiro.param.LoginParam;
import io.huayu.springboot.framework.shiro.service.LoginService;
import io.huayu.springboot.framework.shiro.util.JwtTokenUtil;
import io.huayu.springboot.framework.shiro.vo.LoginSysUserVo;
import io.huayu.springboot.system.service.SysUserService;
import io.huayu.springboot.system.vo.LoginSysUserTokenVo;
import io.huayu.springboot.system.vo.SysUserQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆控制器
 *
 * @author weiqian
 * @since 2020-03-23
 **/
@Api("登陆控制器")
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    @ApiOperation(value = "登陆", notes = "系统用户登陆", response = LoginSysUserTokenVo.class)
    public ApiResult login(@Validated @RequestBody LoginParam loginParam, HttpServletResponse response) throws Exception {
        LoginSysUserTokenVo loginSysUserTokenVo = loginService.login(loginParam);

        String token =  loginSysUserTokenVo.getToken();
        String tokenSha256 = DigestUtils.sha256Hex(token);
        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
        loginSysUserVo.setToken(token);
        return ApiResult.ok(loginSysUserVo);

//        // 设置token响应头
//        response.setHeader(JwtTokenUtil.getTokenName(), loginSysUserTokenVo.getToken());
//        return ApiResult.ok(loginSysUserTokenVo.getToken(), "登陆成功");
//        return ApiResult.okMap("token",loginSysUserTokenVo.getToken());
    }


    /**
     * 根据token获取系统登陆用户信息
     */
    @GetMapping("/getSysUserInfo")
    @ApiOperation(value = "根据token获取系统登陆用户信息", response = SysUserQueryVo.class)
    public ApiResult<SysUserQueryVo> getSysUser() throws Exception {
        String token =  JwtTokenUtil.getToken();
        String tokenSha256 = DigestUtils.sha256Hex(token);
        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
        return ApiResult.ok(loginSysUserVo);

//        String json = "{\n" +
//                "    roles: ['admin'],\n" +
//                "    introduction: 'I am a super administrator',\n" +
//                "    avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',\n" +
//                "    name: 'Super Admin'\n" +
//                "  }";
//        JSON array = JSON.parseObject(json);
//
//        return ApiResult.ok(array);
    }

    @PostMapping("/logout")
    public ApiResult logout(HttpServletRequest request) throws Exception {
        loginService.logout(request);
        return ApiResult.ok("退出成功");
    }

}
