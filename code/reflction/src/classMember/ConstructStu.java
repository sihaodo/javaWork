package classMember;

import entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ConstructStu {

    public static void show() throws Exception{
        Class personCls = Student.class;
        Constructor constructor = personCls.getConstructor(String.class,int.class);
        Student student = (Student) constructor.newInstance("sihao",20);
        System.out.println(student.getSchoolName() + student.tall);
    }



}
