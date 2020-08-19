package io.huayu.springboot.my_demo.service.impl;

import io.huayu.springboot.my_demo.entity.Member;
import io.huayu.springboot.my_demo.mapper.MemberMapper;
import io.huayu.springboot.my_demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Member selectByid(Long id) throws Exception{
        return memberMapper.selectByid(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addMember(Member member) throws Exception {
        return memberMapper.insert(member) == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update(Member member) throws Exception {
        return memberMapper.updateById(member);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteMemberByid(Long id) {
        return memberMapper.deleteById(id);
    }
}
