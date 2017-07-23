package com.business.recharge.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class MerchantNotExistException extends ApplicationServiceException {


    public MerchantNotExistException() {
        super();
        this.setCode(ExceptionConstants.MERCHANTNOTEXIST_CODE);
        this.setMsg(ExceptionConstants.MERCHANTNOTEXIST_MSG);
    }

}
