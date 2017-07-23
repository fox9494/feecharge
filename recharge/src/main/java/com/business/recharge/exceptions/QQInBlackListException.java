package com.business.recharge.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class QQInBlackListException extends ApplicationServiceException {


    public QQInBlackListException() {
        super();
        this.setCode(ExceptionConstants.QQ_IN_BLACKLIST_CODE);
        this.setMsg(ExceptionConstants.QQ_IN_BLACKLIST_MSG);
    }

}
