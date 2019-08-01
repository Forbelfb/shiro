package com.lfb.shiro.service;


import com.lfb.shiro.entity.User;
import com.lfb.shiro.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/6/28 20:09
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public User getUserById(Integer id){
        System.out.println("查询中");
        User user = userMapper.getUserById(id);
        return user;
    }

    public User findByUsername(String username){
        return userMapper.findByUsername(username);
    }

}
