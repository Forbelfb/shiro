package com.lfb.shiro.mapper;

import com.lfb.shiro.entity.Role;
import com.lfb.shiro.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/7/8 16:09
 * @Description:
 */
@Mapper
public interface RoleMapper {

    @Select("select r.* from role r where r.id in (select ur.rid from user_role ur where ur.uid=#{id})")
    List<Role> findRole(int id);

}
