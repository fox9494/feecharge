package com.business.api.vo;

/**
 * Created by chenll on 2017/7/16.
 */
public class ChannelPlaceOrderRequest extends BaseVO {


    private PlaceOrderVO placeOrderVO;

    private String sign;

    public PlaceOrderVO getPlaceOrderVO() {
        return placeOrderVO;
    }

    public void setPlaceOrderVO(PlaceOrderVO placeOrderVO) {
        this.placeOrderVO = placeOrderVO;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
