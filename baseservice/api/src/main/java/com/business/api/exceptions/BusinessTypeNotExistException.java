package com.business.api.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class BusinessTypeNotExistException extends ApplicationServiceException {


    public BusinessTypeNotExistException() {
        super();
        this.setCode(ExceptionConstants.BUSINESSTYPE_NOT_EXIST_CODE);
        this.setMsg(ExceptionConstants.BUSINESSTYPE_NOT_EXIST_MSG);
    }

}
