package references;

import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import static junit.framework.TestCase.*;


public class References {

    @Test
    public void testWeakReference() {
        Object referent = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(referent);

        assertSame(referent, weakReference.get());

        referent = null;
        System.gc();

        /**
         * 一旦没有指向 referent 的强引用, weak reference 在 GC 后会被自动回收
         */
        assertNull(weakReference.get());
    }


    //   -Xms1M -Xmx1M  -XX:+PrintGC
    @Test
    public void testSoftReference() {
        byte[] bytes1 = apply();
        SoftReference<byte[]> softReference = new SoftReference<>(bytes1);

        assertNotNull(softReference.get());

        bytes1 = null;
        System.gc();


        /**
         *  soft references 只有在 jvm OutOfMemory 之前才会被回收, 所以它非常适合缓存应用
         */
        assertNotNull(softReference.get());

        // 内存不足
        byte[] bytes2 = apply();

        assertNull(softReference.get());
    }

    @Test
    public void testStrongReference() {
        byte[] bytes1 = apply();
        byte[] strongReference = bytes1;

        bytes1 = null;
        System.gc();

        // 内存不足
        byte[] bytes2 = apply();

        System.out.println(bytes1);
    }

    private byte[] apply() {
        byte[] bytes = new byte[600 * 1024];

        for(int i = 0; i < bytes.length; i++) {
            bytes[i] = 1;
        }

        return bytes;
    }
}
