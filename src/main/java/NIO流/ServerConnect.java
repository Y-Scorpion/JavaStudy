package NIO流;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * NIO  server 服务端
 */
public class ServerConnect{
  private static final int BUF_SIZE=1024;
  private static final int PORT = 8080;
  private static final int TIMEOUT = 3000;


  public static void main(String[] args){
    selector();
  }

  /**
   * 处理接受
   * @param key
   * @throws IOException
   */
  public static void handleAccept(SelectionKey key) throws IOException {
    ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
    SocketChannel sc = ssChannel.accept();
    sc.configureBlocking(false);
    sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocateDirect(BUF_SIZE));
  }

  /**
   * 处理读
   * @param key
   * @throws IOException
   */
  public static void handleRead(SelectionKey key) throws IOException {
    SocketChannel sc = (SocketChannel)key.channel();
    ByteBuffer buf = (ByteBuffer)key.attachment(); //与通道一起使用的Buffer，或是包含聚集数据的某个对象。
    long bytesRead = 0; //客户端断联 这地方报错

    try{
      while((bytesRead =sc.read(buf))>0){
        buf.flip();
        while(buf.hasRemaining()){
          System.out.print(StandardCharsets.UTF_8.decode(buf));
        }
        System.out.println();
        buf.clear();
      }
    }catch(IOException e){
      key.cancel();
      sc.socket().close();
      sc.close();
      return;
    }

    if(bytesRead == -1){
      sc.close();
    }
  }

  /**
   * 处理写出
   * @param key
   * @throws IOException
   */
  public static void handleWrite(SelectionKey key) {
    ByteBuffer buf = (ByteBuffer)key.attachment();
    buf.flip();
    SocketChannel sc = (SocketChannel) key.channel();
    while(buf.hasRemaining()){
      try {
        sc.write(buf);
      } catch (IOException e) {
        System.out.println("1111");
      }
    }
    buf.compact();
  }

  /**
   * NIO 选择器
   */
  public static void selector() {
    Selector selector = null;  //创建Selector选择器
    ServerSocketChannel ssc = null;  //创建ServerSocketChannel  服务套接字通道对象
    try{
      selector = Selector.open();  //打开一个选择器
      ssc= ServerSocketChannel.open(); //打开一个服务套接字通道
      ssc.socket().bind(new InetSocketAddress(PORT));
      ssc.configureBlocking(false);
      ssc.register(selector, SelectionKey.OP_ACCEPT); //将套接字注册到选择器以接受连接 (需要给通道设置接受的权限)
      while(true){
        if(selector.select(TIMEOUT) == 0){   //设置超时3000 毫秒 milliseconds
          System.out.println("==");
          continue;
        }
        //获取所有接收事件的Selection-Key实例  这个循环遍历已选择键集中的每个键，并检测各个键所对应的通道的就绪事件
        Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
        while(iter.hasNext()){
          SelectionKey key = iter.next();
          if(key.isAcceptable()){
            handleAccept(key);
          }
          if( key.isValid()&&key.isWritable()){
            handleWrite(key);
          }
          if(key.isValid()&&key.isReadable()){
            handleRead(key);
          }

          else if(key.isConnectable()){
            System.out.println("isConnectable = true");
          }
          iter.remove();
        }
      }
    }catch(IOException e){
      e.printStackTrace();
    }finally{
      try{
        if(selector!=null){
          selector.close();
        }
        if(ssc!=null){
          ssc.close();
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
}