package io.huayu.springboot.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.huayu.springboot.framework.common.service.impl.BaseServiceImpl;
import io.huayu.springboot.store.dto.Norms;
import io.huayu.springboot.store.dto.model.Node;
import io.huayu.springboot.store.dto.model.TemplateBigDto;
import io.huayu.springboot.store.dto.model.TemplateDto;
import io.huayu.springboot.store.dto.model.TemplateList;
import io.huayu.springboot.store.util.ConvertList2PageVOUtil;
import io.huayu.springboot.store.vo.Pagevo;
import io.huayu.springboot.store.vo.SpecificationTemplateVo;
import io.huayu.springboot.store.vo.SpecificationTemplateVoT;
import io.huayu.springboot.system.entity.Specification;
import io.huayu.springboot.system.entity.SpecificationAttribute;
import io.huayu.springboot.system.entity.SpecificationTemplate;
import io.huayu.springboot.system.entity.Store;
import io.huayu.springboot.system.exception.SqlException;
import io.huayu.springboot.system.mapper.SpecificationAttributeMapper;
import io.huayu.springboot.system.mapper.SpecificationMapper;
import io.huayu.springboot.system.mapper.SpecificationTemplateMapper;
import io.huayu.springboot.system.service.ISpecificationTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 规格模板 服务实现类
 * </p>
 *
 * @author luyong
 * @since 2020-08-14
 */
@Service
public class SpecificationTemplateServiceImpl extends BaseServiceImpl<SpecificationTemplateMapper, SpecificationTemplate> implements ISpecificationTemplateService {
    /*模板*/
    @Autowired
    private SpecificationTemplateMapper specificationTemplateMapper;
    /*规格*/
    @Autowired
    private SpecificationMapper specificationMapper;
    /*规格属性*/
    @Autowired
    private SpecificationAttributeMapper specificationAttributeMapper;

    private Store store;


    /*通过商家id，查询模板列表*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Object findSpecificationTemplateByUId(String p, Serializable id) {

        ArrayList<TemplateList> templateArrayList = specificationTemplateMapper.findTemplatelistByid((String) id);

//        /*获取模板列表*/
//
//        List<SpecificationTemplate> templateArrayList=specificationTemplateMapper.selectList(new QueryWrapper<SpecificationTemplate>().eq("uid",store.getId()));
//        /*获取规格列表*/
//        for (SpecificationTemplate specificationTemplate:templateArrayList) {//获取模板
//
//            List<Specification> specificationArrayList=specificationMapper.selectList(new QueryWrapper<Specification>().eq("t_id",specificationTemplate.getId()));
//
//            for (Specification specification:specificationArrayList) {//获取规格
//
//                List<SpecificationAttribute> AttributeArrayList=specificationAttributeMapper.selectList(new QueryWrapper<SpecificationAttribute>().eq("s_id",specification.getId()));
//                return AttributeArrayList;
//            }
//        }
//        TemplateList templateVo=new TemplateList();
//        ArrayList<Node> nodeArrayList=new ArrayList<>();
//        Node node=new Node();
        HashMap<String, ArrayList<Node>> hashMap = new HashMap<>();
        HashMap<String, ArrayList<TemplateDto>> hashMap01 = new HashMap<>();
        ArrayList<TemplateBigDto> arrayList = new ArrayList<>();
        System.out.println(templateArrayList.toString());
        /*创建一个hashMap，《sid，nodelist》*/
        for (TemplateList templateList : templateArrayList) {

            Node temp = new Node(templateList.getAid(), templateList.getAName());
            if (!hashMap.containsKey(templateList.getSid())) {
                ArrayList<Node> nodeList = new ArrayList<>();
                nodeList.add(temp);
                hashMap.put(templateList.getSid(), nodeList);
            } else {
                hashMap.get(templateList.getSid()).add(temp);
            }
        }


