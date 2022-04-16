package com.SpringExample.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * FileName: 日期工具类
 * Use: 处理日期的工具类
 */
@SuppressWarnings("unchecked")
public class MyDateUtil {

    /**
     * 日期字符串格式:"yyyy-MM-dd HH:mm:ss"
     */
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期字符串格式:"yyyy-MM-dd"
     */
    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 日期字符串格式:"yyyyMMdd"
     */
    public static final String SHORT_FORMAT_DAY = "yyyyMMdd";

    /**
     * 日期字符串格式:"yyyyMMddHHmmss"
     */
    public static final String LONG_FORMAT_SECONDS = "yyyyMMddHHmmss";

    /**
     * 日期字符串格式:"yyyyMMddHHmmssSSS"
     */
    public static final String LONG_FORMAT_TIME_MILLIS = "yyyyMMddHHmmssSSS";

    static long startPoint = 2000 * 365 * 24 * 60 * 60 * 1000; //0
    static long endPoint = 9999 * 365 * 24 * 60 * 60 * 1000; //Long.MAX - ...

    static {
        //TimeZone tz = TimeZone.getTimeZone("ETC/GMT+8");
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        TimeZone.setDefault(tz);
        /**/
    }

    /**
     * 按格式"yyyy-MM-dd HH:mm:ss"转换Date为字符串
     *
     * @param date Date对象
     * @return 时间字符串
     */
    public static String dateToLongString(Date date) {
        String timestr = "";
        if (null != date) {
            SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
            timestr = sdf.format(date);
        }
        return timestr;
    }

