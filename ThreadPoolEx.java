import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolEx {
    public static void main(String[] args)
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);   //creating a thread pool of 2 threads

        for (int i = 1; i <= 5; i++)
        {
            TaskThreadPool t = new TaskThreadPool("Task " + i);
            System.out.println("Created the thread: " + t.getName());

            executor.execute(t);  //calling execute method of ExecutorService
        }
        executor.shutdown();
    }
}