package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {

//    @Resource
//    private UserMapper userMapper;

//    public int save(User user){
//        //user没有id表示新增，有id表示更新
//        if(user.getId() == null){
//           return userMapper.insert(user);
//        }else {
//           return userMapper.update(user);
//        }
//    }


}
