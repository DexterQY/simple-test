package per.qy.test.proxy.jdkdynamic;

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
        // proxy是jdk动态代理运行时实际生成的对象，一般没什么卵用
        System.out.println(proxy.getClass());

        System.out.println("before jdk dynamic proxy");
        Object result = method.invoke(object, args);
        System.out.println("after jdk dynamic proxy");
        return result;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService userServiceProxy = (UserService) JdkDynamicProxy.getProxyInstance(userService);
        userServiceProxy.setName("呵呵哒");
        System.out.println(userServiceProxy.getName());
    }
}
