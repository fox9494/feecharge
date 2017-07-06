package com.business.acceptor.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class AccountFrozenException extends ApplicationServiceException {


    public AccountFrozenException() {
        super();
        this.setCode(ExceptionConstants.ACCOUNT_FROZEN_CODE);
        this.setMsg(ExceptionConstants.ACCOUNT_FROZEN_MSG);
    }

}
