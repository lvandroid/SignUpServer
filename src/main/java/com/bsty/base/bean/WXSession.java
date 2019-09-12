package com.bsty.base.bean;

import lombok.Data;

/**
 * 值	说明	最低版本
 * -1	系统繁忙，此时请开发者稍候再试
 * 0	请求成功
 * 40029	code 无效
 * 45011	频率限制，每个用户每分钟100次
 */
@Data
public class WXSession {
    private String openid;//用户唯一标识
    private String session_key;//会话密钥
    private String unionid;//用户在开放平台的唯一标识符，在满足 UnionID 下发条件的情况下会返回
    private int errcode;//错误码
    private String errmsg;//错误信息
}
