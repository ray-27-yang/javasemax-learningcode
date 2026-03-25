package threadsafe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
    private double balance;

    public void drawMoney(double money) {
        //拿到当前是谁在取钱
        String name = Thread.currentThread().getName();
        //判断余额是否充足
        if (balance >= money) {
            System.out.println(name + "取钱" + money +"成功");
            balance -= money;
            System.out.println(name + "取钱后余额为：" + balance);
        } else {
            System.out.println(name + "取钱失败，余额不足");
        }
    }
}

