package features.jvm9;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class ReactiveStreamsDemo {

    public static void main(String[] args) {

        Supplier<? extends String> randomWeatherSupplier = () -> List.of("Sunny", "Rainy", "Cloudy", "Partial-Cloudy", "Thunderstorm", "Tornado")
                .get(new Random().nextInt(1) + (new Random().nextInt(90))) + "F";

        //TODO::  Complete implentation

    }

    public static class PeriodicPublisher<T> extends SubmissionPublisher<T> {
        final ScheduledFuture<?> periodicTask;
        final ScheduledExecutorService scheduler;

        public PeriodicPublisher(Executor executor, int maxBufferCapacity, Supplier<? extends T> supplier,
                                 long period, TimeUnit unit) {
            super(executor, maxBufferCapacity);
            this.scheduler = new ScheduledThreadPoolExecutor(1);
            this.periodicTask = scheduler.scheduleAtFixedRate(() -> submit(supplier.get()), 0, period, unit);
        }

        @Override
        public void subscribe(Flow.Subscriber<? super T> subscriber) {
            super.subscribe(subscriber);
        }

        @Override
        public void close() {
            periodicTask.cancel(false);
            scheduler.shutdown();
            super.close();
        }
    }
}
