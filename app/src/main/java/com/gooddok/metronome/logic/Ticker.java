package com.gooddok.metronome.logic;

/**
 * Created by Константин on 22.03.2017.
 */

public class Ticker implements Runnable {
    private static Tick tick = new VibrateTick();

    public static void setTick(Tick tick) {
        Ticker.tick = tick;
    }

    public static Tick getTick() {
        return tick;
    }

    @Override
    public void run() {
        System.out.println("Ticker started!");
        makeTick();
    }

    private void makeTick() {
        tick.make();
    }
}
