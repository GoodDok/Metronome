package com.gooddok.metronome.logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.MILLISECONDS;


public class TickerController {

    private int ticksPerMinute;
    private ScheduledFuture<?> tickerHandle;
    private Tick tick;
    private int tickEveryInMilliSec;
    private int tickLength;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Tick getTick() {
        return tick;
    }

    public void setTick(Tick tick) {
        this.tick = tick;
    }

    public int getTickLength() {
        return tickLength;
    }

    public TickerController(int ticksPerMinute) {
        this.setTicksPerMinute(ticksPerMinute);
    }

    public void setTicksPerMinute(int ticksPerMinute) {
        this.ticksPerMinute = ticksPerMinute;
        this.tickEveryInMilliSec = 60 * 1000 / this.ticksPerMinute;
        this.tickLength = this.tickEveryInMilliSec / 3;
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
