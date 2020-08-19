package io.huayu.springboot.my_demo.service;

import io.huayu.springboot.my_demo.entity.Member;

public interface MemberService {
    Member selectByid(Long id) throws Exception;

    boolean addMember(Member member) throws Exception;


    int update(Member member) throws Exception;

    int deleteMemberByid(Long id);
}
