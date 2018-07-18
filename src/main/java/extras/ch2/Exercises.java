/**
 * Classic and modern approach to ThreadLocal
 *  override initialValue() vs. static factory withInitial()
 * 
 * @author manny egalli64@gmail.com
 * based on Java 8 Lambdas, Richard Warburton - exercise 2-b, chapter two
 * 
 * @see http://thisthread.blogspot.com/2018/07/a-thread-safe-dateformatter-via.html
 *      https://github.com/RichardWarburton/java-8-lambdas-exercises
 */
package extras.ch2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercises {
    private static int NR_TASKS = 800;

    public static void main(String[] args) {
        ex2();
    }

    private static void ex2() {
        ExecutorService exec = Executors.newCachedThreadPool();
        TaskClassic taskC = new TaskClassic();
        TaskLambda taskL = new TaskLambda();

        for (int i = 0; i < NR_TASKS / 2; i++) {
            exec.submit(taskC);
            exec.submit(taskL);
        }
        exec.shutdown();
    }

    static class TaskClassic implements Runnable {
        // ai is shared among all threads
        private static final AtomicInteger ai = new AtomicInteger(0);
        
        // each thread has its own local copy of id
        private static final ThreadLocal<Integer> id = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return ai.getAndIncrement();
            }
        };

        @Override
        public void run() {
            System.out.printf("TC %s, id=%d, ai=%d%n",
                    Thread.currentThread().getName(), id.get(), ai.get());
        }
    }

    static class TaskLambda implements Runnable {
        private static final AtomicInteger ai = new AtomicInteger(0);
        private static final ThreadLocal<Integer> id = ThreadLocal.withInitial( //
                () -> ai.getAndIncrement());

        @Override
        public void run() {
            System.out.printf("TL %s, id=%d, ai=%d%n",
                    Thread.currentThread().getName(), id.get(), ai.get());
        }
    }
}
