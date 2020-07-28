package stream;

import java.io.*;

public class InputOut {

    public static void func() throws Exception{
        File file = new File("E:\\javaWork\\data\\io\\inout.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        try(OutputStream outputStream = new FileOutputStream(file)){
            try(InputStream inputStream = new FileInputStream(file)){
                InputOut.method(inputStream,outputStream);
            }
        }
    }

    private static void method(InputStream inputStream,OutputStream outputStream) throws Exception{
        outputStream.write("hello".getBytes());
        outputStream.flush();
        byte[] datas = new byte[100];
        while (inputStream.read(datas) != -1){
            System.out.println("input :" + new String(datas));
        }
    }
}
