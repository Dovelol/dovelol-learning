package com.dove.lol.dovelol.demo.date201803.demo20180303;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedTransferQueueExampleTest {


    @Test
    private void testTransfer() {
        LinkedTransferQueue linkedTransferQueue = LinkedTransferQueueExample.create();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.schedule(() -> {

            try {
                assertThat(linkedTransferQueue.take(), equalTo("Transfer"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 1, TimeUnit.SECONDS);

        executorService.shutdown();


    }

}