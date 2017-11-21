package com.dis.lock;


public class Work implements Runnable{
    private DisLock lock;
    private String name;
    public Work(DisLock lock) {
        this.lock = lock;

        String s = String.valueOf(System.currentTimeMillis());
        this.name = s.substring(6, s.length());
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(10)) {
                try {
                    System.out.println(name + " lock success" );

                    System.out.println(name + " start work... ");
                    Thread.sleep(1000);
                    System.out.println(name + " end work...");
                } finally {
                    lock.unLock();

                    System.out.println(name + " unlock success");
                }
            } else {
                System.out.println("lock fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
