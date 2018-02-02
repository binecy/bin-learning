package loader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DictClassLoader extends  ClassLoader{

    private URI uri;



    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            Path path = Paths.get(uri);
            byte[] bytes = Files.readAllBytes(path);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("load class error", e);
        }
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        DictClassLoader loader = new DictClassLoader();

        URI uri = new URI("file:/home/binecy/work/Hello.class");

        loader.setUri(uri);

        Class clazz = loader.loadClass("simple.Hello");

        for (Method method : clazz.getMethods()) {
//            System.out.println(method.getName());

            if("hello".equals(method.getName())) {
                method.invoke(clazz.newInstance());
            }
        }
        System.out.println(loader.getParent());
        System.out.println(clazz.getClassLoader());
    }
}
