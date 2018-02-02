package loader;

// https://mp.weixin.qq.com/s?__biz=MzU0MzQ5MDA0Mw==&mid=2247483837&idx=1&sn=b29d3ecb38c4644b3f6a84f35829247d&chksm=fb0beb29cc7c623f9d4d458771678bb2940e05b6d1318bad1ad894b78841c1a9ca26b4c5a939&mpshare=1&scene=1&srcid=0131mUPeZG4d6ASMDhngIUnX&pass_ticket=ElwaVfiQFJEx908zIRqoHVBMyJShC4asO85%2B4SqDAnz1AC%2FFAA%2BFLyXuhFDoLce7#rd
public class StaticTest {
    public static void main(String[] args)
    {
        staticFunction();
    }

    // 注意，这里会导致2,3先输出
    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
