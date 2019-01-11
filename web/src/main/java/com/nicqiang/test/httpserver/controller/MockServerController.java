package com.nicqiang.test.httpserver.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * Created by
 *
 * @Author: nicqiang
 * @DATE: 2018/6/6
 */
@Api(tags = "Mock")
@RestController
@RequestMapping("api/mock")
public class MockServerController {
    private static final Logger logger = LoggerFactory.getLogger(MockServerController.class);
    @ApiOperation(value = "测试接口")
    @RequestMapping("/get")
    public Object test(){
        logger.info("test");
        logger.debug("debug");
        //
        return "success";
    }

    /**
     * 参数在rest 路径中
     * @param value
     * @return
     */
    @ApiOperation("get value")
    @RequestMapping(value = "/get/{value}",method = {RequestMethod.GET,RequestMethod.POST})
    public String get(@ApiParam(required = true,name = "value",value = "值") @PathVariable String value){
        logger.info("get value: {}",value);
        return value;
    }

    @PostMapping("/post")
    public String getValue(@RequestBody JSONObject object){
        logger.info("value={}",JSONObject.toJSON(object));
        return JSONObject.toJSONString(object);
    }
    
    @GetMapping("/printValue")
    public String printValue(String value){
        logger.info("value={}",value);
        return value;
    }





}