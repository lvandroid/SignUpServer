package com.bsty.base.controller;

import com.bsty.base.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/user")
public class AuthorController {
    @PostMapping("/wxLogin")
    public ResponseData login(@RequestParam("code") String code) {
        log.debug("code:" + code);
        ResponseData responseData = ResponseData.newInstance();
        responseData.setSuccess();
        return responseData;
    }
}
