package learning.multiThread.threadLocal;

import java.text.SimpleDateFormat;

/**
 * @Author: 皮皮
 * @Date: 2022/11/26 12:01
 * @Description:
 */
public class ThreadLocalRepository {

    //SimpleDateFormat类型的ThreadLocal变量
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
    };

    //String类型的ThreadLocal变量
    public static ThreadLocal<String> strThreadLocal = new ThreadLocal() {
        @Override
        protected String initialValue() {
            return "Pompy";
        }
    };



}
