package per.qy.test.trap.samefield;

public class ClassBb extends ClassAa implements InterfaceAa {

    public ClassBb() {
        // 当父类和接口有相同名称属性时需要指定调用，否则编译不通过：System.out.println(a)
        System.out.println(super.a);
        System.out.println(InterfaceAa.a);
    }
}
