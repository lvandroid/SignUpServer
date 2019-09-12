package com.bsty.base.controller;

import com.alibaba.fastjson.JSON;
import com.bsty.base.ResponseData;
import com.bsty.base.bean.WXSession;
import com.bsty.base.utils.HttpClientResult;
import com.bsty.base.utils.HttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/user")
public class AuthorController {
    private static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";

    @PostMapping("/wxLogin")
    public ResponseData login(@RequestParam("code") String code) {
        ResponseData responseData = ResponseData.newInstance();

        Map<String, String> params = new HashMap<>();
        params.put("appid", "wx59afc6e9203381ca");
        params.put("secret", "98b3c6d77105052ec51c50ab4e603eb6");
        params.put("js_code", code);
        params.put("grant_type", "authorization_code");
        try {
            HttpClientResult wxResult = HttpClientUtils.doGet(WX_LOGIN_URL, params);
            log.debug(wxResult.toString());
            WXSession wxSession = JSON.parseObject(wxResult.getContent(), WXSession.class);
            responseData.setSuccess(wxSession);
        } catch (Exception e) {
            responseData.setError();
            log.error(e.getMessage());
        }
        return responseData;
    }
}
