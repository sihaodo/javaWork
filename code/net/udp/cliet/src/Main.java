import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        DatagramSocket ds = new DatagramSocket();
        ds.connect(InetAddress.getByName("localhost"),2020);
        DatagramPacket datagramPacket = null;
        String s = null;
        String send = null;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(">>>");
            send = scanner.nextLine();
            datagramPacket = new DatagramPacket(send.getBytes(),send.length());
            ds.send(datagramPacket);

            byte[] bytes = new byte[100];
            datagramPacket = new DatagramPacket(bytes,bytes.length);
            ds.receive(datagramPacket);
            s = new String(datagramPacket.getData(),datagramPacket.getOffset(),datagramPacket.getLength());
            System.out.println(s);

        }
    }
}
