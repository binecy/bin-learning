package nio.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SimpleFileChannel {
    public static void main(String[] args) throws IOException {
        String info[] = {"hello", "java", "nio"};

        File file = new File("fileChannel.txt");

        System.out.println(file.getAbsolutePath());
        try (FileOutputStream output = new FileOutputStream(file); FileChannel fout = output.getChannel()) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            for(int i = 0; i < info.length; i++) {
                buf.put(info[i].getBytes());
            }

            buf.flip();
            fout.write(buf);
        }
    }
}
