package com.gooddok.metronome.logic;

import android.media.AudioManager;
import android.media.SoundPool;

import com.gooddok.metronome.MyApplication;
import com.gooddok.metronome.R;

public class SoundTick implements Tick {
    private SoundPool sp;
    private int tickSoundId;

    public SoundTick() {
//        sp = new SoundPool.Builder().build();
        sp = new SoundPool(15, AudioManager.STREAM_MUSIC, 0);
        tickSoundId = sp.load(MyApplication.getAppContext(), R.raw.metronome_tick, 0);
    }


    @Override
    public void make() {
        sp.play(tickSoundId, 1, 1, 0, 0, 1);
    }
}
