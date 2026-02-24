package com.mashibing.apipassenger.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeService {
    public String generateCode(String passengerPhone){
        System.out.println("调用验证码服务，获取验证码");
        String code = "1";
        System.out.println("存入redis");
        JSONObject result = new JSONObject();
        result.put("code",code);
        result.put("message","success");
        return result.toString();
    }
}
