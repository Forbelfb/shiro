package com.lfb.shiro.mapper;

import com.lfb.shiro.entity.Permission;
import com.lfb.shiro.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/7/8 16:09
 * @Description:
 */
@Mapper
public interface PermissionMapper {

//    @Select("select p.* from permission p where p.id in (select rp.pid from role_permission rp where rp.rid in #{ids})")
  //@Select("select p.* from permission p left join role_permission rp on rp.pid=p.id where rp.rid in #{ids} group by p.id")
//    @Select("select p.* from permission p where p.id=1")
    List<Permission> findPermission(@Param("ids") List<Integer> ids);

}
