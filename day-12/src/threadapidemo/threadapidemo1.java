package threadapidemo;

public class threadapidemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("线程1");
        //t1.setName("线程1");
        t1.start();
        System.out.println(t1.getName());//线程1
        Thread t2 = new MyThread(" ");
        t2.start();
        System.out.println(t2.getName());//线程默认名字是Thread-索引
        //哪个线程调用这个代码，这个代码就打印哪个线程的名字
        Thread m = Thread.currentThread();
        System.out.println(m.getName());// main
    }
}
class MyThread extends Thread{
    public MyThread(String name){
        super(name);//public Thread(String name)在有参构造器里面设置名字
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

