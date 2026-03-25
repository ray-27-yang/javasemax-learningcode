package threadsafe_synchronized2;

public class demo1 {
    public static void main(String[] args) {
        //1.设计一个账户类，用于创建共同账户对象，存入10万元
        Account acc = new Account(100000);//用有参构造器存钱
        //2.创建两个线程，模拟小红和小明同时取钱
        new DrawThread("小明", acc).start();
        new DrawThread("小红", acc).start();
    }
}