        /*创建一个hashMap01，《tid，volist》*/
        for (TemplateList templateList : templateArrayList) {
            /*hashMap01获取Tid
             * 没有,创建一个T<tid,volist>,并且新建一个BVo，把volist赋予BVo的value，把BVo给arrayList《BVo》
             * 有的话T<tid,volist>里volist.add(vo)
             * */
            if (!hashMap01.containsKey(templateList.getTid())) {

                if (hashMap.containsKey(templateList.getSid())) {


                    TemplateDto templateDto1 = new TemplateDto();
                    templateDto1.setId(templateList.getSid());
                    templateDto1.setName(templateList.getSName());
                    templateDto1.setValue(hashMap.get(templateList.getSid()));
                    ArrayList<TemplateDto> templateDtoArrayList = new ArrayList<>();
                    templateDtoArrayList.add(templateDto1);

                    hashMap01.put(templateList.getTid(), templateDtoArrayList);
                    hashMap.remove(templateList.getSid());

                    /*hashmap01每创建一个tid，把tid_value的对象传到一个BVo对象，后面修改tid_value的对象时会修改BVo对象*/
                    TemplateBigDto templateBigDto = new TemplateBigDto();
                    templateBigDto.setId(templateList.getTid());
                    templateBigDto.setName(templateList.getTName());
                    templateBigDto.setValue(hashMap01.get(templateList.getTid()));
                    templateBigDto.setCreateTime(templateList.getCreateTime());
                    templateBigDto.setUpdateTime(templateList.getUpdateTime());
                    arrayList.add(templateBigDto);
                }
            } else {
                if (hashMap.containsKey(templateList.getSid())) {

                    TemplateDto templateDto1 = new TemplateDto();
                    templateDto1.setId(templateList.getSid());
                    templateDto1.setName(templateList.getSName());
                    templateDto1.setValue(hashMap.get(templateList.getSid()));

                    hashMap01.get(templateList.getTid()).add(templateDto1);
                    hashMap.remove(templateList.getSid());
                }
            }

        }


