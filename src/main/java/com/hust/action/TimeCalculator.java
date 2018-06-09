package com.hust.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeCalculator {
	
	public static String timeCalculate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
        	date1 = sdf.parse(date);
            date2 = sdf.parse(sdf.format(new Date()));
        }catch (ParseException e) {
            e.printStackTrace();
        }
        long a = (date1.getTime() - date2.getTime()) / (1000 * 3600 * 24);
        if(a >= 0) {
            return "仅有" + a + "天";
        }else{
            return  "已过去" + -a + "天";
        }       
	}
	
}
