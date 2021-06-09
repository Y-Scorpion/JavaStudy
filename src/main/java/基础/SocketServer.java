package 基础;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket 服务端演示测试
 *
 */
public class SocketServer {
    private static final int portNumber = 8088;  //端口常量

    public static void main(String[] args) throws IOException {
            // 创建服务端socket
            ServerSocket serverSocket = new ServerSocket(portNumber); //创建服务绑定端口
            // 创建客户端socket
            Socket socket = new Socket();
            //循环监听等待客户端的连接
            while (true) {
                // 监听客户端
                socket = serverSocket.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
                InetAddress address = socket.getInetAddress();
                System.out.println("当前客户端的IP：" + address.getHostAddress());
            }
    }

}
class ServerThread extends Thread{

    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        OutputStream os=null;
        PrintWriter pw=null;
        try {
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            String info = null;

            while((info=br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }
            socket.shutdownInput();

            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("服务器欢迎你");

            pw.flush();
        } catch (Exception e) {
            // TODO: handle exception
        } finally{
            //关闭资源
            try {
                if(pw!=null)
                    pw.close();
                if(os!=null)
                    os.close();
                if(br!=null)
                    br.close();
                if(isr!=null)
                    isr.close();
                if(is!=null)
                    is.close();
                if(socket!=null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}