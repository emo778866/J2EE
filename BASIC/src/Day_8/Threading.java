package Day_8;

class Multithreading extends Thread {

    private final int threadNumber;

    public Multithreading(int _threadNumber) {
        this.threadNumber = _threadNumber;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from thread " + threadNumber);
            if (threadNumber == -1) {
                throw new RuntimeException();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {
            }
        }
    }
}

public class Threading {
    public static void main(String[] args) {

        Multithreading myThread = new Multithreading(999);

        System.out.println("The output will be linear as there is only one thread and the run() does not start any thread.");
        myThread.run();

        System.out.println("The output for a single thread was not differentiable. Let's create multiple thread and see the difference.");
        for (int i = 0; i < 3; i++) {
            Multithreading myThreadObject = new Multithreading(i);
            myThreadObject.start();
        }

        System.out.println("Let's the speciality of thread which is if any thread is not working during runtime it will not effect the other threads!!!");
        Multithreading myThreadException = new Multithreading(-1);
        myThreadException.start();

    }
}