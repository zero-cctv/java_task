package io.huayu.springboot.my_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.huayu.springboot.my_demo.entity.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Repository
public interface MemberMapper extends BaseMapper<Member> {

    @Select("select * from member where id=#{id}")
    Member selectByid(Long id) throws Exception;

    @Insert("insert into member(id,name,nickname,phoneNum,email) values(#{id},#{name},#{nickname},#{phoneNum},#{email})")
    int insert(Member member);


}
