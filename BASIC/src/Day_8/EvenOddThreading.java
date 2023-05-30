package Day_8;

public class EvenOddThreading {
    public static void main(String[] args) throws InterruptedException {

        Printer printer = new Printer();
        MyRunnable odd = new MyRunnable(true, printer, "Odd Thread");
        Thread t1 = new Thread(odd);
        MyRunnable even = new MyRunnable(false, printer, "Even Thread");
        Thread t2 = new Thread(even);
        t1.start();
        t1.join(100);
        t2.start();
    }
}

class Printer {
    private final Object lock = new Object();
    private boolean isOdd = false;

    public void printEven(int number, String name) throws InterruptedException {
        synchronized (lock) {
//            System.out.println("printEven method");
            while (!isOdd) {
                lock.wait();
            }
            System.out.println(name + ": " + number);
            isOdd = false;
            lock.notifyAll();
        }
    }

    public void printOdd(int number, String name) throws InterruptedException {
        synchronized (lock) {
//            System.out.println("printOdd method");
            while (isOdd) {
                System.out.println("calling wait() from printOdd method");
                lock.wait();
            }
            System.out.println(name + ": " + number);
            isOdd = true;
            lock.notifyAll();
        }
    }
}

class MyRunnable implements Runnable {

    private final boolean isOdd;
    Printer printer;

    private final String threadName;

    MyRunnable(boolean isOdd, Printer printer, String _threadName) {
        this.isOdd = isOdd;
        this.printer = printer;
        this.threadName = _threadName;
    }

    public void run() {
        int number = isOdd ? 1 : 2; // ternary
        while (number <= 10) {
            if (isOdd) {
                try {
                    printer.printOdd(number, threadName);
                } catch (InterruptedException ignored) {
                }
            } else {
                try {
                    printer.printEven(number, threadName);
                } catch (InterruptedException ignored) {
                }
            }
            number += 2;
        }
    }
}
