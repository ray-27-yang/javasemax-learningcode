package Mapdemo5;

import java.util.*;

public class mapdemotest {
    public static void main(String[] args) {
        calc();

    }
    public static void calc(){
        // 1.把80个学生选择的景点数据拿到程序中来
        List<String> location = new ArrayList<>();
        String[] names = {"南京梧桐","杭州西湖","赛里木湖","泰国曼谷"};
        Random r = new Random();
        for (int i = 1; i <= 80; i++) {
            //location.add(names[(int)(Math.random() * names.length)]);
            int index = r.nextInt(names.length);
            location.add(names[index]);
        }
        System.out.println(location);
        //location = [南京梧桐, 杭州西湖, 赛里木湖, 泰国曼谷, 杭州西湖, ...]

        // 2.统计每个景点被选择的次数，创建一个Map集合，键是景点名称，值是选择的次数
        Map<String,Integer> map = new HashMap<>();//map = {}

        //3.记票：遍历location集合，得到每个景点名称，在map里面没有就记录健，有就记录值加一
        for (String s : location) {
//            if (!map.containsKey(s)){
//                //景点第一次出现
//                map.put(s,1);
//            }else {
//                map.put(s,map.get(s) + 1);
//            }
            //map.put(s,map.containsKey(s) ? map.get(s) + 1 : 1);
            map.put(s,map.containsKey(s) ? map.get(s) + 1 : 1);
        }
        // 4.遍历map集合，得到景点名称和选择的次数
        map.forEach((k,v)-> System.out.println(k + "=" + v));
    }
}


