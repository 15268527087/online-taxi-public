package com.mashibing.controller;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberCodeController {
    @GetMapping("/numberCode/{size}")
    public String numberCode(@PathVariable("size") int size) {
        System.out.println("size:" + size);
        double mathRandow = (Math.random()*9+1)*(Math.pow(10,size-1));
        int resultInt= (int)mathRandow;
        JSONObject result = new JSONObject();
        result.put("code", 1);
        result.put("message", "success");
        JSONObject data = new JSONObject();
        data.put("numberCode", resultInt);
        result.put("data", data);
        return result.toString();
    }
//    public static void main(String[] args) {
//        System.out.println("hello world");
//        double number = (Math.random()*9+1)*(Math.pow(10,5));
//    }
}
