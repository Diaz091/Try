package com.example.dm2.atry;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioRouting;
import android.media.MediaPlayer;
import android.media.TimedText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class Katuxa extends AppCompatActivity {

    private MediaPlayer arantza18;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_katuxa );
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        arantza18 = MediaPlayer.create(this, R.raw.arantza1); // "Reproductor del Sonido"
        arantza18.start(); // Iniciar el Sonido al iniciar la actividad

        arantza18.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion( MediaPlayer mp ) {
                finish();
                Intent lorategia = new Intent( Katuxa.this , Lorategia.class );
                startActivity( lorategia );
                finish();
            }
        } );


    }


}
