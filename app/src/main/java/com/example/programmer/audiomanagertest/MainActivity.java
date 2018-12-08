package com.example.programmer.audiomanagertest;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AudioManager myAudioManager;
        myAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    mannerOn(v, myAudioManager);
                    ((TextView) findViewById(R.id.hello)).setText("no excpetion");
                }catch (Exception e){
                    ((TextView) findViewById(R.id.hello)).setText(e.getMessage());
                }


            }


        });


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mannerOff(v, myAudioManager);
                    ((TextView) findViewById(R.id.hello)).setText("no excpetion");
                }catch (Exception e){
                    ((TextView) findViewById(R.id.hello)).setText(e.getMessage());
                }


            }
        });


        findViewById(R.id.up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    VolumeUp(v, myAudioManager);
                    ((TextView) findViewById(R.id.hello)).setText(getNowVolume(myAudioManager));
                }catch (Exception e){
                    ((TextView) findViewById(R.id.hello)).setText(e.getMessage());
                }


            }
        });


        findViewById(R.id.down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    VolumeDown(v, myAudioManager);
                    ((TextView) findViewById(R.id.hello)).setText(getNowVolume(myAudioManager));
                }catch (Exception e){
                    ((TextView) findViewById(R.id.hello)).setText(e.getMessage());
                }


            }
        });
    }

    private void mannerOn(View v, AudioManager am){
        am.setRingerMode(AudioManager.RINGER_MODE_SILENT);

    }

    private  void mannerOff(View v, AudioManager am){
        am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);

    }

    private void VolumeUp(View v, AudioManager am){
        am.setStreamVolume(AudioManager.STREAM_MUSIC,getNowVolume(am) + 1,0);
    }

    private void VolumeDown(View v, AudioManager am){
        am.setStreamVolume(AudioManager.STREAM_MUSIC,getNowVolume(am) - 1,0);
    }

    private int getNowVolume(AudioManager am){
        int nowVol;
        nowVol = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        return nowVol;
    }


}
