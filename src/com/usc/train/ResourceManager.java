package com.usc.train;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuqiang on 2017/12/11.
 */
public class ResourceManager {
    private final Semaphore semaphore;
    private boolean resourceArray[];
    private final ReentrantLock lock;

    public ResourceManager() {
        this.resourceArray = new boolean[10];
        this.semaphore = new Semaphore(10, true);
        this.lock = new ReentrantLock(true);
        for (int i = 0; i < 10; i++) {
            resourceArray[i] = true;
        }
    }

    public void useResource(int userId) {
        try {
            semaphore.acquire();
            int id = getResourceId();
            System.out.println("userId:" + userId + "正在使用资源，资源id:" + id);
            Thread.sleep(100);
            resourceArray[id] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getResourceId() {
        int id = -1;
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                if (resourceArray[i]) {
                    resourceArray[i] = false;
                    id = i;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return id;
    }
}
