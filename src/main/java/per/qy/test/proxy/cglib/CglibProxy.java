package per.qy.test.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    /**
     * 被代理的对象
     */
    private Object object;

    public CglibProxy(Object object) {
        this.object = object;
    }

    public static Object getProxyInstance(Object object) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(new CglibProxy(object));
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before cglib proxy");
        Object result = method.invoke(object, objects);
        System.out.println("after cglib proxy");
        return result;
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserService userServiceProxy = (UserService) CglibProxy.getProxyInstance(userService);
        userServiceProxy.setName("呵呵哒");
        System.out.println(userServiceProxy.getName());
    }
}
