package threadsafe_synchronized3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    private double balance;
    private final Lock lk = new ReentrantLock();//创建锁对象,加final保护锁对象，锁对象不能再更改，防止把锁撬了

    public void drawMoney(double money) {
        //拿到当前是谁在取钱
        String name = Thread.currentThread().getName();
        lk.lock();//获取锁
        try {
            //判断余额是否充足
            if (balance >= money) {
                System.out.println(name + "取钱" + money +"成功");
                balance -= money;
                System.out.println(name + "取钱后余额为：" + balance);
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
        } finally {
            lk.unlock();//释放锁
        }
    }
}

