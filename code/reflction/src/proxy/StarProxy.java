package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarProxy implements InvocationHandler {

    public Star star;
    public void setStar(Star star){
        this.star = star;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("lalala");
        Object o = (Object) method.invoke(star,args);
        System.out.println("ok");
        return o;
    }
}
