package com.gooddok.metronome.logic;

class Ticker implements Runnable {

    private TickerController controller;
    Ticker(TickerController controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        System.out.println("Ticker started!");
        makeTick();
    }

    private void makeTick() {
        if (controller != null && controller.getTick() != null) {
            controller.getTick().make();
        }
    }
}
