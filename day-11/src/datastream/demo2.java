package datastream;


import java.io.DataInputStream;
import java.io.FileInputStream;

public class demo2 {
    public static void main(String[] args) {
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("day-10\\src\\demo5"));
        ) {
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readChar());
            System.out.println(dis.readDouble());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
