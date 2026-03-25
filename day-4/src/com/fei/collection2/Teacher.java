package com.fei.collection2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Comparable<Teacher>{
    private String name;
    private int age;
    private double salary;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}' + '\n';
    }
    //t2.compareTo(t1)
    //t2 == this
    //t1 == o
    //规定：如果你认为左边大于右边，请返回正数
    //如果认为左边小于右边，请返回负数
    //如果认为两边相等，请返回0
    @Override
    public int compareTo(Teacher o) {
        //按照年龄升序排序
//        if (this.getAge() > o.getAge()) return 1;
//        if (this.getAge() < o.getAge()) return -1;
//        return 0;//这里会默认去重，按照红黑树规则的内容相同，则相同年龄会去重
        //若不想去重，就改成return 1;认为还是有一个大一点，则会排在一起
        return this.getAge() - o.getAge();//按照年龄升序排序
        //return o.getAge() - this.getAge();//按照年龄降序排序

    }
}
//implements Comparable<Teacher>
//@Override
//public int compareTo(Teacher o){
//    return this.getAge - o.getAge();
//}