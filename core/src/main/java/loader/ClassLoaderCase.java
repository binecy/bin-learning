package loader;

public class ClassLoaderCase {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = ClassLoaderCase.class.getClassLoader().loadClass("loader");
    }
}
