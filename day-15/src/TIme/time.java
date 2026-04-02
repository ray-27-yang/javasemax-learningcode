package TIme;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class time {
    public static void main(String[] args) {
        //JDK8之前的方案，Date获取此刻时间
        //不安全，若改动时间，则全部时间会被修改，时间丢失
        System.out.println(new Date());
        //简单日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE a");
        System.out.println(sdf.format(new Date()));

        //JDK8之后的方案LocalDateTime,LocalDate,LocalTime
        //更安全，若改动时间，会存储在新的变量里面，原来的时间不会丢失
        LocalDateTime now = LocalDateTime.now();//调用方法获取对象
        System.out.println(now);
        System.out.println(now.getYear());
        //时间格式化 DataTimeFormatter
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss EEE a");
        System.out.println(dtf.format(now));

        //
        StringBuilder sb = new StringBuilder();
        sb.append("hello").append("world").append(1).append(true);

        //用BigDecimal解决小数存储失真问题，这里必须用字符串构造器
        double a = 0.1;//转换成字符串
//        BigDecimal a1 = new BigDecimal(a + "");
//        BigDecimal a2 = new BigDecimal(Double.toString(a));
        //优化方案
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b = a1.add(a1);
        double c = b.doubleValue();//转换成double
        //除法
        BigDecimal i = BigDecimal.valueOf(0.1);
        BigDecimal j = BigDecimal.valueOf(0.3);
        BigDecimal k = i.divide(j,2,BigDecimal.ROUND_HALF_UP);//0.33
    }
}
