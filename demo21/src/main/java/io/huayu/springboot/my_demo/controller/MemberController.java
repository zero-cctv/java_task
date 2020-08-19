package io.huayu.springboot.my_demo.controller;


import io.huayu.springboot.framework.common.api.ApiResult;
import io.huayu.springboot.framework.common.controller.BaseController;
import io.huayu.springboot.my_demo.entity.Member;
import io.huayu.springboot.my_demo.service.MemberService;
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
@RequestMapping("/member")
@Api("会员管理表 API")
public class MemberController extends BaseController {

    @Autowired
    private MemberService memberService;

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
     * 通过输入id获取会员信息，返回会员信息
     */
    @GetMapping("/memberinfo/{id}")
    @ApiOperation(value = "获取Member对象详情", notes = "通过输入id获取会员信息，返回会员信息", response = Member.class)
    public ApiResult<Member> getMember(@PathVariable("id") Long id) throws Exception {
        Member member = memberService.selectByid(id);
        return ApiResult.ok(member);
    }


    /*通过输入的会员，添加会员，返回boolean*/
    @PostMapping("/add")
    @ApiOperation(value = "添加Member", notes = "添加会员", response = Boolean.class)
    public ApiResult<Boolean> addUser(@Validated @RequestBody Member member) throws Exception {
        boolean flag=memberService.addMember(member);
        return ApiResult.result(flag);
    }
    /*通过输入用户id，修改用户，并把修改后的用户返回
     * */
    @PatchMapping("/update")
    @ApiOperation(value = "修改Member", notes = "修改会员", response = Member.class)
    public ApiResult<Member> saveMember(@Validated @RequestBody Member member) throws Exception{
        return ApiResult.ok(memberService.update(member));
    }
    /**通过id删除会员，并把删除的会员返回
     * */
    @DeleteMapping("/del/{id}")
    @ApiOperation(value = "删除Member", notes = "删除会员", response = Member.class)
    public ApiResult<Member> delUser(@PathVariable("id") Long id) throws Exception {
        return ApiResult.ok(memberService.deleteMemberByid(id));
    }
}