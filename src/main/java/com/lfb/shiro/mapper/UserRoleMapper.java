package com.lfb.shiro.mapper;

import com.lfb.shiro.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/7/8 16:10
 * @Description:
 */
@Mapper
public interface UserRoleMapper {

    @Select("select * from user_role where id=#{id}")
    List<UserRole> findUserRole(int id);
}
