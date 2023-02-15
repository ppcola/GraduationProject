package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {
//    @Select("SELECT * FROM `user`")
//    List<User> findAll();
//
//    @Insert("INSERT INTO `user`(username,password,nickname,email,phone,address) VALUES (#{username},#{password}," +
//            "#{nickname},#{email},#{phone},#{address})")
//    int insert(User user);

//    @Update("update user set username = #{username},password =#{password},nickname=#{nickname},email={#email}," +
//            "phone=#{phone},address={address}")
//    int update(User user);
//
//    @Delete("DELETE FROM user WHERE id = #{id}")
//    Integer delete(@Param("id") Integer id);
//
//    @Select("select * from user limit #{pageNum},#{pageSize}")
//    List<User> selectPage(Integer pageNum, Integer pageSize);
//
//    @Select("SELECT COUNT(1) FROM user")
//    int selectTotal();
}
