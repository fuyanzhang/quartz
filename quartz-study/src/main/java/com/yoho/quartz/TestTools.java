package com.yoho.quartz;

import java.util.Date;

/**
 * @Author:yanzhang.fu
 * @Date:2017/11/27
 * @Description:
 * @Modified By：
 **/
public class TestTools {

    public static void main(String[] args) {
        long ld = 1511746492000l;
        Date date = new Date(ld);
        System.out.println(date);


        String key = "org.quartz.dataSource.myDS.driver";
        String prefix = "org.quartz.dataSource.";
        String groupname = key.substring(prefix.length(), key.indexOf(
                '.', prefix.length()));
        System.out.println(groupname);

    }
}
