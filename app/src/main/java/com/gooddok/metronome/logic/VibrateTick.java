package com.gooddok.metronome.logic;

import android.content.Context;
import android.os.Vibrator;
import com.gooddok.metronome.MyApplication;


public class VibrateTick implements Tick {
    private Vibrator vibrator = (Vibrator) MyApplication.getAppContext().getSystemService(Context.VIBRATOR_SERVICE);

    @Override
    public void make(int lengthMillisec) {
        vibrator.vibrate(lengthMillisec);
    }
}
