package com.ys.jsst.pmis.commommodule.util;

import android.util.Log;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 主要用来进行时间的读取设置
 *
 * @author shaobing
 * @version V1.0
 *          时间操作包装函数
 */
public class DateTimeUtils {
    /**
     * 进行实践差的计算，设置为时间差的初始值
     */
    private static long sStartTime = 0;
    private static final int YEAR = 365 * 24 * 60 * 60;// 年
    private static final int MONTH = 30 * 24 * 60 * 60;// 月
    private static final int DAY = 24 * 60 * 60;// 天
    private static final int HOUR = 60 * 60;// 小时
    private static final int MINUTE = 60;// 分钟

    /**
     * 得到毫秒级的时间
     *
     * @return
     */
    public static long getMillis() {
        Date date = new Date();
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        LogUtil.i("  " + dt.getTime() + "  " + System.currentTimeMillis());
        return dt.getTime();
    }

    /**
     * 获取年的时间
     *
     * @return
     */
    public static String getYear() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sy = new SimpleDateFormat("yyyy");
        String syear = sy.format(dt);

        LogUtil.i("  " + syear + "  " + syear);
        return syear;
    }

    /**
     * 获取年的时间
     *
     * @return
     */
    public static String getMonth() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sm = new SimpleDateFormat("MM");
        String smon = sm.format(dt);

        LogUtil.i("  " + smon + "  " + smon);
        return smon;
    }

    public static String getWeek() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("E");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 获取天的时间
     *
     * @return
     */
    public static String getDay() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        String sday = sd.format(dt);

        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 判断两个时间是否在同一个月
     */
    public static boolean equals(Date date1, Date date2) {

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        int month1 = calendar1.get(Calendar.MONTH);
        int month2 = calendar2.get(Calendar.MONTH);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
    }

    /**
     * 获取时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String getHourMinute() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String getDate() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String getDateHHmm() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /***
     * 将时间转化为long型
     * @param time
     * @return
     */
    public static Long getDate(String time) {
        long sqlLastTime = 0;// 直接转换成long
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date parse = dateFormat.parse(time);
            sqlLastTime = parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlLastTime;
    }


    /**
     * 获取年月日时分
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String getTime() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }


    /**
     * 计算分钟差
     *
     * @param starTime
     * @param endTime
     * @return
     */
    public static String getTimeDifferenceMinute(String starTime, String endTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date parse = dateFormat.parse(starTime);
            Date parse1 = dateFormat.parse(endTime);
            long diff = parse1.getTime() - parse.getTime();
            String string = Long.toString(diff);

            float parseFloat = Float.parseFloat(string);

            float hour1 = parseFloat / (60 * 1000);

            timeString = Float.toString(hour1);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;

    }

    /**
     * 计算分钟差
     *
     * @param starTime
     * @param endTime
     * @return
     */
    public static String getTimeRate(String starTime, String endTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = dateFormat.parse(starTime);
            Date parse1 = dateFormat.parse(endTime);
            long diff = parse1.getTime() - parse.getTime();
            //            String string = Long.toString(diff);

            //            float parseFloat = Float.parseFloat(string);

            float hour1 = diff / (60 * 1000.0f);

            timeString = Float.toString(hour1);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;

    }

    public static String getDayCount(String starTime,String period) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = dateFormat.parse(starTime);
            long diff = parse.getTime() - getMillis();
            //            String string = Long.toString(diff);

            //            float parseFloat = Float.parseFloat(string);

            long day = diff / (60 * 1000*60*24) + Long.valueOf(period) -1;
            if (day < 0){
                day = 0;
            }
            timeString = String.valueOf(day);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;

    }
    /**
     * 将年月日时分秒 转化为 月日
     *
     * @param starTime
     * @return
     */
    public static String getTimeDifferenceDate(String starTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sd = new SimpleDateFormat("MM月dd日");
        try {
            Date parse = dateFormat.parse(starTime);
            timeString = sd.format(parse);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     * 将年月日时分秒 转化为 月日
     *
     * @param starTime
     * @return
     */
    public static String getTimeDate(String starTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = dateFormat.parse(starTime);
            timeString = sd.format(parse);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     * 获取月 日 分 秒
     *
     * @param starTime 转换的时间
     */
    public static String getMonthDays(String starTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("MM月dd日 HH:mm");
        try {
            Date parse = dateFormat.parse(starTime);
            timeString = sd.format(parse);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     * 将传进来的 年月日时分秒 转化为 年月日 时分
     *
     * @param starTime
     * @return
     */
    public static String getTimeDateMinute(String starTime) {
        String timeString = "";
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            //Date parse = dateFormat.parse(starTime);
            //timeString= sd.format(parse);
            Date date = sd.parse(starTime);
            timeString = sd.format(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     *将秒转化为时分
     *
     * @return
     */
    public static String getmmss(long time) {
        StringBuffer timeString = new StringBuffer("");
        try {
            if(time<=0){
                timeString.append("0分钟");
            }else{
                long hour = time/(60*60);
                if(hour>0){
                    timeString.append(hour);
                    timeString.append("小时");
                }else{
                    long minute = time/(60)%60;
                    if(minute>0){
                        timeString.append(minute);
                        timeString.append("分钟");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "0分钟";

        }
        LogUtil.e("timeString : "+timeString+"  "+time);
        return timeString.length()==0?"0分钟":timeString.toString();
    }

    /**
     * 将年月日时分 转化为 年月日
     *
     * @param starTime
     * @return
     */
    public static String getChangeDate(String starTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = dateFormat.parse(starTime);
            timeString = sd.format(parse);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;
    }


    /**
     * long型转成Hh:mm:ss格式
     *
     * @param time 秒数
     */
    public static String getLongToString(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        //东八区
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String t = null;
        try {
            //先乘1000得到毫秒数，再转为Date类型
            Date d = new Date(time * 1000);
            t = sdf.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static String getLongToString1(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH", Locale.getDefault());
        //东八区
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String t = null;
        try {
            //先乘1000得到毫秒数，再转为Date类型
            Date d = new Date(time * 1000);
            t = sdf.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 保留两位有效小数
     *
     * @param num
     */
    public static String getTwoDecimals(float num) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(num);
    }

    /**
     * 将年月日时分 转化为 年月日
     *
     * @param starTime
     * @return
     */
    public static String getChangehm(String starTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm");
        try {
            Date parse = dateFormat.parse(starTime);
            timeString = sd.format(parse);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     * 将年月日时分 转化为 年月日
     *
     * @param starTime
     * @return
     */
    public static String getChangehms(String starTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        try {
            Date parse = dateFormat.parse(starTime);
            timeString = sd.format(parse);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     * 计算相差的小时
     *
     * @param starTime
     * @param endTime
     * @return
     */
    public static String getTimeDifferenceHour(String starTime, String endTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date parse = dateFormat.parse(starTime);
            Date parse1 = dateFormat.parse(endTime);

            long diff = parse1.getTime() - parse.getTime();
            String string = Long.toString(diff);

            float parseFloat = Float.parseFloat(string);

            float hour1 = parseFloat / (60 * 60 * 1000.0f);

            timeString = Float.toString(hour1);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return timeString;

    }


    /**
     * 计算天数差
     *
     * @param starTime
     * @param endTime
     * @return
     */
    public static String getTimeDifferenceDay(String starTime, String endTime) {
        String timeString = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date parse = dateFormat.parse(starTime);
            Date parse1 = dateFormat.parse(endTime);
            long diff = parse1.getTime() - parse.getTime();
            String string = Long.toString(diff);

            float parseFloat = Float.parseFloat(string);

            float day = parseFloat / (60.0f * 60.0f * 1000.0f * 24.0f);

            timeString = Float.toString(day);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeString;
    }

    /**
     * 获取分秒
     *
     * @param time
     * @return
     */
    public static String getMinuteSecond(long time) {
        Timestamp dt = new Timestamp(time);
        SimpleDateFormat sd = new SimpleDateFormat("mm:ss");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }


    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String getDate3(float addTime) {
        Timestamp dt = new Timestamp(System.currentTimeMillis() + (long) addTime * 1000);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    public static String getDateTime(long time) {
        try {
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(time);
            return sim.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getDateTime1(long time) {
        try {
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date(time);
            return sim.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String getDate2(float addTime) {
        Timestamp dt = new Timestamp(System.currentTimeMillis() + (long) addTime * 1000);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static long getDiffTime(String time1, String time2) {
        long diff = 0;
        long days = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
            Date d1 = df.parse(time1);
            Date d2 = df.parse(time2);
            diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
            days = diff / (1000 * 60 * 60 * 24);
        } catch (Exception e) {
            LogUtil.e("dateTimeUtile :" + e.fillInStackTrace());
        }
        LogUtil.i("  " + days);
        return days;
    }

    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String changeTime1(String time1) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日");
            Date d1 = df.parse(time1);
            return df1.format(d1);
        } catch (Exception e) {
            LogUtil.e("dateTimeUtile :" + e.fillInStackTrace());
        }
        return "";
    }


    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static long getDiffMM(String time1, String time2) {
        long diff = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date d1 = df.parse(time1);
            Date d2 = df.parse(time2);
            diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
        } catch (Exception e) {
            LogUtil.e("dateTimeUtile :" + e.fillInStackTrace());
        }
        LogUtil.e("getDiffMM :" + diff);

        return diff;
    }

    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static long getDiffSS(String time1, String time2) {
        long diff = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = df.parse(time1);
            Date d2 = df.parse(time2);
            diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别
        } catch (Exception e) {
            LogUtil.e("dateTimeUtile :" + e.fillInStackTrace());
        }
        LogUtil.e("getDiffMM :" + diff);

        return diff;
    }

    /**
     * 获取年月日时分秒
     * 可以用来存储到数据库进行时间的比较
     *
     * @return
     */
    public static String getDateByDay() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String sday = sd.format(dt);
        return sday;
    }

    public static String getDateMillis() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    public static String changeTime(String time) {


        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
            SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = sd.parse(time);
            return sd1.format(parse);
        } catch (Exception e) {
            Log.d("DateTimeUtils", e.getMessage());
        }
        return "";
    }


    /**
     * 命名
     *
     * @return
     */
    public static String getDateName() {
        Timestamp dt = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_SSS");
        String sday = sd.format(dt);
        LogUtil.i("  " + sday + "  " + sday);
        return sday;
    }

    /**
     * 设置时间差计算的起始数值
     */
    public static void setTimeDifferenceStart() {
        sStartTime = System.currentTimeMillis();
    }


    /**
     * 计算实践差
     *
     * @param endTime 时间差的最后的数值
     * @return 返回一秒为单位的时间差数据
     */
    public static String getTimeDifference(Long endTime) {
        Timestamp dt = new Timestamp(endTime - sStartTime);
        SimpleDateFormat sd = new SimpleDateFormat("ss");
        String sTime = sd.format(dt);
        return sTime;
    }

    /**
     * 根据时间戳获取描述性时间，如3分钟前，1天前
     *
     * @param timestamp 时间戳 单位为毫秒
     * @return 时间字符串
     */
    public static String getDescriptionTimeFromTimestamp(long timestamp) {
        long currentTime = System.currentTimeMillis();
        long timeGap = (currentTime - timestamp) / 1000;// 与现在时间相差秒数
        String timeStr;
        if (timeGap > YEAR) {
            timeStr = timeGap / YEAR + "年前";
        } else if (timeGap > MONTH) {
            timeStr = timeGap / MONTH + "个月前";
        } else if (timeGap > DAY) {// 1天以上
            timeStr = timeGap / DAY + "天前";
        } else if (timeGap > HOUR) {// 1小时-24小时
            timeStr = timeGap / HOUR + "小时前";
        } else if (timeGap > MINUTE) {// 1分钟-59分钟
            timeStr = timeGap / MINUTE + "分钟前";
        } else {// 1秒钟-59秒钟
            timeStr = "刚刚";
        }
        return timeStr;
    }


    /**
     * 根据时间戳获取描述性时间，如3分钟前，1天前
     *
     * @param timeGap 时间戳 单位为毫秒
     * @return 时间字符串
     */
    public static String getHHMM(long timeGap) {

        StringBuffer timeStr = new StringBuffer();
        if (timeGap > HOUR) {// 1小时-24小时
            timeStr.append(timeGap / HOUR + "小时");
        }
        if (timeGap%HOUR > MINUTE) {// 1分钟-59分钟
            timeStr.append(timeGap%HOUR / MINUTE + "分钟");
        }
        return timeStr.toString();
    }

    /**
     * 获取日期比较显示时间是前多少分钟小时天数
     *
     * @param starTime
     * @param endTime
     * @return
     */
    public static String getTimeType(String starTime, String endTime) {
        try {
            int time = 0;
            String minute = DateTimeUtils.getTimeDifferenceMinute(starTime, endTime);
            if (StringUtils.isNotEmpty(minute)) {
                time = Double.valueOf(minute).intValue() + 1;
                if (time < 60) {
                    return time + "分钟前";
                } else {
                    String hour = DateTimeUtils.getTimeDifferenceHour(starTime, endTime);
                    time = Double.valueOf(hour).intValue() + 1;
                    if (time < 24) {
                        return time + "小时前";
                    } else {
                        String day = DateTimeUtils.getTimeDifferenceDay(starTime, endTime);
                        time = Double.valueOf(day).intValue() + 1;
                        if (time <= 1) {
                            return "昨天";
                        } else if (time <= 2) {
                            return "前天";
                        } else {
                            return DateTimeUtils.getTimeDifferenceDate(starTime);
                        }
                    }
                }
            } else {
                return DateTimeUtils.getTimeDifferenceDate(starTime);
            }
        } catch (Exception e) {
            //            LogUtil.d("getTime",e);
            return "未知";
        }
    }

    /**
     * 根据时间判断该时间是否在现在之前
     *
     * @param answerPublishTime 时间戳 ,格式 ，2017-03-02 23:59:00.0
     * @return 时间字符串
     */
    public static Boolean isBeforeNow(String answerPublishTime) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        try {
            Date d = sdf.parse(answerPublishTime);
            boolean flag = d.before(now);
            if (flag)
                return true;
            else
                return false;
        } catch (Exception e) {
            Log.e("isBeforeNow", e.getMessage());
            return false;
        }
    }

    public static String longToString(long currentTime, String formatType)
            throws ParseException {
        Date date = longToDate(currentTime, formatType); // long类型转成Date类型
        String strTime = dateToString(date, formatType); // date类型转成String
        return strTime;
    }

    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }

    public static Date stringToDate(String strTime, String formatType) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        try {
            date = formatter.parse(strTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getRefreshTime(long time) {
        String str = null;
        Date oldtime = new Date(time);
        Date curtime = new Date(System.currentTimeMillis());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String old = sd.format(oldtime);
        String cur = sd.format(curtime);
        if (old.startsWith(cur.split(" ")[0])) {
            str = "今天  " + old.split(" ")[1];
        } else {

            str = getTimeDifferenceDay1(old, cur);
        }


        return str;
    }

    public static String getBookBarTime(String starttime, String curtime) {
        Log.d("DateTimeUtils", "starttime   " + starttime + "  curtime  " + curtime);
        //starttime   2017-06-13 15:55:01.0  curtime  2017-06-14 09:52:54

        if (starttime.startsWith(curtime.split(" ")[0])) {
            //            str = "今天  " + starttime.split(" ")[1];
            if (starttime.endsWith(".0")) {
                starttime = starttime.substring(0, starttime.length() - 2);
            }
            //            String[] startstr = starttime.split(" ")[1].split(":");
            //            String[] curtimestr = curtime.split(" ")[1].split(":");
            //            int hour = Integer.parseInt(curtimestr[0]) - Integer.parseInt(startstr[0]);
            //            int min = Integer.parseInt(curtimestr[1]) - Integer.parseInt(startstr[1]);
            //            int second = Integer.parseInt(curtimestr[2]) - Integer.parseInt(startstr[2].endsWith(".0") ? startstr[2].substring(0, startstr[2].length() - 2) : startstr[2]);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                Date start = sdf.parse(starttime);
                Date curt = sdf.parse(curtime);
                long startTime = start.getTime();
                long curtTime = curt.getTime();

                long l = curtTime - startTime;
                long hour = l / 3600000;
                long min = l % 3600000 / 60000;
                long second = l % 60000 / 1000;
                if (hour > 0) {
                    return hour + "小时前";
                } else if (hour == 0 && min > 0) {
                    return min + "分前";
                } else if (hour == 0 && min == 0 && second >= 0) {
                    return second + "秒前";
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }


        } else {

            return getTimeDifferenceDay2(starttime, curtime);
        }

        return "0秒前";
    }

    private static String getTimeDifferenceDay2(String old, String cur) {
        String[] oldstr = old.split(" ")[0].split("-");
        String[] curstr = cur.split(" ")[0].split("-");

        if (oldstr[0].equals(curstr[0])) {
            int oldi = Integer.parseInt(oldstr[2]);
            int curi = Integer.parseInt(curstr[2]);
            if (curi - oldi == 1 && oldstr[1].equals(curstr[1])) {

                //                return "昨天  " + old.split(" ")[1].substring(0,old.split(" ")[1].length()-2);
                return "昨天";
            } else if (curi - oldi == 2) {
                return "前天";

            } else {
                //                return oldstr[1] + "-" + oldstr[2] + "  " + old.split(" ")[1].substring(0,old.split(" ")[1].length()-2);
                return oldstr[1] + "-" + oldstr[2];
            }


        } else {
            //            return oldstr[0] + "-" + oldstr[1] + "-" + oldstr[2] + "  " + old.split(" ")[1].substring(0,old.split(" ")[1].length()-2);
            return oldstr[0] + "-" + oldstr[1] + "-" + oldstr[2];
        }


    }

    /**
     * @param date 日期格式为yyyy年MM月dd日
     */
    public static String transformToNormDate(String date) {
        String re = date;
        SimpleDateFormat sdfFrom = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfTo = new SimpleDateFormat("yyyy-MM");

        try {
            re = sdfTo.format(sdfFrom.parse(re));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return re;
    }


    private static String getTimeDifferenceDay1(String old, String cur) {
        String[] oldstr = old.split(" ")[0].split("-");
        String[] curstr = cur.split(" ")[0].split("-");
        if (oldstr[0].equals(curstr[0])) {
            int oldi = Integer.parseInt(oldstr[2]);
            int curi = Integer.parseInt(curstr[2]);
            if (curi - oldi >= 1 && 2 > curi - oldi && oldstr[1].equals(curstr[1])) {

                return "昨天  " + old.split(" ")[1];
            } else {
                return oldstr[1] + "-" + oldstr[2] + "  " + old.split(" ")[1];
            }


        } else {
            return oldstr[0] + "-" + oldstr[1] + "-" + oldstr[2] + "  " + old.split(" ")[1];
        }


    }

    //时间格式转换毫秒
    public static long getTimeNumber(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        long millionSeconds = 0;//毫秒
        try {
            millionSeconds = sdf.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.e("time++++++", String.valueOf(millionSeconds));
        return millionSeconds;
    }
}
