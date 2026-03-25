package Mapdemo6;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class mapdemo6 {
    public static void main(String[] args) {                                         //Lombok生成的getter方法遵循驼峰命名法
        Map<Teacher, String> map = new TreeMap<>((o1, o2)->Double.compare(o1.getSalary(),o2.getSalary()));
        map.put(new Teacher("小王", 18, 5000), "456期");
        map.put(new Teacher("小里", 21, 4000), "789期");
        map.put(new Teacher("小张", 19, 3000), "123期");

    }
}
