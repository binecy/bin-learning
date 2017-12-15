package lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockPoint {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    void move(double delX, double delY) {
        long stamp = sl.writeLock();

        try {
            x += delX;
            y += delY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }


    double distanceFormOrigin() {
        long stamp = sl.tryOptimisticRead();
        // 读取x,y
        double currentX = x, currentY = y;
        if(!sl.validate(stamp)) {
            stamp = sl.readLock();

            try {
                // 重新读取x,y
                currentX = x;
                currentY = y;
            } finally {
                sl.unlockRead(stamp);
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
