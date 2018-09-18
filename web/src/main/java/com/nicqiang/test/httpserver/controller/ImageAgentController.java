package com.nicqiang.test.httpserver.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by
 *
 * @Author: nicqiang
 * @DATE: 2018/7/5
 */
@RequestMapping("/api/agent")
@Controller
public class ImageAgentController {
    private static final Logger logger = LoggerFactory.getLogger(ImageAgentController.class);
    private String URL = "http://www.pk.njau.edu.cn/images";


    @RequestMapping("/auth/{image}")
    public void imageAgent(@PathVariable String image){
        logger.info(image);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse res = requestAttributes.getResponse();
        HttpClient client  = new DefaultHttpClient();
        try {
            HttpGet post = new HttpGet(URL+"/"+image);
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity httpEntity = response.getEntity();
                httpEntity.writeTo(res.getOutputStream());
            }

            EntityUtils.consume(response.getEntity());

        }catch (Exception e){
            logger.error(e.getMessage());
        }


    }



}
