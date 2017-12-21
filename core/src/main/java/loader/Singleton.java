package loader;

public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int counter1;
    public static int counter2 = 0;
    private Singleton() {
        counter1++;
        counter2++;
    }
    public static Singleton getSingleton() {
        return singleton;
    }

    public static void main(String args[]){
        Singleton singleton = Singleton.getSingleton();
        System.out.println("counter1 = " + singleton.counter1);
        System.out.println("counter2 = " + singleton.counter2);
    }


    /*
    结果：
    counter1 = 1
    counter2 = 0
    参考：http://www.jianshu.com/p/8c8d6cba1f8e
     */
}
