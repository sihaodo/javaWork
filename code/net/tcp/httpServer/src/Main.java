import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        ServerSocket serverSocket = new ServerSocket(2020);
        while (true){
            Socket socket = serverSocket.accept();
            Thread thread = new Hander(socket);
            thread.start();
        }

    }
}
