package com.gooddok.metronome.logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;


public class TickerController {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> tickerHandle;

    public void initTicker() {
        if (tickerHandle != null) {
            tickerHandle.cancel(true);
        }
        tickerHandle = scheduler.scheduleAtFixedRate(new Ticker(), 2, 2, SECONDS);
    }
}
