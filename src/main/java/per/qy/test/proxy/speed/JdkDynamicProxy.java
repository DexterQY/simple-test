package per.qy.test.proxy.speed;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private Object object;

    public JdkDynamicProxy(Object object) {
        this.object = object;
    }

    public static Object getProxyInstance(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
                new JdkDynamicProxy(object));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}
