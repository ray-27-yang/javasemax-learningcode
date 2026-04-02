package com.fei.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTraversalDemo3 {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("简隋英");
        names.add("张三");
        names.add("王五");
        names.add("赵六");
        System.out.println(names);//[简隋英, 张三, 王五, 赵六]
                                 //   it


        //1.获取迭代器对象
//        Iterator<String> it = names.iterator();//it是第一个数据，next表示移动到下一个数据
//        while (it.hasNext()) {//判断当前有没有数据
//            System.out.println(it.next());
//        }
        Iterator<String> it = names.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
   }

}
