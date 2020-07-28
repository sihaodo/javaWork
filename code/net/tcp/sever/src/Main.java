import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(2020);
        while (true){
            Socket socket = serverSocket.accept();
            try(InputStream inputStream = socket.getInputStream()){
                try(OutputStream outputStream = socket.getOutputStream()){
                    Main.run(inputStream,outputStream);
                }
            } finally {
                socket.close();
            }
        }
    }

    private static void run(InputStream inputStream, OutputStream outputStream) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("hello\n");
        writer.flush();
        while (true){
            String s = reader.readLine();
            System.out.println(s);
            if(s.equals("end")){
                writer.write("bye:"+s);
                writer.newLine();
                break;
            }
            writer.write("ok:"+s);
            writer.newLine();
            writer.flush();
        }
        /*BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        writer.write("hello\n");
        writer.flush();
        while (true) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok: " + s + "\n");
            writer.flush();
        }*/
    }
}
