package com.fei.Stream;

import java.io.Serializable;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class streamdemo3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("简隋英");
        names.add("shin");
        names.add("张三");
        names.add("王五");
        names.add("张无忌");

        //1.过滤方法
//        names.stream().filter(s->s.startsWith("张")&&s.length()==3).forEach(s->System.out.println(s));
        names.stream().filter(s->s.startsWith("张")&&s.length()==3).forEach(System.out::println);
        names.stream().filter(s->s.startsWith("张")&&s.length() == 3).forEach(s-> System.out.println(s));
        //2.排序方法
        List<Double> scores = new ArrayList<>();
        scores.add(99.9);
        scores.add(99.5);
        scores.add(99.1);
        scores.add(99.3);
        //默认升序,遍历不是中间方法不会返回流，结束链式编程
//        scores.stream().sorted().forEach(System.out::println);
        scores.stream().sorted().forEach(System.out::println);
        //降序
//        scores.stream().sorted((s1,s2)->Double.compare(s2,s1));
        scores.stream().sorted((s1,s2)->Double.compare(s2,s1));
        //降序后只要前两名
        scores.stream().sorted((s1,s2)->Double.compare(s2,s1)).limit(2);
        //降序后跳过前两名
        scores.stream().sorted((s1,s2)->Double.compare(s2,s1)).skip(2);
        //去重，如果要自定义对象去重复，要重写equals和hashCode方法，Double已经重写好了
        scores.stream().distinct().forEach(System.out::println);

        //映射方法，加工方法：把流上原来的数据拿出来变成新数据又放上去
        scores.stream().map(s->"+ 10" + (s + 10)).forEach(System.out::println);
        //合并流
        Stream<String> r1 = Stream.of("张三", "李四", "王五");
        Stream<Integer> r2 = Stream.of(1, 2, 3);

        Stream<Object> r3 = Stream.concat(r1, r2);


    }
}
