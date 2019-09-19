package com.smx.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期转换为string
    public static String dateToString(Date date,String pat){
        SimpleDateFormat sdf=new SimpleDateFormat(pat);
        String format = sdf.format(date);
        return format;
    }
    //string转日期
    public static Date stringToDate(String str,String pat) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(pat);
        Date parse = sdf.parse(str);
        return parse;
    }
}
