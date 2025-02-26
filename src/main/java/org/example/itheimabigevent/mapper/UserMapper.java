package org.example.itheimabigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.itheimabigevent.pojo.User;
@Mapper
public interface UserMapper {
    //查询
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);
    //添加
    @Insert("insert into user(username,password,create_time,update_time)"+"values (#{username},#{password},now(),now())")
    void add(String username, String password);

}
