package threadapidemo;

public class threadapidemo2 {
    public static void main(String[] args) {
        //目标：线程休眠方法
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
            try {
                //让当前线程休眠1秒，再继续执行
                //项目经理让我写这段代码，用户交了钱就注释掉
                Thread.sleep(1000);//1000ms = 1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
