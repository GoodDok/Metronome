package com.gooddok.metronome;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.gooddok.metronome.logic.SoundTick;
import com.gooddok.metronome.logic.Ticker;
import com.gooddok.metronome.logic.TickerController;
import com.gooddok.metronome.logic.VibrateTick;

public class MainActivity extends Activity {

    public static final int minSpeed = 40;
    public static final int maxSpeed = 208;

    private TickerController tickerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initialize ticker controller and seek bar
        SeekBar seekBar = (SeekBar) findViewById(R.id.mySeekBar);
        seekBar.setMax(maxSpeed - minSpeed);
        tickerController = new TickerController(minSpeed + seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tickerController.setTicksPerMinute(minSpeed + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        tickerController.setTick(toggle.isChecked()? new SoundTick() : new VibrateTick());
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    tickerController.restartTicker();
                } else {
                    // The toggle is disabled
                    tickerController.stopTicker();
                }
            }
        });

        ToggleButton toggleSound = (ToggleButton) findViewById(R.id.toggleButtonSound);
        toggleSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            private VibrateTick vibrateTick = new VibrateTick();
            private SoundTick soundTick = new SoundTick();

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The sound is enabled
                    tickerController.setTick(soundTick);
                } else {
                    // The sound is disabled
                    tickerController.setTick(vibrateTick);
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        tickerController.stopTicker();
        super.onDestroy();
    }
}
