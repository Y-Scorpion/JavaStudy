package IO流;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadWriteTest {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                readSreamTest();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    private static final String inputFile="src/main/java/第二课/file/IP.txt";
    private static final String outputFile="src/main/java/第二课/file/OutptIps.txt";
    private static final StringBuffer stringBuffer = new StringBuffer();

    //文件输入流
    public static void readSreamTest()  throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        int line;
        while ((line =fileInputStream.read())!=-1){
            stringBuffer.append((char)line);
        }
        fileInputStream.close();
    }

    public static void  writeStreamTest(){
        System.out.println(stringBuffer.toString());
    }


}

