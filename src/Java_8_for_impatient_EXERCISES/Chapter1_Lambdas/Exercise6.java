package Java_8_for_impatient_EXERCISES.Chapter1_Lambdas;

import java.io.IOException;

/**
 *
 * Didn’t you always hate it that you had to deal with checked exceptions in a
 Runnable ? Write a method uncheck that catches all checked exceptions and turns
 them into unchecked exceptions. For example,
 new Thread(uncheck(
 () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
 // Look, no catch (InterruptedException)!
 Hint: Define an interface RunnableEx whose run method may throw any excep-
 tions. Then implement public static Runnable uncheck(RunnableEx runner) . Use a
 lambda expression inside the uncheck function.
 Why can’t you just use Callable<Void> instead of RunnableEx ?
 *
 */
public class Exercise6 {

    public static void main(String[] args) {
        new Thread(uncheck(
                () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
    }

    public static Runnable uncheck(RunnableEx runner){
        return () -> {
            try {
                runner.run();
            } catch (Error | RuntimeException e) {
                throw e;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

}

@FunctionalInterface
interface RunnableEx {
    void run() throws Exception;
}
