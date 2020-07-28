import proxy.Star;
import proxy.StarImple;
import proxy.StarProxy;
import proxy.TestProxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws Exception{

        //classMember.FieldStu.show();
        //classMember.MethodStu.show();
        //classMember.ConstructStu.show();
        /*Class personCls = entity.Student.class;

        Class person = personCls.getSuperclass();
        System.out.println(person.getName());
        Class[] inte = personCls.getInterfaces();
        System.out.println(inte.length);*/

        TestProxy.run();
    }
}
