package io.huayu.springboot.store.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.huayu.springboot.framework.common.api.ApiResult;
import io.huayu.springboot.framework.common.controller.BaseController;
import io.huayu.springboot.framework.shiro.util.JwtTokenUtil;
import io.huayu.springboot.framework.shiro.vo.LoginSysUserVo;
import io.huayu.springboot.store.vo.SpecificationTemplateVo;
import io.huayu.springboot.store.vo.SpecificationTemplateVoT;
import io.huayu.springboot.system.entity.Store;
import io.huayu.springboot.system.mapper.StoreMapper;
import io.huayu.springboot.system.service.ICategoryService;
import io.huayu.springboot.system.service.ISpecificationTemplateService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author luyong
 * @since 2020-08-13
 */
@Controller
@RequestMapping("/store")
public class Store_Controller extends BaseController {
    /*日志*/
    protected Log log = LogFactory.getLog(this.getClass());
    /**
     * 获取规格模板列表
     */
    @Autowired
    private ISpecificationTemplateService specificationTemplateService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private RedisTemplate redisTemplate;
    /*商家*/
    @Autowired
    private StoreMapper storeMapper;

    @PostMapping("/norms")
    @ResponseBody
//    @ApiOperation(value = "获取SpecificationTemplate对象详情", notes = "查看用户留言表", response = UserMessagesQueryVo.class)
    public ApiResult<Object> postSpecificationTemplate(@Validated @RequestBody SpecificationTemplateVo specificationTemplateVo) throws Exception {
        String token =  JwtTokenUtil.getToken();
        String tokenSha256 = DigestUtils.sha256Hex(token);
        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
        System.out.println(loginSysUserVo.toString());
        String id=String.valueOf(loginSysUserVo.getUid());
        /*获取商店id*/
        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",id);
        Store store= storeMapper.selectOne(queryWrapper);
        id=store.getId();
        try {
            if(!specificationTemplateService.addSpecificationTemplate(id, specificationTemplateVo)){
                return ApiResult.fail();
            }
        }catch (DuplicateKeyException de){
            return ApiResult.fail("命名错误");
        }
        return ApiResult.ok();
    }


    @GetMapping("/norms/{p}")
    @ResponseBody
//    @ApiOperation(value = "获取SpecificationTemplate对象详情", notes = "查看用户留言表", response = UserMessagesQueryVo.class)
    public ApiResult<Object> getTemplateList(@RequestParam(name = "p",defaultValue = "0") String p) throws Exception {
        /*获取商家id*/
        String token =  JwtTokenUtil.getToken();
        String tokenSha256 = DigestUtils.sha256Hex(token);
        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
        log.debug(loginSysUserVo.toString());
        String id=String.valueOf(loginSysUserVo.getUid());
        /*获取商店id*/
        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",id);
        Store store= storeMapper.selectOne(queryWrapper);
        id=store.getId();
        Object  Templatelist= specificationTemplateService.findSpecificationTemplateByUId(p, id);
        System.out.println(Templatelist.toString());
        return ApiResult.ok(Templatelist);
    }

    @DeleteMapping("/norms")
    @ResponseBody
    public ApiResult<Object> deleteTemplate( @RequestParam(name = "模板id") String tid) throws Exception{
        try {
            if(!specificationTemplateService.deleteSpecificationTemplate(tid)){
                return ApiResult.fail();
            }
        }catch (DuplicateKeyException de){
            return ApiResult.fail("命名错误");
        }
        return ApiResult.ok();
    }

    @PutMapping("/norms")
    @ResponseBody
    public ApiResult<Object> putTemplate(@Validated @RequestBody SpecificationTemplateVoT specificationTemplateVoT) throws Exception{
        try {
            if(!specificationTemplateService.putSpecificationTemplate(specificationTemplateVoT)){
                return ApiResult.fail();
            }
        }catch (DuplicateKeyException de){

            return ApiResult.fail("命名错误");
        }
        return ApiResult.ok();
    }

    @GetMapping("/norms/seach")
    @ResponseBody
    public ApiResult<Object> findTemplateList(@RequestParam(name = "模板名" ) String t_name) throws Exception {
        /*获取商家id*/
        String token =  JwtTokenUtil.getToken();
        String tokenSha256 = DigestUtils.sha256Hex(token);
        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
        log.debug(loginSysUserVo.toString());
        String id=String.valueOf(loginSysUserVo.getUid());
        /*获取商店id*/
        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("u_id",id);
        Store store= storeMapper.selectOne(queryWrapper);
        id=store.getId();
        Object  Templatelist= specificationTemplateService.searchTemplateByName(t_name);
        System.out.println(Templatelist.toString());
        return ApiResult.ok(Templatelist);
    }

    @GetMapping("/category/{p}")
    @ResponseBody
    public ApiResult<Object> findCategoryList(@RequestParam(name = "父类id" ,required = false,defaultValue ="") String fid,@RequestParam(name = "p",defaultValue = "0",required = true) String p) throws Exception {
        /*获取用户sid*/
        String token =  JwtTokenUtil.getToken();
        String tokenSha256 = DigestUtils.sha256Hex(token);
        LoginSysUserVo loginSysUserVo = (LoginSysUserVo) redisTemplate.opsForValue().get(tokenSha256);
        log.debug(loginSysUserVo.toString());
        String id=String.valueOf(loginSysUserVo.getSId());

        /*获取*/

        Object  Categorylist= categoryService.findCategoryListById(p,id,fid);
        System.out.println(Categorylist.toString());
        return ApiResult.ok(Categorylist);
    }
}
