package IO流;

import java.io.*;

/**
 * IPS.txt  将近30M二百万IP数据文本数据 用来测试读取时间计算
 * 字节流
 * 输入字节流：inputStream 输入字节流顶级父类（抽象类）
 *      FileInputStream 文件输入流
 *      FilterInputStream 装饰包装输入流
 *          BufferedInputStream 缓存输入流
 *          DataInputStream 数据输入流
 *      ObjectInputStream 对象输入流
 *      PipedInputStream 管道流
 * 输出字节流：outputStream输出字节流顶级父类（抽象类）
 *      FileOutputStream 文件输出流
 *
 */
public class ByteInputStreams {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();  //nanoTime()获取当前精度时间（纳秒）多用于计算程序运行时间
//        for (int i = 0; i < 10; i++) {
//        testFileInputStream1(); //纯读取文件 循环十次运行时间1364659457800纳秒 平均每次约136.46秒
//        testFileInputStream2(); //纯读取文件 循环十次运行时间13432788100纳秒 平均每次约1.34秒    性能约提升101倍
//        testFileInputStream3(); //纯读取文件 循环十次运行时间11389524200纳秒 平均每次约1.13秒    性能约提升120倍
        testFileInputStream4(); //纯读取文件 循环十次运行时间11370029800纳秒 平均每次约1.13秒    性能约提升120倍
//        testBufferedInputStream1();   //纯读取文件 循环十次运行时间479784725200纳秒 平均每次约47.97秒 性能约提升2.8倍
//        testBufferedInputStream2();//纯读取文件 循环十次运行时间12026112300纳秒 平均每次约1.20秒 性能约提升113倍
//        testBufferedInputStream3();//纯读取文件 循环十次运行时间12005131500纳秒 平均每次约1.20秒   性能约提升113倍
//        testDataInputStream1(); //纯读取文件 循环十次运行时间618455907000纳秒  平均每次约61.84秒
//        testDataInputStream2(); //纯读取文件 循环十次运行时间11483766500纳秒  平均每次约1.14秒
//        }


        long overTime = System.nanoTime();      //获取结束时间
        System.out.println("\r程序运行时间为："+(overTime-startTime)+"纳秒");


    }

    private static final String inputFile="src/main/java/第二课/file/IP.txt";
    private static final String outputFile="src/main/java/第二课/file/OutptIps.txt";

    //文件输入流
    public static void testFileInputStream1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        int line;
        while ((line =fileInputStream.read())!=-1){
            System.out.print((char)line);
        }
        fileInputStream.close();
    }
    public static void testFileInputStream2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        byte[] bytes = new byte[1024];
        int line;
        while ((line =fileInputStream.read(bytes))>0){
            System.out.print(new String(bytes,0,line));
        }
        fileInputStream.close();
    }
    public static void testFileInputStream3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        byte[] bytes = new byte[10240];
        int line;
        while ((line =fileInputStream.read(bytes))>0){
            System.out.print(new String(bytes,0,line));
        }
        fileInputStream.close();
    }
    public static void testFileInputStream4() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        byte[] bytes = new byte[1024*1024];
        int line;
        while ((line =fileInputStream.read(bytes))>0){
            System.out.print(new String(bytes,0,line));
        }
        fileInputStream.close();
    }
    public static void testBufferedInputStream1() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
        int line;
        while ((line =bufferedInputStream.read())>0){
            System.out.print((char)line);
        }
        bufferedInputStream.close();
    }
    public static void testBufferedInputStream2() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
        byte[] bytes = new byte[4096];
        int line;
        while ((line =bufferedInputStream.read(bytes))>0){
            System.out.print(new String(bytes,0,line));
        }
        bufferedInputStream.close();
    }
    public static void testBufferedInputStream3() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
        byte[] bytes = new byte[1024*1024];
        int line;
        while ((line =bufferedInputStream.read(bytes))>0){
            System.out.print(new String(bytes,0,line));
        }
        bufferedInputStream.close();
    }
    public static void testDataInputStream1() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(inputFile));
        String line;
        while ((line =dataInputStream.readLine())!=null){
            System.out.print(line);
        }
        dataInputStream.close();
    }
    public static void testDataInputStream2() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(inputFile));

        byte[] bytes = new byte[4096];
        int line;
        while ((line =dataInputStream.read(bytes))>0){
            System.out.print(new String(bytes,0,line));
        }
        dataInputStream.close();
    }


}
