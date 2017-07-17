package com.business.dubbo.charge.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenll on 2017/7/15.
 * ID 生成器
 */
public class IDGenerator {

    //机器编码（1,2,3），接受启动参数设置
    //代码会格式化001,002,003
    private Integer serverCode;

    //上次产生ID的时间
    private long lastTime=-1L;

    /** 毫秒内序列（0-10000） */
    private long sequence = 0L;


    private static  IDGenerator instance = new IDGenerator();

    private IDGenerator(){};

    public static IDGenerator getInstance(){
        return instance;
    }

    public Integer getServerCode() {
        return serverCode;
    }

    public void setServerCode(Integer serverCode) {
        this.serverCode = serverCode;
    }

    /**
     * 年月日时分秒毫秒+三位机器编码+5位自增序号
     * @return
     */
    public synchronized String getID(){
        long currentTime = System.currentTimeMillis();

        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (currentTime < lastTime) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTime - currentTime));
        }

        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTime == currentTime) {
            sequence = (sequence + 1);
            //毫秒内序列溢出
            if (sequence == 10000) {
                //阻塞到下一个毫秒,获得新的时间戳
                currentTime = tilNextMillis(lastTime);
            }
        }else{ //时间戳改变，毫秒内序列重置
            sequence = 0L;
        }

        lastTime = currentTime;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String suffix = sdf.format(new Date(currentTime));

        return suffix +  String.format("%03d", serverCode) + String.format("%05d", sequence);

    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }
}
