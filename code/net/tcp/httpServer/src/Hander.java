import java.io.*;
import java.net.Socket;

public class Hander extends Thread{
    private Socket socket;

    public Hander(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(InputStream inputStream = socket.getInputStream()){
            try(OutputStream outputStream = socket.getOutputStream()){
                this.hander(inputStream,outputStream);
            }
        } catch (Exception e){
            try{
                socket.close();
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private void hander(InputStream inputStream,OutputStream outputStream) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        String head = reader.readLine();
        System.out.println("httpFrist:"+head);
        while (true){
            head = reader.readLine();
            if (head.isEmpty()){
                break;
            }
            System.out.println(head);
        }
        String data = "<html><body><h1>Hello, world!</h1></body></html>";
        writer.write("HTTP/1.0 200 OK\r\n");
        writer.write("Connection: close\r\n");
        writer.write("Content-Type: text/html\r\n");
        writer.write("\r\n"); // 空行标识Header和Body的分隔
        writer.write(data);
        writer.flush();


    }
}
