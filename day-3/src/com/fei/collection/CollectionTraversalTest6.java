package com.fei.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalTest6 {
    public static void main(String[] args) {
        //认识并发修改问题，搞清楚每种遍历的区别
        ArrayList<String>  list = new ArrayList<>();
        list.add("java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("枸杞");
        list.add("人字拖");

        System.out.println(list);// [java入门, 宁夏枸杞, 黑枸杞, 枸杞, 人字拖]

        //需求一：删除所有枸杞
//        for (int i = 0;i < list.size();i++) {
//            String name = list.get(i);
//            if (name.contains("枸杞")){
//                list.remove(name);
//            }
//        }
//        System.out.println(list);// [java入门, 枸杞, 人字拖, 黑枸杞]没有删干净
                                // [java入门, 宁夏枸杞, 黑枸杞, 枸杞, 人字拖]
                                  //    i
                                 //           i
                                 //[java入门,黑枸杞, 枸杞, 人字拖]
                                 //                  i
                                //[java入门,黑枸杞,人字拖]
                                //黑枸杞被略过了，原因是删完后后面的会补上前面的，就会被略过去
//        for (int i = 0;i < list.size();i++) {
//            String name = list.get(i);
//            if (name.contains("枸杞")){
//                list.remove(name);
//                i--;
//            }
//        }
//        System.out.println(list);
        //倒着遍历并删除，前提是支持索引
//        for (int i = list.size() - 1; i >= 0; i--) {
//            String name = list.get(i);
//            if (name.contains("枸杞")){
//                list.remove(name);
//            }
//        }
//        //[java入门, 宁夏枸杞, 黑枸杞, 枸杞, 人字拖]
//        System.out.println(list);//[java入门, 人字拖]
        System.out.println("==========================");
        //迭代器遍历，默认存在并发修改异常问题
        //可以解决，用迭代器自己提供的方法删除，不要直接用集合删除
//        Iterator<String> it = list.iterator();
//        while (it.hasNext())
//        {
//            String name = it.next();
//            if (name.contains("枸杞")){
//                //list.remove(name);
//                it.remove();
//            }
//        }





    }
}
