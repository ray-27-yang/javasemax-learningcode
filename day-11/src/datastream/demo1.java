package datastream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;


public class demo1 {
    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("day-10\\src\\demo5"));
        ) {
            dos.writeInt(100);
            dos.writeBoolean(true);
            dos.writeChar('a');
            dos.writeDouble(3.14);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
