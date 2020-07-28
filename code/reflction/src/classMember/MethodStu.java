package classMember;

import entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodStu {
    public static void show() throws Exception{
        Class personCls = Student.class;
        Method[] methodsPub = personCls.getMethods();
        for (Method m: methodsPub) {
            System.out.println(m.getName());
        }
        System.out.println("methodsPub数:"+ methodsPub.length);
        Method[] methodsPri = personCls.getDeclaredMethods();
        for (Method m: methodsPri) {
            System.out.println(m.getName());
        }
        System.out.println("methodsPri数:"+ methodsPri.length);
        Student student = new Student("nx",170);
        Method method = personCls.getMethod("geta",int.class);
        method.invoke(student,1);
        Method methodShow = personCls.getDeclaredMethod("show");
        methodShow.setAccessible(true);
        methodShow.invoke(student);
        Method methodN = personCls.getMethod("outVa",int.class,String.class);
        methodN.invoke(student,new Object[] { 1,"2" });
    }
}
