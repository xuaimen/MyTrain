package com.usc.train;

/**
 * Created by xuqiang on 2017/12/11.
 */
public class ResourceUser implements Runnable {
    private ResourceManager resourceManager;
    private int userId;

    public ResourceUser(ResourceManager resourceManager, int userId) {
        this.resourceManager = resourceManager;
        this.userId = userId;
    }

    @Override
    public void run() {
        System.out.print("userId:" + userId + "准备使用资源...\n");
        resourceManager.useResource(userId);
        System.out.print("userId:" + userId + "使用资源完毕...\n");
    }

    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ResourceUser(resourceManager, i));
            threads[i] = thread;
        }

        for (int i = 0; i < 100; i++) {
            Thread thread = threads[i];
            thread.start();
        }
    }
}
