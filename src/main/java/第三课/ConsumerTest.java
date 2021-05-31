package 第三课;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        //channel，有界阻塞队列，容量100
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(500);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        System.out.println("生产者，消费者开始运行");
        long startTime = System.nanoTime();
        new Thread(producer).start();
        Thread thread = new Thread(consumer);
        thread.start();
        thread.join();
        long overTime = System.nanoTime();
        System.out.println("\r复制操作运行时间为："+(overTime-startTime)+"纳秒");
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable{

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            String data;
            //获取消息，收到exit后退出
            while(!(data = queue.take()).equals("exit")){
//                Thread.sleep(500);
                System.out.print(data);
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
//    private static final String inputFile=;
    private final BlockingQueue<String> queue;
    //队列
    public Producer(BlockingQueue<String> q){
        this.queue=q;
    }
    @Override
    public void run() {
        //生产消息
        File file = new File("src/main/java/第二课/file/IP.txt");


        try {
            if(file.isFile()||file.exists()){
                long length = file.length();
                System.out.println("文件大小： "+length);
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[1024*1024];
                int line;
                while ((line =fileInputStream.read(bytes))!=-1){
                    queue.put(new String(bytes,0,line));
                }
            }else {
                System.out.println("文件不存在");
            }
            //读文标记
            queue.put("exit");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
