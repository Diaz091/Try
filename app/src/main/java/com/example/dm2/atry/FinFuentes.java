package com.example.dm2.atry;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class FinFuentes extends AppCompatActivity {

    private MediaPlayer arantza21;
    private boolean repitiendo = false;
    private ImageView jarraitu , repetir;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_fin_fuentes );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        arantza21 = MediaPlayer.create( this , R.raw.arantza21 );

        if(!repitiendo) {
            arantza21.start();
        }

        jarraitu = findViewById( R.id.jarraitu );
        jarraitu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                continuar( );
            }
        });

        repetir = findViewById( R.id.errepikatu );
        repetir.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                repetir( );
            }
        });


    }

    public void continuar(  ) {
        Intent lamuza = new Intent( FinFuentes.this, Urmaela.class );
        startActivity( lamuza );
        finish();
    }

    public void repetir( ) {
        Intent juego = new Intent( FinFuentes.this, Fuentes.class );
        startActivity( juego );
        finish();
        repitiendo = true;
    }
}
