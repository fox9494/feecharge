package com.business.api.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class ApplicationServiceException extends RuntimeException {


    private String code;

    private String msg;

    public ApplicationServiceException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ApplicationServiceException() {
        super();
    }

    public ApplicationServiceException(Throwable throwable) {
        super(throwable);
    }

    public ApplicationServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ApplicationServiceException(String message) {
        super(message);
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.getClass().getName()+"(code:"+code+", msg:"+msg+", message:"+this.getMessage()+")";
    }
}
