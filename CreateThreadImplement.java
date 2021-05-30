class CreateThreadImplement implements Runnable{
    public void run(){
        System.out.println("thread is running!!!");
    }

    public static void main(String args[]){
        CreateThreadImplement m1 = new CreateThreadImplement();
        Thread t1 =new Thread(m1);
        t1.start();
    }
}