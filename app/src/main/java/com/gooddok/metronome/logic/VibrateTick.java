package com.gooddok.metronome.logic;

import android.content.Context;
import android.os.Vibrator;
import com.gooddok.metronome.MyApplication;

/**
 * Created by Константин on 22.03.2017.
 */

public class VibrateTick implements Tick {
    private Vibrator vibrator = (Vibrator) MyApplication.getAppContext().getSystemService(Context.VIBRATOR_SERVICE);

    @Override
    public void make() {
        // Vibrate for 500 milliseconds
        vibrator.vibrate(500);
    }
}
