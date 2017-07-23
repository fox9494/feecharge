package com.business.recharge.vo;

/**
 * Created by chenll on 2017/7/16.
 */
public class ChannelPlaceOrderCallbackRequest extends BaseVO{

    private PlaceOrderCallbackVO placeOrderCallbackVO;

    private String sign;

    public PlaceOrderCallbackVO getPlaceOrderCallbackVO() {
        return placeOrderCallbackVO;
    }

    public void setPlaceOrderCallbackVO(PlaceOrderCallbackVO placeOrderCallbackVO) {
        this.placeOrderCallbackVO = placeOrderCallbackVO;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
