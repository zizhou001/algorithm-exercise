
class Mythread1 extends Thread{

    @Override
    public void run(){
        System.out.println("In MyThread1's run:"+Thread.currentThread().getName());
    }
}

class MyThread2 implements Runnable{



    @Override
    public void run() {
        System.out.println("In MyThread2's run:"+Thread.currentThread().getName());
    }
}

public class ThreadTestCreate {
    public static void main(String[] args) {

        System.out.println("In Main:"+Thread.currentThread().getName());


        Thread thread1 = new Mythread1();
        Thread thread2 = new Thread(new MyThread2());

//        thread1.start();
//        thread2.start();

//        thread1.run();
//        thread2.run();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}