    /**
     * 按格式"yyyy-MM-dd"转换Date为字符串
     *
     * @param date 日期
     * @return 返回格式化的日期字符串
     */
    public static String dateToShortString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(SHORT_DATE_FORMAT);
        return formatter.format(date);
    }

    /**
     * 按格式"yyyyMMddHHmmss"转换Date为字符串
     *
     * @param date 日期
     * @return 返回格式化的日期字符串
     */
    public static String dateToLongNumberString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(LONG_FORMAT_SECONDS);
        return formatter.format(date);
    }

    /**
     * 按格式"yyyyMMddH"转换Date为字符串
     *
     * @param date 日期
     * @return 返回格式化的日期字符串
     */
    public static String dateToShortNumberString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat(SHORT_FORMAT_DAY);
        return formatter.format(date);
    }

    /**
     * 按格式"yyyy-MM-dd HH:mm:ss"转换Timestamp
     *
     * @param ti Timestamp对象
     * @return 时间字符串
     */
    public static String timestampToLongString(Timestamp ti) {
        String timestr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
        timestr = sdf.format(ti);
        return timestr;
    }

    /**
     * 按格式"yyyy-MM-dd "转换Timestamp
     *
     * @param ti Timestamp对象
     * @return 时间字符串
     */
    public static String timestampToShortString(Timestamp ti) {
        String timestr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
        timestr = sdf.format(ti);
        return timestr;
    }

    /**
     * 按指定的格式转换Date
     *
     * @param date   日期
     * @param format 字符串的日期表示格式
     * @return 字符串
     */
    public static String dateToStringWithFormat(Date date, String format) {
        String timestr = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        timestr = sdf.format(date);
        return timestr;
    }

    /**
     * 按格式"yyyy-MM-dd HH:mm:ss"解析字符串为日期
     *
     * @param datestr 字符串
     * @return 日期
     */
    public static Date longStringToDate(String datestr) {
        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
        Date date = null;
        if (datestr != null) {
            if (datestr.indexOf("T") != -1) {
                datestr = datestr.replace("T", " ");
            }
            try {
                date = sdf.parse(datestr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * 按格式"yyyy-MM-dd"解析字符串为日期
     *
     * @param datestr 字符串
     * @return 日期
     */
    public static Date shortStringToDate(String datestr) {
        SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
        Date date = null;
        if (datestr != null) {
            if (datestr.indexOf("T") != -1) {
                datestr = datestr.replace("T", " ");
            }
            try {
                date = sdf.parse(datestr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }


    /**
     * 按指定的格式解析字符串datestr
     *
     * @param datestr 字符串
     * @param format  字符串的日期表示格式
     * @return 日期
     */
    public static Date stringToDateWithFormat(String datestr, String format)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        if (datestr != null) {
            date = sdf.parse(datestr);
        }
        return date;
    }

    /**
     * 返回当前时间所对应的字符串表示，精确到毫秒
     *
     * @return 字符串
     */
    public static String generateCurrentTimeMillisString() {

        return getCurrentDateTimeString(LONG_FORMAT_TIME_MILLIS);
    }

    /**
     * 按照传入的日期显示格式，返回当前时间的字符串表示形式
     *
     * @param format 字符串的日期表示格式
     * @return 字符串
     */
    public static String getCurrentDateTimeString(String format) {
        String currentTimeString = "";
        SimpleDateFormat sdfDateTime = new SimpleDateFormat(format);
        currentTimeString = sdfDateTime
                .format(Calendar.getInstance().getTime());
        return currentTimeString;
    }

    /**
     * 获取当前时间
     *
     * @return 日期
     */
    public static Date getCurrentDateTime() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 返回当前时间对应的毫秒值
     *
     * @return 字符串
     */
    public static String getCurrentTimeMillis() {
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 返回纳秒值
     *
     * @return 字符串
     */
    public static String getNanoTime() {
        long nanoTime = 0;
        do {
            nanoTime = System.nanoTime();
        } while (nanoTime < 1);
        return String.valueOf(nanoTime);
    }

    /**
     * 判断字符串是否是有效的日期， 格式"yyyy-MM-dd,yyyy-MM-d,yyyy-M-dd,yyyy-M-d
     * "yyyy/MM/dd,yyyy/MM/d,yyyy/M/dd,yyyy/M/d" "yyyyMMdd"
     *
     * @param date 日期字符串
     * @return 是则返回true，否则返回false
     */
    public static boolean isValidDate(String date) {
        if ((date == null) || (date.length() < 8)) {
            return false;
        }
        try {
            boolean result = false;
            SimpleDateFormat formatter;
            char dateSpace = date.charAt(4);
            String format[];
            if ((dateSpace == '-') || (dateSpace == '/')) {
                format = new String[4];
                String strDateSpace = Character.toString(dateSpace);
                format[0] = "yyyy" + strDateSpace + "MM" + strDateSpace + "dd";
                format[1] = "yyyy" + strDateSpace + "MM" + strDateSpace + "d";
                format[2] = "yyyy" + strDateSpace + "M" + strDateSpace + "dd";
                format[3] = "yyyy" + strDateSpace + "M" + strDateSpace + "d";
            } else {
                format = new String[1];
                format[0] = "yyyyMMdd";
            }

            for (int i = 0; i < format.length; i++) {
                String aFormat = format[i];
                formatter = new SimpleDateFormat(aFormat);
                formatter.setLenient(false);
                String tmp = formatter.format(formatter.parse(date));
                if (date.equals(tmp)) {
                    result = true;
                    break;
                }
            }
            return result;
        } catch (ParseException e) {
            // 判断字符串是否是有效的日期， 格式yyyy-MM-dd,yyyy-MM-d,yyyy-M-dd,yyyy-M-d出现异常
            return false;
        }
    }

    /**
     * 判断字符串是否是有效的日期，格式"yyyy-MM-dd HH:mm:ss"
     *
     * @param date 日期字符串
     * @return 是则返回true，否则返回false
     */
    public static boolean isValidTime(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(LONG_DATE_FORMAT);
            formatter.setLenient(false);
            formatter.parse(date);
            return true;
        } catch (ParseException e) {
            // 判断字符串是否是有效的日期，格式yyyy-MM-dd HH:mm:ss
            return false;
        }
    }

    /**
     * 转换字符串为日期，格式"yyyy-MM-dd"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     */
    public static Date shortStrToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        return formatter.parse(date);
    }

    /**
     * 转换字符串为日期，格式"yyyy-MM-dd HH:mm:ss"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     */
    public static Date longStrToDateTime(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setLenient(false);
        return formatter.parse(date);
    }

    /**
     * 取得现在的日期，格式"yyyy-MM-dd HH:mm:ss"
     *
     * @return 返回格式化的日期字符串
     */
    public static String getNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Now = new Date();
        return formatter.format(Now);
    }

    /**
     * 取得现在的日期，格式"yyyy-MM-dd"
     *
     * @return 返回格式化的日期字符串
     */
    public static String getToday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date Now = new Date();
        return formatter.format(Now);
    }

    /**
     * 取得当前现在的日期，格式"yyyy-MM-dd"
     *
     * @return 返回格式化的日期字符串
     */
    public static String getDate(Date Now) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(Now);
    }

    /**
     * 取得现在的时间，格式"HH:mm:ss"
     *
     * @return 返回格式化的时间字符串
     */
    public static String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date Now = new Date();
        return formatter.format(Now);
    }

    /**
     * 取得现在的时间，格式"HH:mm:ss"
     *
     * @return 返回格式化的时间字符串
     */
    public static String getTime(Date Now) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return formatter.format(Now);
    }

    /**
     * 取得年份，格式"yyyy"
     *
     * @return 返回当前年份
     */
    public static int getYear() {
        Date Now = new Date();
        return getYear(Now);
    }

    /**
     * 取得日期的年份，格式"yyyy"
     *
     * @param date 日期
     * @return 日期的年份
     */
    public static int getYear(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        return Integer.parseInt(formatter.format(date));
    }

    /**
     * 取得月份
     *
     * @return 返回当前月份
     */
    public static int getMonth() {
        Date Now = new Date();
        return getMonth(Now);
    }

    /**
     * 取得日期的月份
     *
     * @param date 日期
     * @return 日期的月份
     */
    public static int getMonth(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("M");
        return Integer.parseInt(formatter.format(date));
    }

    /**
     * 取得今天的日期数
     *
     * @return 返回今天的日期数
     */
    public static int getDay() {
        Date Now = new Date();
        return getDay(Now);
    }

    /**
     * 取得日期的天数
     *
     * @param date 日期
     * @return 日期的天数
     */
    public static int getDay(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("d");
        return Integer.parseInt(formatter.format(date));
    }

    public static Date addHour(Date date, int addCount) throws ParseException {
        // Calendar cal = new GregorianCalendar();
        // 最好用Calendar.getInstance();
        // 因为有的地方，不是使用GregorianCalendar的。
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(longStringToDate(dateToLongString(date)));
        calendar.add(Calendar.HOUR, addCount);
        return calendar.getTime();
    }

    /**
     * 获得与某日期相隔几天的日期
     *
     * @param date     指定的日期
     * @param addCount 相隔的天数
     * @return 返回的日期
     */
    public static Date addDay(Date date, int addCount) throws ParseException {
        // Calendar cal = new GregorianCalendar();
        // 最好用Calendar.getInstance();
        // 因为有的地方，不是使用GregorianCalendar的。
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(shortStrToDate(dateToShortString(date)));
        calendar.add(Calendar.DATE, addCount);
        return calendar.getTime();
    }

    public static String addDay(String strDate, int addCount) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(shortStrToDate(strDate));
        calendar.add(Calendar.DATE, addCount);
        return dateToShortString(calendar.getTime());
    }

    /**
     * 获得与某日期相隔几月的日期
     *
     * @param date     指定的日期
     * @param addCount 相隔的月数
     * @return 返回的日期
     */
    public static Date addMonth(Date date, int addCount) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(shortStrToDate(dateToShortString(date)));
        calendar.add(Calendar.MONTH, addCount);
        return calendar.getTime();
    }

    /**
     * 获得周日期列表
     *
     * @return 日期集合
     * @throws Exception
     */
    public static List getDateWeekList() throws Exception {
        List list = new ArrayList();
        Calendar c = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(formatter2.format(c.getTime()));
        for (int i = 0; i < 12; i++) {
            Map weekMap = new HashMap();
            // 设置当前年
            c.set(Calendar.YEAR, year);
            // 设置第几周
            c.set(Calendar.WEEK_OF_YEAR, c.WEEK_OF_YEAR - 1 + i);
            // 设置本周第一天
            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
            String weekStart = formatter.format(c.getTime());
            weekMap.put("value", weekStart);
            // 设置本周最后一天
            c.roll(Calendar.DAY_OF_WEEK, 6);
            String weekEnd = formatter.format(c.getTime());
            weekMap.put("print", weekStart + "/" + weekEnd);
            list.add(weekMap);
        }
        return list;
    }

    /**
     * 获得月日期列表
     *
     * @return 日期集合
     */
    public static List getDateMonthList() {
        List list = new ArrayList();
        Calendar c = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(formatter2.format(c.getTime()));
        for (int i = 0; i < 12; i++) {
            Map monthMap = new HashMap();
            // 设置当前年
            c.set(Calendar.YEAR, year);
            // 滚动到月
            c.set(Calendar.MONTH, c.MONTH - 2 + i);
            String weekEnd = formatter.format(c.getTime());
            monthMap.put("value", weekEnd + "-01");
            monthMap.put("print", weekEnd);
            list.add(monthMap);
        }
        return list;
    }

    /**
     * 获得季度日期列表
     *
     * @return 日期集合
     */
    public static List getDateSeasonList() {
        List list = new ArrayList();
        Calendar c = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatter3 = new SimpleDateFormat("MM");
        int year = Integer.parseInt(formatter2.format(c.getTime()));
        int i = 0;
        while (i < 24) {
            Map seasonMap = new HashMap();
            // 设置当前年
            c.set(Calendar.YEAR, year);
            // 滚动到月
            c.set(Calendar.MONTH, c.MONTH - 2 + i);
            String weekEnd = formatter.format(c.getTime());
            seasonMap.put("value", weekEnd + "-01");
            String month = formatter3.format(c.getTime());
            String season = null;
            if (month.equals("01")) {
                season = "第一季度";
            } else if (month.equals("04")) {
                season = "第二季度";
            } else if (month.equals("07")) {
                season = "第三季度";
            } else if (month.equals("10")) {
                season = "第四季度";
            }
            seasonMap.put("print", formatter2.format(c.getTime()) + season);
            list.add(seasonMap);
            i += 3;
        }
        return list;
    }

    /**
     * 获得年日期列表
     *
     * @return 日期集合
     */
    public static List getDateYearList() {
        List list = new ArrayList();
        Calendar c = new GregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        int year = Integer.parseInt(formatter.format(c.getTime()));
        for (int i = 0; i < 6; i++) {
            Map yearMap = new HashMap();
            // 设置当前年
            c.set(Calendar.YEAR, year + i);
            String weekEnd = formatter.format(c.getTime());
            yearMap.put("value", weekEnd + "-01-01");
            yearMap.put("print", weekEnd);
            list.add(yearMap);
        }
        return list;
    }





    /**
     * 取得当前日期的字符串表示，格式为"yyyy-MM-dd HH:mm:ss"
     *
     * @return 返回格式化的日期字符串
     */
    public static String getNowStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date Now = new Date();
        return formatter.format(Now);
    }

    /**
     * 取得当前的日期，格式"yyyyMMdd"
     *
     * @param Now 日期
     * @return 返回格式化的日期字符串
     */
    public static String getYYYYMMDD(Date Now) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(Now);
    }

    /**
     * 取得当前的日期，格式"yyyy年MM月dd日"
     *
     * @param Now 日期
     * @return 返回格式化的日期字符串
     */
    public static String getYearMonthDate(Date Now) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        return formatter.format(Now);
    }

    /**
     * 将毫秒数转换为字符串描述
     *
     * @param mss    要转换的毫秒数
     * @param format 输出格式 (CHS、DIGI)
     * @return 毫秒数转换为*天*小时*分钟*秒的格式或者00:00:00的格式
     */
    public static String exportDuringByFormat(long mss, String format) {
        String duration = "";
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        if ("CHS".equals(format)) {
            if (days > 0) {
                duration = duration + days + "天";
            }
            if (hours > 0) {
                duration = duration + hours + "小时";
            }
            if (minutes > 0) {
                duration = duration + minutes + "分钟";
            }
            if (seconds > 0) {
                duration = duration + seconds + "秒";
            }
            if ("".equals(duration)) {
                duration = "0秒";
            }
        } else if ("DIGI".equals(format)) {
            String dHour = "";
            String dMinute = "";
            String dSecond = "";
            if (hours > 0) {
                if (days > 0) {
                    hours = hours + days * 24;
                }
                String str = String.valueOf(hours);
                if (str.length() > 1) {
                    dHour = str;
                } else {
                    dHour = "0" + str;
                }
            } else if (hours == 0) {
                dHour = "00";
            }
            if (minutes > 0) {
                String str = String.valueOf(minutes);
                if (str.length() > 1) {
                    dMinute = str;
                } else {
                    dMinute = "0" + str;
                }
            } else if (minutes == 0) {
                dMinute = "00";
            }
            if (seconds > 0) {
                String str = String.valueOf(seconds);
                if (str.length() > 1) {
                    dSecond = str;
                } else {
                    dSecond = "0" + str;
                }
            } else if (seconds == 0) {
                dSecond = "00";
            }
            duration = dHour + ":" + dMinute + ":" + dSecond;
        }
        return duration;
    }

    /**
     * 计算开始与结束时间之间的耗时
     *
     * @param beginDate 时间段的开始
     * @param endDate   时间段的结束
     * @return 返回将输入的两个Date类型数据之间的时间间格，用*天*时*分*秒的格式展示
     */
    public static String getDuration(Date beginDate, Date endDate) {
        return exportDuringByFormat(endDate.getTime() - beginDate.getTime(), "DIGI");
    }


    /**
     * java日期的每周的第几天
     *
     * @param day
     * @return 星期几
     */
    private static String getDayOfWeek(int day) {
        String dayOfWeek = "";
        switch (day) {
            case 1:
                dayOfWeek = "日";
                break;
            case 2:
                dayOfWeek = "一";
                break;
            case 3:
                dayOfWeek = "二";
                break;
            case 4:
                dayOfWeek = "三";
                break;
            case 5:
                dayOfWeek = "四";
                break;
            case 6:
                dayOfWeek = "五";
                break;
            case 7:
                dayOfWeek = "六";
                break;
            default:
                break;
        }
        return dayOfWeek;
    }

    private static Date getDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(date);
        } catch (ParseException e) {
            // String yyyy-MM-dd de date将string转换为date型异常
            e.printStackTrace();
        }
        return date1;
    }

    private static String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = sdf.format(new Date());
        return currentDateTime;
    }

    /**
     * 获取当前时间的毫秒格式显示字符
     *
     * @return
     */
    private static String getDateTimeStamp() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String currentDateTime = sdf.format(new Date());
        return currentDateTime;
    }

    public static String getDateAfterDays(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + days);
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String futureDate = sdf.format(calendar.getTime());
        return futureDate;
    }

    /**
     * 取得当前的日期
     *
     * @return 返回日期对象
     */
    private static Date getNowDate() {
        return new Date();
    }

    public static String getTodayDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);

    }



    public static void main(String[] args) {
//		try {
//			System.out.println(getDuration(strToDate("2014-11-11"),getCurrentTime()));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
    }
}