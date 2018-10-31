package Java_8_for_impatient_EXERCISES.Chapter1_Lambdas;

/**
 * Write a static method andThen that takes as parameters two Runnable instances
 and returns a Runnable that runs the first, then the second. In the main method,
 pass two lambda expressions into a call to andThen , and run the returned
 instance.
 */

public class Exercise7 {

    public static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Echo from thread1");
        }
    }

    public static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("Echo from thread2");
        }
    }

    public static Runnable andThen(Runnable thread1, Runnable thread2) {

        return () -> {
            thread1.run();
            thread2.run();
        };

    }

    public static void main(String[] args) {

        Runnable thread1 = new Thread1();
        Runnable thread2 = new Thread2();

        andThen(thread1,thread2).run();
    }
}
