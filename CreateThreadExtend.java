class CreateThreadExtend extends Thread{
    public void run(){
        System.out.println("thread is running!");
    }
    public static void main(String args[]){
        CreateThreadExtend t1 = new CreateThreadExtend();
        t1.start();
    }
} 