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
        //final ImageButton playAndPause = (ImageButton)  this.findViewById(R.id.bottom); // Botón para Pause && Play
        final TextView    time2 = (TextView ) this.findViewById( R.id.time );


       arantza18.start(); // Iniciar el Sonido al iniciar la actividad
        //playAndPause.setBackgroundResource( R.mipmap.ic_play); // Icono Botón al inicio de la actividad

        arantza18.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion( MediaPlayer mp ) {
                finish();
                Intent lorategi = new Intent( Katuxa.this , Lorategia.class );
                startActivity( lorategi );
            }
        } );


        /*
         playAndPause.setOnClickListener( new View.OnClickListener() { // Listener para cambiar el Icono
            @Override                                                 // Dependiendo de si esta en Pause || Pause
            public void onClick(View v) {
                if ( arantza18.isPlaying() ){ // Comprueba si el Reproductor esta reproduciendo algo
                    arantza18.pause();
                    time2.setText( " Time "  + arantza18.getCurrentPosition());
                    playAndPause.setBackgroundResource( R.mipmap.ic_pause);
                }else{
                    playAndPause.setBackgroundResource( R.mipmap.ic_play);
                    arantza18.start();
                }
            }
        });*/


    }


}
