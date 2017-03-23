package com.gooddok.metronome.logic;

public class Ticker implements Runnable {

    private TickerController controller;
    public Ticker(TickerController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        System.out.println("Ticker started!");
        makeTick();
    }

    private void makeTick() {
        if (controller != null && controller.getTick() != null) {
            controller.getTick().make(controller.getTickLength());
        }
    }
}