        /*把整理的数据封装到Pagevo，返回*/
        PageRequest request = PageRequest.of(Integer.parseInt(p), 5);
        Page<TemplateBigDto> page = ConvertList2PageVOUtil.listConvertToPage(arrayList, request);
        Pagevo pagevo = new Pagevo();
        pagevo.setTotal(String.valueOf(page.getTotalPages()));
        pagevo.setCurrent(String.valueOf(page.getNumber()));
        pagevo.setArrayList(page.getContent());
        pagevo.setSize(String.valueOf(page.getSize()));
        System.out.println(pagevo);
        return pagevo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addSpecificationTemplate(Serializable id, SpecificationTemplateVo specificationTemplateVo) throws Exception {
        SpecificationTemplate specificationTemplate = new SpecificationTemplate();
        specificationTemplate.setUid((String) id);
        specificationTemplate.setName(specificationTemplateVo.getS_name());
        specificationTemplateMapper.insert(specificationTemplate);
        String tid = specificationTemplate.getId();

        Specification specification = null;
        SpecificationAttribute specificationAttribute = null;
        ArrayList<Norms> norms = specificationTemplateVo.getArray();
        int i = 0;
        for (Norms norm : norms) {
            specification = new Specification();
            specification.setTId(tid);
            specification.setName(norm.getN_name());
            specification.setRank(i++);
            specificationMapper.insert(specification);
            for (String value : norm.getN_value()) {
                specificationAttribute = new SpecificationAttribute();
                specificationAttribute.setSId(specification.getId());
                specificationAttribute.setName(value);
                specificationAttributeMapper.insert(specificationAttribute);
            }
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean putSpecificationTemplate(SpecificationTemplateVoT specificationTemplateVoT) throws Exception {

        if (specificationTemplateMapper.selectById(specificationTemplateVoT.getTid()) == null) {
            throw new SqlException("没有该模板");
        }
        SpecificationTemplate specificationTemplate = new SpecificationTemplate();
        specificationTemplate.setId(specificationTemplateVoT.getTid());
        specificationTemplate.setName(specificationTemplateVoT.getS_name());
        specificationTemplateMapper.updateById(specificationTemplate);
        String tid = specificationTemplate.getId();
        deleteSpecificationByTid(tid);
        Specification specification = null;
        SpecificationAttribute specificationAttribute = null;
        ArrayList<Norms> norms = specificationTemplateVoT.getArray();
        int i = 0;
        for (Norms norm : norms) {
            specification = new Specification();
            specification.setTId(tid);
            specification.setName(norm.getN_name());
            specification.setRank(i++);
            specificationMapper.insert(specification);
            for (String value : norm.getN_value()) {
                specificationAttribute = new SpecificationAttribute();
                specificationAttribute.setSId(specification.getId());
                specificationAttribute.setName(value);
                specificationAttributeMapper.insert(specificationAttribute);
            }
        }
        return true;
    }

    /*删除模板以及规格*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteSpecificationTemplate(String tid) {

        if (specificationTemplateMapper.selectById(tid) == null) {
            log.error("没有该模板");
            throw new SqlException("没有该模板");
        }
        deleteSpecificationByTid(tid);
        specificationTemplateMapper.deleteById(tid);


        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Object searchTemplateByName(String name) {
        ArrayList<TemplateList> templateArrayList = specificationTemplateMapper.searchTemplatelistByName(name);
        HashMap<String, ArrayList<Node>> hashMap = new HashMap<>();
        HashMap<String, ArrayList<TemplateDto>> hashMap01 = new HashMap<>();
        ArrayList<TemplateBigDto> arrayList = new ArrayList<>();
        System.out.println(templateArrayList.toString());
        /*创建一个hashMap，《sid，nodelist》*/
        for (TemplateList templateList : templateArrayList) {

            Node temp = new Node(templateList.getAid(), templateList.getAName());
            if (!hashMap.containsKey(templateList.getSid())) {
                ArrayList<Node> nodeList = new ArrayList<>();
                nodeList.add(temp);
                hashMap.put(templateList.getSid(), nodeList);
            } else {
                hashMap.get(templateList.getSid()).add(temp);
            }
        }


        /*创建一个hashMap01，《tid，volist》*/
        for (TemplateList templateList : templateArrayList) {
            /*hashMap01获取Tid
             * 没有,创建一个T<tid,volist>,并且新建一个BVo，把volist赋予BVo的value，把BVo给arrayList《BVo》
             * 有的话T<tid,volist>里volist.add(vo)
             * */
            if (!hashMap01.containsKey(templateList.getTid())) {

                if (hashMap.containsKey(templateList.getSid())) {


                    TemplateDto templateDto1 = new TemplateDto();
                    templateDto1.setId(templateList.getSid());
                    templateDto1.setName(templateList.getSName());
                    templateDto1.setValue(hashMap.get(templateList.getSid()));
                    ArrayList<TemplateDto> templateDtoArrayList = new ArrayList<>();
                    templateDtoArrayList.add(templateDto1);

                    hashMap01.put(templateList.getTid(), templateDtoArrayList);
                    hashMap.remove(templateList.getSid());

                    /*hashmap01每创建一个tid，把tid_value的对象传到一个BVo对象，后面修改tid_value的对象时会修改BVo对象*/
                    TemplateBigDto templateBigDto = new TemplateBigDto();
                    templateBigDto.setId(templateList.getTid());
                    templateBigDto.setName(templateList.getTName());
                    templateBigDto.setValue(hashMap01.get(templateList.getTid()));
                    templateBigDto.setCreateTime(templateList.getCreateTime());
                    templateBigDto.setUpdateTime(templateList.getUpdateTime());
                    arrayList.add(templateBigDto);
                }
            } else {
                if (hashMap.containsKey(templateList.getSid())) {

                    TemplateDto templateDto1 = new TemplateDto();
                    templateDto1.setId(templateList.getSid());
                    templateDto1.setName(templateList.getSName());
                    templateDto1.setValue(hashMap.get(templateList.getSid()));

                    hashMap01.get(templateList.getTid()).add(templateDto1);
                    hashMap.remove(templateList.getSid());
                }
            }

        }


        /*把整理的数据封装到Pagevo，返回*/
        PageRequest request = PageRequest.of(0, 5);
        Page<TemplateBigDto> page = ConvertList2PageVOUtil.listConvertToPage(arrayList, request);
        Pagevo pagevo = new Pagevo();
        pagevo.setTotal(String.valueOf(page.getTotalPages()));
        pagevo.setCurrent(String.valueOf(page.getNumber()));
        pagevo.setArrayList(page.getContent());
        pagevo.setSize(String.valueOf(page.getSize()));
        System.out.println(pagevo);
        return pagevo;
    }

    /*根据模板tid,删除与该模板相关联的规格与规格属性，但不删除模板自身
     **/
    @Transactional(rollbackFor = Exception.class)
    public void deleteSpecificationByTid(String tid) {
        try {
            List<Specification> specificationList = specificationMapper.selectList(new QueryWrapper<Specification>().eq("t_id", tid));
            for (Specification specification : specificationList) {
                specificationAttributeMapper.delete(new UpdateWrapper<SpecificationAttribute>().eq("s_id", specification.getId()));
                specificationMapper.deleteById(specification.getId());
            }
        } catch (Exception e) {
            log.error("规格删除失败");
            throw new SqlException("规格删除失败");
        }
    }


}
