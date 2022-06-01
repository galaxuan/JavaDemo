package com.demo.thread;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class TestThread4 implements Callable<Boolean> {
    private String url;
    private String name;

    public TestThread4(@NotNull String name, String url) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("文件名" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread2 t1 = new TestThread2("1", "https://pics5.baidu.com/feed/f3d3572c11dfa9ecc39670881e53a609908fc106.jpeg");
        TestThread2 t2 = new TestThread2("2", "https://pics4.baidu.com/feed/8694a4c27d1ed21b3690d40ed6ed8cce50da3f09.jpeg");
        TestThread2 t3 = new TestThread2("3", "https://pics1.baidu.com/feed/5882b2b7d0a20cf49e583b27f78a1a3caeaf9988.jpeg");

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<Boolean> f1 = (Future<Boolean>) executorService.submit(t1);
        Future<Boolean> f2 = (Future<Boolean>) executorService.submit(t2);
        Future<Boolean> f3 = (Future<Boolean>) executorService.submit(t3);

        boolean re1 = f1.get();
        boolean re2 = f2.get();
        boolean re3 = f3.get();

        //executorService.shutdown();
    }
}