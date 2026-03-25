package threadsafe_synchronized2;

public class DrawThread extends Thread{
    private Account account;

    public DrawThread(String name, Account a) {
        super(name);
        this.account = a;
    }
        @Override
        public void run () {
            account.drawMoney(100000);
        }
}

