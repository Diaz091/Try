package com.example.dm2.atry;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class FinJuego extends AppCompatActivity {

    private MediaPlayer txomin19;
    private boolean repitiendo = false;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fin_juego );
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txomin19 = MediaPlayer.create( this , R.raw.txomin18 ); // Reproductor del Sonido

        if(!repitiendo) {
            txomin19.start();

            txomin19.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion( MediaPlayer mp ) {

                }
            } );
        }
    }

    public void continuar( View view ) {
        Intent lamuza = new Intent( FinJuego.this, LamuzaParkeaIngurua.class );
        startActivity( lamuza );
        finish();
    }

    public void repetir( View view ) {
        Intent juego = new Intent( FinJuego.this, Juego.class );
        startActivity( juego );
        finish();
        repitiendo = true;
    }
}
