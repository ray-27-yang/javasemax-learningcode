package demo;

import java.util.List;

public class PeoplegetRedpacket extends Thread{
    private List<Integer> redpackets;
    public PeoplegetRedpacket(List<Integer> redpackets, String name) {
        super(name);
        this.redpackets = redpackets;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            synchronized (redpackets){
                if (redpackets.size() == 0) {//这一步放在里面保证每个人竞争到锁进来都结束死循环
                    break;
                }
                //随机一个索引
                int index = (int)(Math.random() * redpackets.size());
                Integer money = redpackets.remove(index);
                System.out.println(name + "抢到红包：" + money);
                if (redpackets.size() == 0){
                    System.out.println("活动结束");
                    break;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
