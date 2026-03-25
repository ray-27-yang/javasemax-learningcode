package threadapidemo;

public class threaddemo3 {
    public static void main(String[] args) {
        //join方法：线程插队，让当前线程等待，直到调用join的线程结束
        Thread t1 = new MyThread2();
        t1.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == 2){
                try {
                    t1.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

    }
}