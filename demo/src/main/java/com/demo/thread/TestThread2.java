package com.demo.thread;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.net.URL;

public class TestThread2 extends Thread {
    private String url;
    private String name;

    public TestThread2(@NotNull String name, String url) {
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

        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownLoader {

    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}