package io.huayu.springboot.test;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SerializedLambda;
import io.huayu.springboot.framework.util.LambdaColumn;
import io.huayu.springboot.system.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weiqian
 * @date 2019/12/21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {

    @Test
    public void test(){
       String column = new LambdaColumn<SysUser>().get(SysUser::getCreateTime);
        System.out.println("column = " + column);
    }

    @Test
    public void testx() {
        // LambdaColumnNameUtil.get(SysUser::getCreateTime);
        // LambdaColumnUtil.get(SysUser::getCreateTime);
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper();
//        lambdaQueryWrapper.eq()
        SerializedLambda lambda = LambdaUtils.resolve(SysUser::getCreateTime);
        String methodName = lambda.getImplMethodName();
        System.out.println("methodName = " + methodName);
        System.out.println(lambda);
        System.out.println(lambda.getImplClass());
        System.out.println(lambda.getImplClassName());
        System.out.println(lambda.getImplMethodName());
        System.out.println();

        String methodPropertyName = null;
        if (methodName.startsWith("get")){
            methodPropertyName = methodName.substring(3);

            methodPropertyName = methodPropertyName.substring(0, 1).toLowerCase() + methodPropertyName.substring(1);

        }
        System.out.println("methodPropertyName = " + methodPropertyName);


        Map<String,Map<String,String>> COLUMN_MAP = new ConcurrentHashMap<>();

        TableInfo tableInfo = TableInfoHelper.getTableInfo(SysUser.class);
        List<TableFieldInfo> tableFieldInfos = tableInfo.getFieldList();
        Map<String,String> map = new ConcurrentHashMap<>();
        for (TableFieldInfo tableFieldInfo : tableFieldInfos){

            String column = tableFieldInfo.getColumn();
            String property = tableFieldInfo.getProperty();

            map.put(property,column);

            System.out.println("column = " + column);
            System.out.println("property = " + property);
            System.out.println();
        }

        COLUMN_MAP.put(SysUser.class.getName(),map);
        System.out.println("map = " + map);
        System.out.println(JSON.toJSONString(map,true));
        System.out.println(map.get(methodPropertyName));
    }
}
