package org.example.itheimabigevent.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.itheimabigevent.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //新增
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) " +
            "values (#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    //查询
    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);

    @Select("select * from category where id= #{id}")
    Category findById(Integer id);

    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void updateCategory(Category category);


}
