package com.studentInformation.demo;

public class response<T> {
    private T data;
    private boolean success;
    private String errorMsg;

    public static <K>response<K> newSuccess(K data){
        response<K> response = new response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public response<Object> newFail(String errorMsg){
        response<Object> response = new response<>();
        response.setSuccess(false);
        response.setErrorMsg(errorMsg);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
