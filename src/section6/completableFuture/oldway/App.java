package section6.completableFuture.oldway;

public class App {
    //extend Thread
    /*public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());

    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }*/

    //runnable or lambda
    public static void main(String[] args) throws InterruptedException {
//         Thread thread = new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 System.out.println("Thread: " + Thread.currentThread().getName());
//             }
//         });
//         thread.start();

        //sleep: sleep() method can be used to pause the execution of the current thread for a specified time in milliseconds.
        //interrupt: An interrupt is an indication to a thread that it should stop what it is doing and do something else.
        //join: allows one thread to wait until another thread completes its execution.
         Thread threadLambda = new Thread(() -> {

             while (true) {
                 try {
                     System.out.println("Thread: " + Thread.currentThread().getName());
                     Thread.sleep(3000L);
                     return;
                 } catch (Exception e) {
                     System.out.println("interrupted!");
                     //Returning from a function with a return type of void terminates the function.
                     return;
                 }
                // System.out.println("Thread: " + Thread.currentThread().getName());
             }
         });
        threadLambda.start();
        System.out.println("call join()");
        threadLambda.join();
        System.out.println("Hello: " + Thread.currentThread().getName());
        Thread.sleep(3000L);
        threadLambda.interrupt();
    }
}
