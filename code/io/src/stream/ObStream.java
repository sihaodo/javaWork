package stream;

import java.io.*;

public class ObStream {

    public static void func() throws Exception{
        Person person = new Person();
        person.setAge(11);
        person.setName("sihaodong");
        File file = new File("E:\\javaWork\\data\\io\\person.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        InputStream in = new FileInputStream(file);
        OutputStream out = new FileOutputStream(file);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)){
            try(ObjectInputStream objectInputStream = new ObjectInputStream(in)){
                objectOutputStream.writeObject(person);
                Person p = (Person) objectInputStream.readObject();
                System.out.println(p);
            }
        }
    }
}
