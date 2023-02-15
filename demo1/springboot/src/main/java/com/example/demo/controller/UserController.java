package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Constants;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.entity.UserVo;
import com.example.demo.exception.ServiceException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.rmi.server.ServerCloneException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private UserService userService;



    @PostMapping("/login")
    public Result login(@RequestBody UserVo userVo){
        String username = userVo.getUsername();
        String password = userVo.getPassword();


        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new ServiceException(Constants.CODE_400,"用户名密码不能为空");
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", password);
        User user1;
        try{
            user1 = userService.getOne(wrapper);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }
        if (ObjectUtils.isNotEmpty(user1)){
            UserVo userVo1 = new UserVo();
            BeanUtils.copyProperties(user1,userVo1);
            return Result.success(userVo1);
        }else {
            throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
        }

    }

    @PostMapping("/register")
    public Result register(@RequestBody UserVo userVo){
        String username = userVo.getUsername();
        String password = userVo.getPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new ServiceException(Constants.CODE_400,"用户名密码不能为空");
        }

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", password);
        User user1;
        try{
            user1 = userService.getOne(wrapper);
        }catch (Exception e){
            throw new ServiceException(Constants.CODE_500,"系统错误");
        }

        if (ObjectUtils.isNotEmpty(user1)){
            throw new ServiceException(Constants.CODE_600,"用户名已经被注册");

        }else {
            user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            userService.save(user1);
            UserVo userVo1 = new UserVo();
            BeanUtils.copyProperties(user1,userVo1);
            return Result.success(userVo1);
        }

    }



    /**
     * 查询所有
     * @return
     */
    @GetMapping("/findAll")
    @ResponseBody
    public List<User> index(){
//        return userMapper.findAll();
        return userService.list();
    }

    /**
     * 新增和修改
     * @param user
     * @return
     */
//    @PostMapping("/save")
//    public Integer save(@RequestBody User user){
//        return userService.save(user);
//    }

//    @DeleteMapping("/{id}")
//    public Integer delete(@PathVariable Integer id){
//        return userMapper.delete(id);
//    }

    /**
     * 按id删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id){
       return userService.removeById(id);
    }

    @DeleteMapping("/delBatch")
    public boolean deleteBatch(@RequestParam List<Integer> ids){
        return userService.removeBatchByIds(ids);
    }

//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        pageNum = (pageNum -1)*pageSize;
//        int total =userMapper.selectTotal();
//        List<User> userList = userMapper.selectPage(pageNum, pageSize);
//        Map<String,Object> res = new HashMap<>();
//        res.put("total",total);
//        res.put("data",userList);
//        return res;
//    }

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username,
                                @RequestParam(defaultValue = "") String nickname){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username",username);

        if (StringUtils.isNotBlank(nickname)){
            queryWrapper.like("nickname",nickname);
        }

        queryWrapper.orderByDesc("id");
        return userService.page(page,queryWrapper);
    }

    @PostMapping("/saveOrUpdate")
    public boolean save(@RequestBody User user){
        return  userService.saveOrUpdate(user);
    }

}
