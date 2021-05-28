# JavaStudy
##第二课 -》java I/O流相关
### ProcessBuilderTest.java：
    测试ProcessBuilder
### IO流图
![Image text](./images/8d7b6a6c31d6e4a0c1e34d2809be40d.jpg)

### ByteStreams.java
    字节流：
        inputStream:
            FileInputStream 文件输入流
            FilterInputStream 装饰包装输入流
                BufferedInputStream 缓存输入流
                DataInputStream 数据输入流
            ObjectInputStream 对象输入流
            PipedInputStream 管道流
            ByteArrayInputStream 字节数组输入流
        outputStream:
            FileOutputStream 文件输出流 
            FilterOutputStream  装饰包装输出流
                BufferedOutputStream  缓存输出流
                DataOutputStream  数据输出流
                PrintStream 打印流
            ObjectOutputStream 对象输出流
            PipedOutputStream 管道输出流
            ByteArrayOutputStream 字节数组输出流
