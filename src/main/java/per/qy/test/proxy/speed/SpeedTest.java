package per.qy.test.proxy.speed;

public class SpeedTest {

    static int a = 11, b = 22;

    public static void main(String[] args) {
        AddService nativeType = new AddServiceImpl();
        AddService jdkType = (AddService) JdkDynamicProxy.getProxyInstance(nativeType);
        AddService cglibType = (AddService) CglibProxy.getProxyInstance(nativeType);

        // java8开始jdk动态代理效率已经比cglib高
        int times = 1000000;
//        test(nativeType, times);
//        test(jdkType, times);
        test(cglibType, times);
    }

    private static void test(AddService addService, int times) {
        // 预热
        for (int i = 0; i < 10; i++) {
            addService.add(a, b);
        }
        long millis = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            addService.add(a, b);
        }
        System.out.println("运行时间：" + (System.currentTimeMillis() - millis));
    }
}
