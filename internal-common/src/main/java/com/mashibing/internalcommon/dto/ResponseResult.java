package com.mashibing.internalcommon.dto;

import com.mashibing.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    /**
     * 成功响应的方法
     * @return
     * @param <T>
     */
    public static <T> ResponseResult success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue());
    }
    /**
     * 成功响应的方法
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseResult success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

    /**
     * 失败：自定义失败 错误码和提示信息
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult fail(int code, String message){
        return new ResponseResult().setCode(code).setMessage(message);
    }
    /**
     * 失败：自定义失败 错误码和提示信息和具体数据
     * @param code
     * @param message
     * @return
     */
    public static ResponseResult fail(int code, String message, String data){
        return new ResponseResult().setCode(code).setMessage(message).setData( data);
    }
}
