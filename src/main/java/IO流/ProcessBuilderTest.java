package IO流;

import java.io.File;
import java.io.IOException;

/**
 * 启动后无法退出问题未解决
 */
public class ProcessBuilderTest {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd").inheritIO().directory(new File("c:"));
        pb.start();
    }
}
