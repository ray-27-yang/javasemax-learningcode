package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        //100个员工相当于100个线程，竞争200个红包
        //1.创建200个红包
        List<Integer> redpackets = RedPacket();
        //2.创建100个线程竞争同一个集合
        for (int i = 1; i <= 100; i++) {
            new PeoplegetRedpacket(redpackets,"人" + i).start();
        }
    }
    //红包
    public static List<Integer> RedPacket () {
        List<Integer> red = new ArrayList<>();
        Random r = new Random();
        for (int i = 1; i <= 160; i++) {
            red.add(r.nextInt(30) + 1);
        }
        for (int i = 1; i <= 40; i++) {
            red.add(r.nextInt(70) + 31);
        }
        return red;
    }
}
