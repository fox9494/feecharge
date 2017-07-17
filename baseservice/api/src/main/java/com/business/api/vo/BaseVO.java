package com.business.api.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Created by chenll on 2017/7/5.
 */
public class BaseVO {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
