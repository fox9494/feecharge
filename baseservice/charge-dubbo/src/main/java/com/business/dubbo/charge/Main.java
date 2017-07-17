package com.business.dubbo.charge;

import com.business.dubbo.charge.utils.IDGenerator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by chenll on 2017/7/15.
 */
public class Main {

    public static void main(String[] args) {

       Integer a =1;
        Integer b=1;

        if (a==color.RED.value){
            System.out.println("equals " );
        }else{
            System.out.println(" not equals " );
        }

    }

    public enum color{
        RED(1),
        BLUD(2);

        private Integer value;

        color(Integer value) {
            this.value=value;
        }
        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

}
