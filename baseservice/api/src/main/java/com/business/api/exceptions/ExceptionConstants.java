package com.business.api.exceptions;

/**
 * Created by chenll on 2017/7/3.
 */
public class ExceptionConstants {

    public static final String MERCHANTNOTEXIST_CODE="ACCOUNT_NOT_EXIST";
    public static final String MERCHANTNOTEXIST_MSG="商户账户不存在";

    public static final String ACCOUNT_FROZEN_CODE="ACCOUNT_FROZEN";
    public static final String ACCOUNT_FROZEN_MSG="账户冻结";

    public static final String ACCOUNT_NO_BUSINESS_CODE="ACCOUNT_NO_BUSINESS";
    public static final String ACCOUNT_NO_BUSINESS_MSG="商户没有该业务权限";

    public static final String MERCHANT_NO_MONEY_CODE="MERCHANT_NO_MONEY";
    public static final String MERCHANT_NO_MONEY_MSG="商户余额不足";

    public static final String QQ_IN_BLACKLIST_CODE="QQ_IN_BLACKLIST_CODE";
    public static final String QQ_IN_BLACKLIST_MSG="QQ非法账号";

    public static final String BUSINESSTYPE_NOT_EXIST_CODE="BUSINESSTYPE_NOT_EXIST";
    public static final String BUSINESSTYPE_NOT_EXIST_MSG="业务类型非法";

    public static final String DUPLICATE_MERCHANTORDERNO_CODE="DUPLICATE_MERCHANTORDERNO";
    public static final String DUPLICATE_MERCHANTORDERNO_MSG="商户订单好重复";

    public static final String PARAM_NOT_NUMBER_CODE="PARAM_NOT_NUMBER";
    public static final String PARAM_NOT_NUMBER_MSG="参数错误非数字";






}
