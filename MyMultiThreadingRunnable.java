public class MyMultiThreadingRunnable {
    public static void main(String[] args) {
        RunOne r1 = new RunOne();
        RunTwo r2 = new RunTwo();
        RunThree r3 = new RunThree();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch(InterruptedException e) {
            System.out.println("Error!");
        }
        System.out.println("This is the main thread which will execute at last");
    }
}

class RunOne implements Runnable{
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Thread One");
        }
    }
}

class RunTwo implements Runnable{
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Thread Two");
        }
    }
}

class RunThree implements Runnable{
    public void run() {
        for(int i = 0; i < 3; i++) {
            System.out.println("Thread Three");
        }
    }
}