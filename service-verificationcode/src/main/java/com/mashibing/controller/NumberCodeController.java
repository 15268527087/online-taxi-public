package com.mashibing.controller;

import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {
    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size) {
        System.out.println("size:" + size);
        //生成验证码
        double mathRandow = (Math.random()*9+1)*(Math.pow(10,size-1));
        int resultInt= (int)mathRandow;

        //定义返回值
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);
        return ResponseResult.success( response);
    }
//    public static void main(String[] args) {
//        System.out.println("hello world");
//        double number = (Math.random()*9+1)*(Math.pow(10,5));
//    }
}
