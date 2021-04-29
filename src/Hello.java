public class Hello implements Runnable{
    private volatile boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while(flag){
            System.out.println("run ...thread"+(++i));
        }
    }
    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        Hello hello=new Hello();
        new Thread(hello).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程:  "+i);
            if(i==900){
                hello.stop();
                System.out.println("------子进程停----------");
                System.out.println("------github test----------");
                
            }
        }
    }
}
