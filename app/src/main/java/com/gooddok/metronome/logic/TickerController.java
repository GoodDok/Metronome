package com.gooddok.metronome.logic;

import com.gooddok.metronome.MainActivity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


public class TickerController {

    private ScheduledFuture<?> tickerHandle;
    private Tick tick;
    private int tickEveryInMilliSec;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

    public Tick getTick() {
        return tick;
    }

    public void setTick(Tick tick) {
        this.tick = tick;
    }

    public TickerController(int ticksPerMinute) {
        this.setTicksPerMinute(ticksPerMinute);
    }

    public void setTicksPerMinute(int ticksPerMinute) {
        if (ticksPerMinute < MainActivity.MIN_SPEED || ticksPerMinute > MainActivity.MAX_SPEED){
            throw new IllegalArgumentException();
        }
        this.tickEveryInMilliSec = 60 * 1000 / ticksPerMinute;
        if (tickerHandle != null){
            restartTicker();
        }
    }

    public void restartTicker() {
        stopTicker();
        startTicker();
    }

    public void startTicker() {
        System.out.println("startTicker");
        System.out.println(tickEveryInMilliSec);
        tickerHandle = scheduler.scheduleAtFixedRate(new Ticker(this), tickEveryInMilliSec, tickEveryInMilliSec, MILLISECONDS);
    }

    public void stopTicker(){
        System.out.println("stopTicker");
        if (tickerHandle != null) {
            tickerHandle.cancel(true);
            tickerHandle = null;
        }
    }
}
