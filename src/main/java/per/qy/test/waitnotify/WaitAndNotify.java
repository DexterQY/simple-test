package per.qy.test.waitnotify;

public class WaitAndNotify {

    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();
    private static final Object LOCK3 = new Object();

    static class Task1 implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK1) {
                System.out.println("task1 lock1");
                try {
                    // 这里没有synchronized LOCK3会报错
                    LOCK3.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK2) {
                    System.out.println("task1 lock2");
                    try {
                        LOCK1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("task1 end");
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LOCK1) {
                System.out.println("task2 lock1");
            }
            synchronized (LOCK2) {
                System.out.println("task2 lock2");
            }
            System.out.println("task2 end");
        }
    }

    static class Task3 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task3 notify");
            synchronized (LOCK1) {
                LOCK1.notify();
            }
            System.out.println("task3 end");
        }
    }

    public static void main(String[] args) {
        // wait和notify必须和synchronized的对象一致
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();
        new Thread(new Task3()).start();
    }
}
