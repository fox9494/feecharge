package com.business.recharge.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class DuplicateMerchantOrderNOException extends ApplicationServiceException {


    public DuplicateMerchantOrderNOException() {
        super();
        this.setCode(ExceptionConstants.DUPLICATE_MERCHANTORDERNO_CODE);
        this.setMsg(ExceptionConstants.DUPLICATE_MERCHANTORDERNO_MSG);
    }

}
