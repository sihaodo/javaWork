import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",2020);
        try(InputStream inputStream = socket.getInputStream()){
            try(OutputStream outputStream = socket.getOutputStream()){
                Main.run(inputStream,outputStream);
            }
        } finally {
            socket.close();
        }
    }
    private static void run(InputStream inputStream, OutputStream outputStream) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        String s = null;
        System.out.println(reader.readLine());
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println(">>>");
            String send = scanner.nextLine();
            writer.write(send);
            writer.newLine();
            writer.flush();
            s = reader.readLine();
            System.out.println("<<<"+s);
        }
        /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[server] " + reader.readLine());
        while (true) {
            System.out.print(">>> "); // 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
        }*/
    }
}
