package stream;

import java.io.*;

public class ReadWrite {

    public static void func() throws Exception{
        File file = new File("E:\\javaWork\\data\\io\\read.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        try(Reader reader = new FileReader(file)){
            try(Writer writer = new FileWriter(file)){
                ReadWrite.run(reader,writer);
            }
        }
    }

    private static void run(Reader reader,Writer writer) throws Exception{
        writer.write("hello,sihaodong");
        writer.flush();
        char[] datas = new char[100];
        while (reader.read(datas) != -1){
            System.out.println("read :" + new String(datas));
        }
    }
}
