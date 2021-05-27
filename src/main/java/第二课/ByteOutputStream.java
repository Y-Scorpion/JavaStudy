package 第二课;

import java.io.*;

public class ByteOutputStream {

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        for (int i = 0; i <10; i++) {
//        testFileInputStream1();//复制操作，先读后写操作        188483858500纳秒 188.48秒
//        testFileOutputStream2();  //复制操作，先读后写操作     47654194800纳秒 47.65秒
        testFileOutputStream3();  //复制操作，先读后写操作     43867100纳秒  0.043秒 循环10次 454118600纳秒 0.45
            // 1 463704400纳秒
//        testFileOutputStream4(); //复制操作，先读后写操作  60992067000纳秒 60.99秒
//        testBufferedOutputStream1(); //复制操作，先读后写操作    945025500纳秒 0.9秒
//        testBufferedOutputStream2();//复制操作，先读后写操作     0.045秒
        }
        long overTime = System.nanoTime();      //获取结束时间
        System.out.println("\r复制操作运行时间为："+(overTime-startTime)+"纳秒");
    }
    private static final String inputFile="src/main/java/第二课/file/IP.txt";
    private static final String outputFile="src/main/java/第二课/file/Output.txt";


    public static void testFileOutputStream1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        int line;
        while ((line =fileInputStream.read())!=-1){
            fileOutputStream.write(line);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
    public static void testFileOutputStream2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));

        int line;
        while ((line =fileInputStream.read())!=-1){
            bufferedOutputStream.write(line);
        }
        fileInputStream.close();
        bufferedOutputStream.close();
    }
    public static void testFileOutputStream3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        OutputStream outputStream = new FileOutputStream(outputFile,true);
        byte[] bytes = new byte[1024*1024];
        int line;
        while ((line =fileInputStream.read(bytes))>0){
            outputStream.write(bytes,0,line);
        }
        outputStream.flush();
        fileInputStream.close();
        outputStream.close();
    }

    public static void testFileOutputStream4() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
        OutputStream outputStream = new FileOutputStream(outputFile);
        int line;
        while ((line =bufferedInputStream.read())>0){
            outputStream.write(line);
        }
        bufferedInputStream.close();
        outputStream.close();
    }
    public static void testBufferedOutputStream1() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));

        int line;
        while ((line =bufferedInputStream.read())>0){
            bufferedOutputStream.write(line);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    public static void testBufferedOutputStream2() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile,true));
        byte[] bytes = new byte[1024*1024];
        int line;
        while ((line =bufferedInputStream.read(bytes))>0){
            bufferedOutputStream.write(bytes,0,line);
        }
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
