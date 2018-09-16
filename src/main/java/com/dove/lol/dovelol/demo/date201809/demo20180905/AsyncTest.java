package com.dove.lol.dovelol.demo.date201809.demo20180905;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.protocol.BasicAsyncResponseConsumer;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Dovelol
 * @date 2018/9/5 21:48
 */
public class AsyncTest {

    private static HttpAsyncClient httpAsyncClient;

    public static CompletableFuture<String> getHttpData(String url) {

        CompletableFuture asyncFuture = new CompletableFuture();

        HttpAsyncRequestProducer producer = HttpAsyncMethods.create(new HttpGet(url));

        BasicAsyncResponseConsumer consumer = new BasicAsyncResponseConsumer();

        FutureCallback<HttpResponse> callback = new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse httpResponse) {
                asyncFuture.complete(httpResponse);
            }

            @Override
            public void failed(Exception e) {
                asyncFuture.completeExceptionally(e);
            }

            @Override
            public void cancelled() {
                asyncFuture.cancel(true);
            }
        };

        httpAsyncClient.execute(producer, consumer, callback);
        return asyncFuture;

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = AsyncTest.getHttpData("http://www.injoy.fun/Injoy/h5/game/list");
        String result = future.get();
    }


}
