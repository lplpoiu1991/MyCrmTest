package com.sekai.settings.test;

import com.sekai.crm.utils.DateTimeUtil;
import com.sekai.crm.utils.MD5Util;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test1 {
    public static void main(String[] args) {
        String expireTime =  "2021-10-25 08:00:00";
        String currentTime  =  DateTimeUtil.getSysTime() ;
        int count =  expireTime.compareTo(currentTime);
        System.out.println(count);

    }
    @Test
    public  void test2(){
        String expireTime =  "2021-05-25 08:00:00";
        Date date = new Date();
       // System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        System.out.println(str);
    }
    @Test
    public  void test3(){
//        String ip = "192.168.1.1";
//        String allowIps = "192.168.1.1,192.168.1.2";
//        if(allowIps.contains(ip)){
//            System.out.println("允许登录");
//        }else{
//            System.out.println("IP受限");
//        }
         String password = "2115034lp.";
        String mypwd = MD5Util.getMD5(password);
        System.out.println(mypwd);

    }

}
