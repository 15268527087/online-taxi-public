package com.mashibing.internalcommon.constant;


import lombok.Getter;

@Getter
public enum CommonStatusEnum {
    SUCCESS(1, "success"),
    Fail(0,"fail");
    private int code;
    private String value;
     CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
