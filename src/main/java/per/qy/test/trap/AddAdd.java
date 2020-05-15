package per.qy.test.trap;

public class AddAdd {

    public static void main(String[] args) {
        int i = 0;
        // 这里输出1：i++是先把i的值入栈，再操作变量i加1，加1后的i值没有重新入栈
        i = i++ + i;
        System.out.println(i);

        i = 0;
        // 这里输出2：++i是先操作变量i加1，然后把i的值入栈
        i = ++i + i;
        System.out.println(i);
    }
}
