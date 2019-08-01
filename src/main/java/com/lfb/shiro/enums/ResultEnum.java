package com.lfb.shiro.enums;

import lombok.Getter;

/**
 * 返回值错误统一定义编码
 * @author :Bling
 * @version V1.0
 * @Description:
 * @date 2018/11/24 22:38
 */
@Getter
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    FAIL_LOGIN(1,"登录不成功"),
    FAIL_GETOPENID(2,"获取openid失败"),
    FAIL_LOGIN_FREEZE(3,"账号被冻结"),
    FAIL_NOTUSER(4,"该用户不存在"),
    NULL_PARAMERTE(5,"参数为空"),
    NOT_LOGIN(6,"没有登录"),
    NOT_PERMISSION(7,"没有权限"),
    NOT_INDENTID(8,"订单不存在"),
    WEIXIN_ERROR_MONEY(9,"微信金额校验错误"),
    WEIXIN_ERROR_PARAMERTE(500,"请求参数非法，请核实!"),
    MIAODI_FAIL(10,"秒滴发送短信失败"),
    FAIL_VERIFICATION(11,"验证码错误"),
    ERROR_INDENT_PAY_STATE(12,"订单支付状态错误"),
    FAIL_INDENT_OPENID(13,"用户openID与订单openid不一致"),
    NOT_INDENT_PAY(14,"订单没有支付"),
    NOTUSER(300,"用户不存在"),
    ERROR_PASSWORD(301,"密码错误"),
    USERHASEXISTS(302,"用户名已存在"),
    FAIL_PHONE(303,"手机号不符"),
    FAIL_BOUNDPHONE(304,"手机号已绑定其他账号"),
    SHOPNAMEHASEXISTS(305,"商店名已被使用，请更改"),
    PHONECODEMISS(306,"未获取验证码或验证码错误"),
    FAIL_INPUT(307,"传入参数错误，请正确输入"),
    NOSELSE(308,"库存不足"),
    NOTPRODUCTID(309,"商品ID参数有错！"),
    CANTREFUND(310,"订单在此状态不允许该操作"),




    FAIL_SQL_INSERT(202,"数据库存储失败"),
    FAIL_EXIT_USERNAME(203,"用户名已使用，请重新注册"),
    FAIL_LOGIN_WRONGPSW(204,"账号和密码不匹配，请重新输入"),
    FAIL_NOTEXIT(205,"用户不存在"),
    FAIL_EXITID(206,"类目id已存在"),
    FAIL_EXITNAME(207,"类目名称已存在"),
    FAIL_SQL_DELETE(208,"删除失败"),
    FAIL_CATEGORY_NOTEXIST(209,"分类不存在"),
    FAIL_NOTLOGIN(210,"请先登录"),
    FAIL_NOTENOUGH(211,"来晚了一步，优惠券已经被抢光啦"),
    FAIL_ALREADYGET(212,"每个人限领一张"),
    FAIL_ISNOTBELONG(222,"只能对自家商品发起团购"),
    FAIL_ALREADYGROUPBUY(223,"此订单已经参加本次团购或不参与团购"),
    FAIL_ALREADYCLOSED(224,"来晚啦，本次团购活动已经结束"),
    FAIL_GROUPBUYNOTEXIST(225,"团购不存在"),
    FAIL_INDENTNOTEXIST(226,"订单不存在"),
    FAIL_INDENTNOJOIN(227,"订单没有参加团购或已经拼团成功"),
    FAIL_CANNOTCOMMENT(228,"订单不能被评价"),
    FAIL_COMMENTNOTEXIST(229,"评论不存在")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }


}
