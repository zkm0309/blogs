package com.angel.blogs.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
* @ClassName: DateUtil
* @Description: 时间工具
* @author zkm
* @date  2018-08-31 15:45
 */
public class DateUtil {
    
    static SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    static SimpleDateFormat simple_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss");
    
    static SimpleDateFormat simple_yyyy_mm_dd = new SimpleDateFormat("yyyy-MM-dd");
    
    static SimpleDateFormat simple_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    
    static SimpleDateFormat simple_china_hms = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
    
    static SimpleDateFormat simple_china = new SimpleDateFormat("yyyy年MM月dd日");
    
    static SimpleDateFormat simple_monthDay_CN = new SimpleDateFormat("MM-dd日");
    
    static SimpleDateFormat simple_month_CN = new SimpleDateFormat("MM");
    
    static String[] numberMonths = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
    
    static String[] chineseMonths = new String[]{"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
    
    
    /**
     * 
     * formatTimestampToString:将Timestamp时间转换成格式：yyyy-MM-dd HH24:mm:ss. <br/>
     * Date:2016-8-13 上午11:27:33
     * @author changbaolong
     * @param timestamp
     * @return
     * @since JDK 1.7
     */
    public static String formatTimestampToString(Timestamp timestamp){
        return simple.format(timestamp);
    }
    
    /**
     * 将timestamp时间转化成格式：yyyy-MM-dd
     * @param timestamp
     * @return
     * @author changbaolong
     * @date 2017-09-27 09:24:01
     */
    public static String formatTimestamp_YYYY_MM_DD(Timestamp timestamp){
        return simple_yyyy_mm_dd.format(timestamp);
    }
    
    /**
     * 将timestamp时间转化成格式：MM
     * @param timestamp
     * @return
     * @author changbaolong
     * @date 2017-09-27 09:25:45
     */
    public static String formatTimestamp_MM(Timestamp timestamp){
        return simple_month_CN.format(timestamp);
    }
    
    /**
     * 
     * formatDateToString:将Date时间转换成格式：yyyy-MM-dd HH24:mm:ss. <br/>
     * Date:2016-8-13 上午11:29:33
     * @author changbaolong
     * @param date
     * @return
     * @since JDK 1.7
     */
    public static String formatDateToString(Date date){
        
        return simple.format(date);
    }
    
    /**
     * 
     * numbertoChineseMonths:数字月转成汉字月份. <br/>
     * Date:2016-11-4 下午04:00:43
     * @author changbaolong
     * @param months
     * @return
     * @since JDK 1.7
     */
    public static String numbertoChineseMonths(String months){
        Integer months_Int = Integer.parseInt(months);
        for (int i = 0; i < numberMonths.length; i++) {
            if(months_Int == Integer.parseInt(numberMonths[i])){
                return chineseMonths[i];
            }
        }
        return "";
    }
    
    public static Date parseToYYYY_MM_dd(String months) throws ParseException{
        Date date = simple_yyyy_mm_dd.parse(months);
        return date;
    }
    
    
    /**
     * 
     * formatDate:格式化时间：yyyyMMdd. <br/>
     * Date:2016-9-2 下午05:20:14
     * @author changbaolong
     * @return
     * @since JDK 1.7
     */
    public static String formatDate(){
        
        return simple_yyyyMMdd.format(new Date());
    }
    
    /**
     * 格式化时间：yyyyMMddHHmmss
     * @return
     * @author changbaolong
     * @date 2017-05-17 11:46:44
     */
    public static String formatDate_yyyyMMddHHmmss(){
        
        return simple_yyyyMMddHHmmss.format(new Date());
    }
    
    
    /**
     * 
     * formatDateToYYYY_MM_DD:格式化时间，将Date类型转换成String：yyyy-MM-dd. <br/>
     * Date:2016-11-23 下午03:13:35
     * @author changbaolong
     * @param date
     * @return
     * @since JDK 1.7
     */
    public static String formatDateToYYYY_MM_DD(Date date){
        
        return simple_yyyy_mm_dd.format(date);
    }
    
    
    /**
     * 返回时间戳+随机数
     * @return
     * @author changbaolong
     * @date 2017-04-10 03:07:31
     */
    public static String geLongTime(){
        StringBuilder sb=new StringBuilder();
        sb.append(System.currentTimeMillis());
        Random ra=new Random();
        sb.append((ra.nextInt(9000)+1000));
        return sb.toString().trim(); 
    }
    
    /**
     * 字符串格式时间，转换成Timestamp类型
     * @param dateString
     * @return
     * @author changbaolong
     * @date 2017-04-19 10:25:41
     */
    public static Timestamp formatDateStringToTimestamp(String dateString){
    	try {
			return Timestamp.valueOf(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 格式化为汉字时间
     * @return yyyy年mm月dd日 HH时mm分ss秒
     * @author changbaolong
     * @date 2017-06-12 02:43:09
     */
    public static String getChinaDate(){
    	
    	return simple_china_hms.format(new Date());
    }
    
    /**
     * 格式化为汉字时间
     * @return yyyy年MM月dd日
     * @author changbaolong
     * @date 2017-06-20 11:07:55
     */
    public static String getChinaDateNoHms(){
    	
    	return simple_china.format(new Date());
    }
    
    /**
     * 当前时间增加分钟数,返回long时间戳
     * @param minutes
     * @return
     * @author changbaolong
     * @date 2017-08-28 04:40:03
     */
    public static String getTimeInMillisByAddMinutes(String strDate, int minutes) { 
		Calendar cal = Calendar.getInstance();
		int year =Integer.parseInt(strDate.substring(0,4));
		int month =Integer.parseInt(strDate.substring(5,7));
		int day =Integer.parseInt(strDate.substring(8,10));
		int h =Integer.parseInt(strDate.substring(11,13));
		int si =Integer.parseInt(strDate.substring(14,16));
		int ss =Integer.parseInt(strDate.substring(17));
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		cal.set(Calendar.HOUR_OF_DAY, h);
		cal.set(Calendar.MINUTE, si);
		cal.set(Calendar.SECOND, ss);
		cal.add(Calendar.MINUTE, minutes);
		return String.valueOf(cal.getTimeInMillis());
	}
    
    /**
     * 获取当前时间戳
     * @return
     * @author changbaolong
     * @date 2017-08-28 04:45:22
     */
    public static String getTime() { 
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis());
	}
    
    
    /**
     * 格式化时间为XX-X日
     * @param timestamp
     * @return
     * @author changbaolong
     * @date 2017-09-25 05:21:54
     */
    public static String formatMonthDay_CN(Timestamp timestamp){
        
        return simple_monthDay_CN.format(timestamp);
        
    }
    
}

