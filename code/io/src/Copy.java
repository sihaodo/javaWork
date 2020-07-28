import java.io.*;

public class Copy {
    public static void func() throws Exception{
        File inFile = new File("E:\\javaWork\\data\\io\\fromHere");
        File outFile = new File("E:\\javaWork\\data\\io\\toHere");
        if(!inFile.exists()){
            inFile.mkdir();
        }
        if(!outFile.exists()){
            outFile.mkdir();
        }
        Copy.method(inFile,outFile);
    }

    private static void method(File inFile,File outFile) throws Exception{
        File[] files = inFile.listFiles();
        for (File file:files){
            if(file.isDirectory()){
                File temp = new File(outFile.getAbsolutePath()+"\\"+file.getName());
                temp.mkdir();
                Copy.method(file,temp);
            } else {
                File toFile = new File(outFile.getAbsolutePath()+"\\"+file.getName());
                toFile.createNewFile();
                Copy.copyTo(file,toFile);
            }
        }
    }

    private static void copyTo(File inFile,File outFile) throws Exception{
        try(OutputStream outputStream = new FileOutputStream(outFile)){
            try(InputStream inputStream = new FileInputStream(inFile)){
                byte[] datas = new byte[100];
                while (inputStream.read(datas) != -1){
                    outputStream.write(datas);
                }
            }
        }
    }
}
