package com.business.api.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class MerchantNoMoneyException extends ApplicationServiceException {


    public MerchantNoMoneyException() {
        super();
        this.setCode(ExceptionConstants.MERCHANT_NO_MONEY_CODE);
        this.setMsg(ExceptionConstants.MERCHANT_NO_MONEY_MSG);
    }

}
