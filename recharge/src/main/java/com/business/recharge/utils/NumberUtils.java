package com.business.recharge.utils;

import java.math.BigDecimal;

/**
 * Created by chenll on 2017/7/15.
 */
public class NumberUtils {

    /**
     * 将数字格式化输出
     *
     * @param value
     *            需要格式化的值
     * @param precision
     *            精度(小数点后的位数)
     * @return
     */
    public static String format(Object value, Integer precision) {
        Double number = 0.0;
        precision = (precision == null || precision < 0) ? 2 : precision;
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(precision, BigDecimal.ROUND_HALF_UP)
                .toString();
    }
}
