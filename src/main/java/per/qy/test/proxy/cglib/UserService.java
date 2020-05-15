package per.qy.test.proxy.cglib;

public class UserService {

    public void setName(String name) {
        System.out.println("user set name: " + name);
    }

    public String getName() {
        return "hello";
    }
}
