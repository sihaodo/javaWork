import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        DatagramSocket ds = new DatagramSocket(2020);
        DatagramPacket datagramPacket = null;
        String s = null;
        while (true){
            byte[] bytes = new byte[100];
            datagramPacket = new DatagramPacket(bytes,bytes.length);
            ds.receive(datagramPacket);
            s = new String(datagramPacket.getData(),datagramPacket.getOffset(),datagramPacket.getLength());
            System.out.println(s);
            datagramPacket.setData("ok".getBytes());
            ds.send(datagramPacket);
        }

    }
}
