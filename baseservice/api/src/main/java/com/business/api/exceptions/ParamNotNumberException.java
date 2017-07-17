package com.business.api.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class ParamNotNumberException extends ApplicationServiceException {


    public ParamNotNumberException() {
        super();
        this.setCode(ExceptionConstants.PARAM_NOT_NUMBER_CODE);
        this.setMsg(ExceptionConstants.PARAM_NOT_NUMBER_MSG);
    }

}
