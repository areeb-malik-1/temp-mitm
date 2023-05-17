package com;

import io.appium.mitmproxy.InterceptedMessage;
import io.appium.mitmproxy.MitmproxyJava;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeoutException;

public class Temp {
    public static void main(String[] args) throws IOException, URISyntaxException, TimeoutException, InterruptedException {
        MitmproxyJava proxy = new MitmproxyJava("/usr/local/bin/mitmdump", (InterceptedMessage m) -> {
            System.out.println("intercepted request for " + m.requestURL.toString());
            return m;
        });

        proxy.start();

        Thread.sleep(2 * 60 * 1000);

        proxy.stop();
    }
}
