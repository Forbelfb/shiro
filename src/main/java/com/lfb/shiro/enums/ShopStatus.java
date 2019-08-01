package com.lfb.shiro.enums;

import lombok.Getter;

/**
 * 商品状态统一定义编码
 * @author :Bling
 * @version V1.0
 * @Description:
 * @date 2018/11/26 17:14
 */
@Getter
public enum  ShopStatus {

    NORMAL(0,"正常上线"),
    NOT_ONLINE(1,"下线"),
    NOT_NORMAL(2,"异常");

    private Integer status;
    private String msg;

    ShopStatus(int code,String msg){
        this.status = code;
        this.msg = msg;
    }

}
