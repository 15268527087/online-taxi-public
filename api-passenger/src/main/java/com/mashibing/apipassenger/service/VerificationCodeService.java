package com.mashibing.apipassenger.service;

import com.mashibing.apipassenger.remote.ServiceVeficationCodeClient;
import com.mashibing.internalcommon.dto.ResponseResult;
import com.mashibing.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeService {
    @Autowired
    private ServiceVeficationCodeClient serviceVeficationcodeClient;

    public String generateCode(String passengerPhone) {

        System.out.println("调用验证码服务，获取验证码");
        ResponseResult<NumberCodeResponse> numberCodeResponse =  serviceVeficationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        System.out.println("remote number code" + numberCode);
        String code = "1";
        System.out.println("存入redis");
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("message", "success");
        return result.toString();
    }
}
