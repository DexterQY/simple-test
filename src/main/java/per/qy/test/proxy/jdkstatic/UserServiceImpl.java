package per.qy.test.proxy.jdkstatic;

public class UserServiceImpl implements UserService {
    @Override
    public void setName(String name) {
        System.out.println("user set name: " + name);
    }
}
