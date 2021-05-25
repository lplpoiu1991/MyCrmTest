package com.sekai.settings.test;

import com.sekai.crm.utils.DateTimeUtil;
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

    }

}
