package classMember;

import entity.Student;

import java.lang.reflect.Field;

public class FieldStu {

    public static void show() throws Exception{
        Class personCls = Student.class;
        System.out.println("class名:"+ personCls.getName());
        Field[] fields = personCls.getFields();
        for (Field f: fields) {
            System.out.println(f.getName());
        }
        System.out.println("fields数:"+fields.length);
        Field[] fieldsDe = personCls.getDeclaredFields();
        for (Field f: fieldsDe) {
            System.out.println(f.getName());
        }
        System.out.println("fieldsDe数:"+fields.length);
        Student student = new Student("nx",170);
        Field field = personCls.getField("tall");
        int tall = (int)field.get(student);
        System.out.println("field名："+field.getName());
        System.out.println("field类型："+field.getType());
        System.out.println("field修饰符："+field.getModifiers());
        System.out.println("tall："+ student.tall);
        field.set(student,182);
        System.out.println("tall："+ student.tall);
        Field fieldSch = personCls.getDeclaredField("schoolName");
        System.out.println("SchoolName："+ student.getSchoolName());
        fieldSch.setAccessible(true);
        fieldSch.set(student,"sihao");
        System.out.println("SchoolName："+ student.getSchoolName());

    }

}
