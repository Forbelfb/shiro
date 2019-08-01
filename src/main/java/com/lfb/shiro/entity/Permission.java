package com.lfb.shiro.entity;

import lombok.Data;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/7/8 16:03
 * @Description:
 */
@Data
public class Permission {

    private Integer id;

    private String name;

    private String permission;

    private String detail;
}
