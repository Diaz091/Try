package com.example.dm2.atry;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class Lorategia extends AppCompatActivity{

    private ImageButton botonImagen;
    private Button botonTren;
    private ImageView imgTxomin;
    private LinearLayout mapa;
    private MediaPlayer txomin18;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lorategia );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        botonImagen  = ( ImageButton ) findViewById( R.id.lorategia2 );
        botonTren= ( Button ) findViewById( R.id.botTren );
        botonTren.setVisibility( View.INVISIBLE );

        imgTxomin = (ImageView ) findViewById( R.id.imgTxomin );
        imgTxomin.setVisibility( View.INVISIBLE );

        mapa = findViewById( R.id.lMapa );
        mapa.setVisibility( View.INVISIBLE );

        txomin18 = MediaPlayer.create( this, R.raw.txomin18 ); // Reproductor del Sonido

        botonImagen.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                mapa.setVisibility( View.VISIBLE );

                new Handler(  ).postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        imgTxomin.setVisibility( View.VISIBLE );
                        txomin18.start();

                        txomin18.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion( MediaPlayer mp ) {
                                botonTren.setVisibility( View.VISIBLE );
                            }
                        } );
                    }
                },10000 );

            }
        } );




    }

}
