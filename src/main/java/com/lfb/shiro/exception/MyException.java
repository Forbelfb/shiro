package com.lfb.shiro.exception;


import com.lfb.shiro.enums.ResultEnum;
import lombok.Data;

/**
 * 定义本系统的自定义异常，用于本系统内部使用
 * @author :Bling
 * @version V1.0
 * @Description:
 * @date 2018/11/24 22:22
 */
@Data
public class MyException extends RuntimeException {

    private int code;

    public MyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
