package com.lfb.shiro.enums;

import lombok.Getter;

/**
 * @author :Bling
 * @version V1.0
 * @Description:
 * @date 2018/12/17 17:37
 */
@Getter
public enum IndentPayEnum {

    NOT_PAY(0,"未支付"),
    PAY(1,"已支付");

    private Integer status;
    private String msg;

    IndentPayEnum(int code,String msg){
        this.status = code;
        this.msg = msg;
    }

}
