package features.jvm8;

public class EvenOddPrintThreadUsingWaitAndNotify implements Runnable {

    Object object;
    static int i = 1;

    public EvenOddPrintThreadUsingWaitAndNotify(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while (i <= 10) {
            if (i%2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " +i);
                    i++;
                    try {
                        object.wait();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            }
            if (i%2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " : " +i);
                    i++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object someObjectToLockOn  = new Object();
        Runnable runnable1 = new EvenOddPrintThreadUsingWaitAndNotify(someObjectToLockOn);
        Runnable runnable2 = new EvenOddPrintThreadUsingWaitAndNotify(someObjectToLockOn);
        new Thread(runnable1, "even").start();
        new Thread(runnable2, "odd").start();
    }
}
