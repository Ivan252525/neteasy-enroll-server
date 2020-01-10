package com.neteasy.common.web;

public class ResultUtils {

    public static <T> BaseResult<T> success(T data) {
        BaseResult<T> result = new BaseResult<T>();
        result.setCode(200);
        result.setDesc("success");
        result.setData(data);
        return result;
    }

    public static BaseResult success() {
        BaseResult result = new BaseResult();
        result.setCode(200);
        result.setDesc("success");
        return result;
    }

    public static BaseResult error(Integer code, String desc) {
        BaseResult result = new BaseResult();
        result.setCode(code);
        result.setDesc(desc);
        return result;
    }

}
