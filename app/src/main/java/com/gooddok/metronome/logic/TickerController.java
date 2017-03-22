package com.gooddok.metronome.logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.NANOSECONDS;


public class TickerController {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public TickerController(int ticksPerMinute) {
        this.ticksPerMinute = ticksPerMinute;
    }

    public void setTicksPerMinute(int ticksPerMinute) {
        boolean isStopped = (tickerHandle == null);
        stopTicker();
        this.ticksPerMinute = ticksPerMinute;
        if (!isStopped) {
            startTicker();
        }
    }

    private int ticksPerMinute;
    private ScheduledFuture<?> tickerHandle;

    public void restartTicker() {
        stopTicker();
        startTicker();
    }

    public void startTicker() {
        System.out.println("delay = " + (60 * 1000000000L / ticksPerMinute));
        long tickEveryInNanoSec = 60 * 1000000000L / ticksPerMinute;
        tickerHandle = scheduler.scheduleAtFixedRate(new Ticker(), tickEveryInNanoSec, tickEveryInNanoSec, NANOSECONDS);
    }

    public void stopTicker(){
        if (tickerHandle != null) {
            tickerHandle.cancel(true);
            tickerHandle = null;
        }
    }
}
