package java7;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by bin on 2017/11/12.
 */
public class FileTest {

    @Test
    public void testPath() throws URISyntaxException {

        URI localProUri = this.getClass().getClassLoader().getResource("local.properties").toURI();
        System.out.println(localProUri);

        Path localProPath = Paths.get(localProUri);

        Path xmlPath = localProPath.resolveSibling("xml");
        System.out.println(xmlPath.toAbsolutePath());

        Path localXmlPath = xmlPath.resolve("local.xml");
        System.out.println(localXmlPath.toAbsolutePath());

        System.out.println(localXmlPath.getFileName());

    }

    @Test
    public void testFileRead() throws URISyntaxException, IOException {
        URI localProUri = this.getClass().getClassLoader().getResource("local.properties").toURI();
        Path localProPath = Paths.get(localProUri);
        byte[] localProBytes = Files.readAllBytes(localProPath);
        System.out.println(new String(localProBytes));
    }


    @Test
    public void testFileCopy() throws URISyntaxException, IOException {
        URI localProUri = this.getClass().getClassLoader().getResource("local.properties").toURI();
        Path localProPath = Paths.get(localProUri);

        Path targetPath = Files.copy(localProPath, localProPath.getParent().resolve("dev.propeties"));
        System.out.println(targetPath.toAbsolutePath());

    }

    @Test
    public void testAppend() throws URISyntaxException, IOException {
        URI localProUri = this.getClass().getClassLoader().getResource("local.properties").toURI();
        Path localProPath = Paths.get(localProUri);

        Files.write(localProPath, "group=local".getBytes(), StandardOpenOption.APPEND);

//        Files.move()
//        Files.delete();
//        Files.createDirectories()
//        Files.createFile()
//        Files.getAttribute()
    }

}
