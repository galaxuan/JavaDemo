package com.demo.thread;

import org.jetbrains.annotations.NotNull;

public class TestThread3 implements Runnable {
    private String url;
    private String name;

    public TestThread3(@NotNull String name, String url) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("文件名" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("1", "https://pics5.baidu.com/feed/f3d3572c11dfa9ecc39670881e53a609908fc106.jpeg");
        TestThread2 t2 = new TestThread2("2", "https://pics4.baidu.com/feed/8694a4c27d1ed21b3690d40ed6ed8cce50da3f09.jpeg");
        TestThread2 t3 = new TestThread2("3", "https://pics1.baidu.com/feed/5882b2b7d0a20cf49e583b27f78a1a3caeaf9988.jpeg?token=f7d870077327ca1b062e3045fab859b3");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}