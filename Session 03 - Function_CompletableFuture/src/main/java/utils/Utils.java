package utils;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Utils {


    /**
     * Queues the runnable on SWT-Thread-Queue. This means the runnable will be run sometime in the future. Therefore it
     * does not blocks the calling thread.
     *
     * @param runnable Runnable to queue in SWT-Thread-Queue
     */
    public static void queueInSwtThread(Runnable runnable) {
        //...
    }

    /**
     * Queues a runnable on SWT-Thread-Queue, which applies the object to the consumer. This means the runnable will be
     * run sometime in the future. Therefore it does not blocks the calling thread.
     *
     * @param consumer Runnable to queue in SWT-Thread-Queue
     * @param object   accept
     */
    public static <T> void queueInSwtThread(Consumer<T> consumer, T object) {
        queueInSwtThread(() -> consumer.accept(object));
    }

    /**
     * Executes the runnable on SWT-Thread and waits if necessary for this Runnable to complete. Therefore it blocks the
     * calling thread. Only call this method from a Thread other than the SWT-Thread.
     *
     * @param runnable Runnable to run on SWT-Thread
     */
    public static void waitForSwtThread(Runnable runnable) {
        //...
    }

    /**
     * Converts the Supplier to a new Supplier, which executes the given Supplier on the SWT-thread and waits if necessary
     * for it to complete. Therefore it blocks the calling thread. Only call this method from a Thread other than the
     * SWT-Thread.
     *
     * @param supplier Supplier to run on SWT-Thread
     * @return Supplier for generic Class R
     */
    public static <R> Supplier<R> waitForSwtThread(Supplier<R> supplier) {
        class SWTRunnable implements Runnable {
            private R r;

            R getR() {
                return r;
            }

            @Override
            public void run() {
                r = supplier.get();
            }
        }
        SWTRunnable SWTRunnable = new SWTRunnable();
        waitForSwtThread(SWTRunnable);
        return SWTRunnable::getR;
    }

    /**
     * Converts the Function to a new Function, which executes the given Function on the SWT-Thread and waits if necessary
     * for it to complete. Therefore it blocks the calling thread. Only call this method from a Thread other than the
     * SWT-Thread.
     *
     * @param <T>      generic class for Function
     * @param <R>      generic class for Function
     * @param function Function to run on SWT-Thread
     * @return Function T, R
     */
    public static <T, R> Function<T, R> waitForSwtThread(Function<T, R> function) {
        return t -> {
            class SWTRunnable implements Runnable {
                private R r;

                public R getR() {
                    return r;
                }

                @Override
                public void run() {
                    r = function.apply(t);
                }
            }
            SWTRunnable sWTRunnable = new SWTRunnable();
            waitForSwtThread(sWTRunnable);
            return sWTRunnable.getR();
        };
    }


}
