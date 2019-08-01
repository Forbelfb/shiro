package com.lfb.shiro.mapper;


import com.lfb.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/6/28 19:58
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user where id =#{id}")
    public User getUserById(Integer id);

    @Select("SELECT * FROM user where username =#{username}")
    User findByUsername(String username);
}
