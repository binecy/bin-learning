package java7;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;

/**
 * Created by bin on 2017/11/12.
 */
public class FileTest {

    @Test
    public void testPath() throws URISyntaxException {
        // 获取local.properties文件
        URI localProUri = this.getClass().getClassLoader().getResource("local.properties").toURI();
//        System.out.println(localProUri);
        // 转换为Path对象, 指向 .../resources/test/local.properties
        Path localProPath = Paths.get(localProUri);
        System.out.println(localProPath.toAbsolutePath());

        // 解析localProPath兄弟目录, 指向 .../resources/test/xml
        Path xmlPath = localProPath.resolveSibling("xml");
        System.out.println(xmlPath.toAbsolutePath());
        // 解析xmlPath目录目录, 指向 .../resources/test/xml/local.xml
        Path localXmlPath = xmlPath.resolve("local.xml");

        // 转换为绝对路径
        System.out.println(localXmlPath.toAbsolutePath());

        // 获取文件名
        System.out.println(localXmlPath.getFileName());

        System.out.println(localXmlPath.getRoot());

        System.out.println(localXmlPath.getParent());


    }

    @Test
    public void testFileRead() throws URISyntaxException, IOException {
        Path localProPath = Paths.get(this.getClass().getClassLoader().getResource("local.properties").toURI());
        // 读取文件中所以的字节
        byte[] localProBytes = Files.readAllBytes(localProPath);
        System.out.println(new String(localProBytes));
    }


    @Test
    public void testFileCopy() throws URISyntaxException, IOException {
        Path localProPath = Paths.get(this.getClass().getClassLoader().getResource("local.properties").toURI());
        // 复制文件, StandardCopyOption.REPLACE_EXISTING表示替换已存在的文件
        Path targetPath = Files.copy(localProPath, localProPath.getParent().resolve("dev.properties"), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(targetPath.toAbsolutePath());

    }

    @Test
    public void testAppend() throws URISyntaxException, IOException {
        Path localProPath = Paths.get(this.getClass().getClassLoader().getResource("local.properties").toURI());

        // 追加文件,StandardOpenOption.APPEND表示追加
        Files.write(localProPath, "group=local".getBytes(), StandardOpenOption.APPEND);

//        Files.move()
//        Files.delete();
//        Files.createDirectories()
//        Files.createFile()
//        Files.getAttribute()



    }



}
