/*
 * Copyright Huayu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.huayu.springboot.test;

import io.huayu.springboot.demo.service.impl.UserMessagesServiceImpl;
import io.huayu.springboot.system.entity.Specification;
import io.huayu.springboot.system.service.ISpecificationService;
import io.huayu.springboot.system.service.ISpecificationTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
    @Autowired
    private ISpecificationTemplateService specificationTemplateService;
    @Autowired
    private UserMessagesServiceImpl userMessagesService;
    @Autowired
    private ISpecificationService specificationService;
    @Test
    public void testget() throws Exception {
        System.out.println(specificationTemplateService.findSpecificationTemplateByUId("0","13246553").toString());
//        userMessagesService.getUserMessagesPageList(new UserMessagesPageParam());
        System.out.println("test");

    }
    @Test
    public void testadd() throws Exception {
//        SpecificationTemplateVoT specificationTemplateVo=new SpecificationTemplateVoT();
//        specificationTemplateVo.setS_name("瓜");
        Specification specification=null;
        ArrayList<Specification> specifications=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            specification=new Specification();
            specification.setTId(String.valueOf(i));
            specification.setName(String.valueOf(i)+"test");
            specification.setRank(i++);
            specifications.add(specification);
        }
        specificationService.saveBatch(specifications);
//        System.out.println(specificationTemplateService.addSpecificationTemplate("1564561456",specificationTemplateVo));
//        userMessagesService.getUserMessagesPageList(new UserMessagesPageParam());
        System.out.println("test");

    }
    @Test
    public void testput() throws Exception {
//        SpecificationTemplateVoT specificationTemplateVo=new SpecificationTemplateVoT();
//        specificationTemplateVo.setS_name("瓜");
        Specification specification=null;
        ArrayList<Specification> specifications=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            specification=new Specification();
            specification.setTId(String.valueOf(i));
            specification.setName(String.valueOf(i)+"test");
            specification.setRank(i++);
            specifications.add(specification);
        }
        specificationService.saveBatch(specifications);
//        System.out.println(specificationTemplateService.addSpecificationTemplate("1564561456",specificationTemplateVo));
//        userMessagesService.getUserMessagesPageList(new UserMessagesPageParam());
        System.out.println("test");

    }
}
