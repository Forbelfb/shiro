package com.lfb.shiro.service;

import com.lfb.shiro.entity.Role;
import com.lfb.shiro.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/7/8 17:58
 * @Description:
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> findRole(Integer id){
        List<Role> userRole = roleMapper.findRole(id);
        return userRole;
    }

}
