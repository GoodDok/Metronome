package com.gooddok.metronome.logic;

import android.media.AudioManager;
import android.media.ToneGenerator;

public class SoundTick implements Tick {
    private ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 80);

    @Override
    public void make(int lengthMillisec) {
//   TODO: change tone to something non-repeatable
        toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, lengthMillisec);
    }
}
