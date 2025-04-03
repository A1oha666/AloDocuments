package org.example.AloDocuments.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.AloDocuments.pojo.User;
@Mapper
public interface UserMapper {
    //查询
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);
    //添加
    @Insert("insert into user(username,password,create_time,update_time)"+"values (#{username},#{password},now(),now())")
    void add(String username, String password);
    //更新
    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);

    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    //MySQL中的函数now()获取MySQL服务器上的时间
    void updateAvatar(String avatarUrl,Integer id);

    //更新密码
    @Update("update user set password=#{newPwd},update_time=now() where id=#{id}")
    void updatePwd(String newPwd,Integer id);

}
