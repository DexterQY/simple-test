package per.qy.test.proxy.jdkdynamic;

public class UserServiceImpl implements UserService {
    @Override
    public void setName(String name) {
        System.out.println("user set name: " + name);
    }

    @Override
    public String getName() {
        return "hello";
    }
}
