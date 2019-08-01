package com.lfb.shiro.service;

import com.lfb.shiro.entity.Permission;
import com.lfb.shiro.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/7/8 18:00
 * @Description:
 */
@Service
public class PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    public List<Permission> findPermission(List<Integer> ids){
        List<Permission> permissions = permissionMapper.findPermission(ids);
        return permissions;
    }
}
