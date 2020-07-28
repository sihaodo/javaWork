package proxy;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void run(){
        StarProxy starProxy = new StarProxy();
        starProxy.setStar(new StarImple());
        Star star = (Star) Proxy.newProxyInstance(Star.class.getClassLoader(),new Class[]{Star.class},starProxy);
        star.sing();
    }
}
