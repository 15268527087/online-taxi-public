package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServiceVeficationCodeClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeService {
    @Autowired
    private ServiceVeficationCodeClient serviceVeficationcodeClient;
    //乘客验证码前缀
    private String VeficationCodePrefix = "passenger-vefication-code-";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public ResponseResult generateCode(String passengerPhone) {

        System.out.println("调用验证码服务，获取验证码");
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVeficationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        System.out.println("remote number code" + numberCode);
        String code = "1";
        System.out.println("存入redis");
        String key = VeficationCodePrefix + passengerPhone;
        stringRedisTemplate.opsForValue().set(key, numberCode + "",2, TimeUnit.MINUTES);
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("message", "success");
        return ResponseResult.success("");
    }
}
