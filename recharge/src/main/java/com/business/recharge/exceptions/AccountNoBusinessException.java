package com.business.recharge.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class AccountNoBusinessException extends ApplicationServiceException {


    public AccountNoBusinessException() {
        super();
        this.setCode(ExceptionConstants.ACCOUNT_NO_BUSINESS_CODE);
        this.setMsg(ExceptionConstants.ACCOUNT_NO_BUSINESS_MSG);
    }

}
