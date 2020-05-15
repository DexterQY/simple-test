package per.qy.test.proxy.jdkstatic;

public class UserServiceProxy implements UserService {

    /**
     * 被代理的对象
     */
    private UserService userService;

    private UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public static UserService getProxyInstance(UserService userService) {
        return new UserServiceProxy(userService);
    }

    @Override
    public void setName(String name) {
        System.out.println("before user set name");
        userService.setName(name);
        System.out.println("after user set name");
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService userServiceProxy = UserServiceProxy.getProxyInstance(userService);
        userServiceProxy.setName("呵呵哒");
    }
}
