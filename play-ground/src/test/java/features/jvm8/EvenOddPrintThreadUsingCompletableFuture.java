package features.jvm8;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrintThreadUsingCompletableFuture {

    private static Object object = new Object();
    private static IntPredicate evenPredicate = value -> value%2 == 0;
    private static IntPredicate oddPredicate = value -> value%2 != 0;


    public EvenOddPrintThreadUsingCompletableFuture() {
    }

    public static void execute(int number) {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " : " +number);
            try {
                object.notify();
                object.wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public static void printNumber (IntPredicate condition) {
        IntStream.rangeClosed(1,10).filter(condition).forEach(EvenOddPrintThreadUsingCompletableFuture::execute);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> EvenOddPrintThreadUsingCompletableFuture.printNumber(evenPredicate));
        CompletableFuture.runAsync(() -> EvenOddPrintThreadUsingCompletableFuture.printNumber(oddPredicate));
        Thread.sleep(5000);
    }
}
