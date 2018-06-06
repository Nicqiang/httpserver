package com.nicqiang.test.httpserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by
 *
 * @Author: nicqiang
 * @DATE: 2018/6/6
 */
@RestController
@RequestMapping("/mock")
public class MockServerController {

    @RequestMapping("/test")
    public Object test(){
        return "success";
    }


}
