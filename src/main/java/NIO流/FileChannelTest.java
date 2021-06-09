package NIO流;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("src/main/java/NIO流/data/IP.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024); //分配buffer容量
        int bytesRead = inChannel.read(buf);  //从Channel写到Buffer。
        //buf.put()   Buffer的put()方法写到Buffer里
        //inChannel.write(buf);  从Buffer读取数据到Channel
        while (bytesRead != -1) {
            System.out.println(" Read " + bytesRead);
            buf.flip();  //flip方法将Buffer从写模式切换到读模式。调用flip()方法会将position设回0，并将limit设置成之前position的值。
            while(buf.hasRemaining()){
                System.out.print((char) buf.get());  //get()方法从Buffer中读取数据
            }
            buf.clear(); //清空Buffer
            bytesRead = inChannel.read(buf); //重新读取数据进入Buffer
        }
        aFile.close();
    }
    //注意 buf.flip() 的调用，首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据。
    //下一节会深入讲解Buffer的更多细节。
}
