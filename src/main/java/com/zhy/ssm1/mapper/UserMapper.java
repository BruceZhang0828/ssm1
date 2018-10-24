package com.zhy.ssm1.mapper;

import com.zhy.ssm1.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface UserMapper {
    @Select("select * from `user` where id = #{id}")
    public User get(Integer id);
}
