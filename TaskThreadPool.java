import java.util.concurrent.TimeUnit;

public class TaskThreadPool implements Runnable {
    private String name;

    public TaskThreadPool(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing the thread number: " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}