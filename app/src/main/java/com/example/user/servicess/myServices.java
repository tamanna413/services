package com.example.user.servicess;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class myServices extends Service {
    MediaPlayer myPlayer;
    @Nullable


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate ();

        Toast.makeText ( this,"Services Created",Toast.LENGTH_SHORT ).show ();

        myPlayer= MediaPlayer.create ( this,R.raw.abcd);
        myPlayer.setLooping ( true );
    }

    @Override
    public int onStartCommand(Intent intent,int cur_position ,int startId) {
        super.onStart ( intent, startId );

        if (intent.getStringExtra ( "order" ).equals ( "play" )){
          myPlayer.start ();
          myPlayer.setLooping ( true );
    }
    else
        if (intent.getStringExtra ( "order" ).equals ( "pause" )){
            cur_position = myPlayer.getCurrentPosition ();
            myPlayer.pause ( );

        }

        else
            if (intent.getStringExtra ( "order" ).equalsIgnoreCase ( "resume" )){
            myPlayer.seekTo ( cur_position );
            myPlayer.start ();
            }

            Toast.makeText ( this, "Services Started", Toast.LENGTH_SHORT ).show ();

        return START_STICKY;

    }



    @Override
    public void onDestroy() {
        super.onDestroy ();

        Toast.makeText ( this,"Services Stopped",Toast.LENGTH_SHORT ).show ();
        myPlayer.stop ();
    }

}
