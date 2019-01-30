package com.example.dm2.atry;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.marck.renfeApi.RenfeRequest;
import com.marck.renfeApi.params.RequestParams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String LLODIO_ST_H_FILE = "llodio_st.h";
    public static final String ST_LLODIO_H_FILE = "st_llodio.h";
    public static final String MAP_OFFLINE_FILE = "mbgl-offline.db";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    public void newAct( View view ) {
        Intent  newAct = new Intent( this , Katuxa.class );
        startActivity( newAct );
    }

    //    descarga de horarios
    private void descargaDeHorarios() throws RenfeRequest.WrongDateFormatException {
        Date toDay = new Date();
        SimpleDateFormat format = new SimpleDateFormat( "dd-MM-yyyy" );
//        creamos las variables
        final RequestParams st_llodio = new RequestParams()
                .put( RequestParams.HORA_DESTINO, "26" )
                .put( RequestParams.DESTINO, "13106" ) // santa cruz
                .put( RequestParams.ORIGEN, "13104" ) // llodio
                .put( RequestParams.HORA_ORIGEN, "2" )
                .put( RequestParams.FECHA, RenfeRequest.formatDate( format.format( toDay ) ) );

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                RenfeRequest r = RenfeRequest.build();
                try {
                    r.setParams( st_llodio );
                    r.buildURL();
                    r.connect( MainActivity.this.openFileOutput( ST_LLODIO_H_FILE, MODE_PRIVATE ) );
                } catch ( RequestParams.ParamNotFoundException e ) {
                    Log.e( "HORARIOS", "Parametros erroneos", e );
                } catch ( FileNotFoundException e ) {
                    Log.e( "HORARIOS", "File not found", e );
                } catch ( MalformedURLException e ) {
                    Log.e( "HORARIOS", "URL erronea", e );
                } catch ( IOException e ) {
                    Log.e( "HORARIOS", "", e );
                }
            }
        },500 );

        final RequestParams llodio_st = new RequestParams()
                .put( RequestParams.HORA_DESTINO, "26" )
                .put( RequestParams.DESTINO, "13104" ) // santa cruz
                .put( RequestParams.ORIGEN, "13106" ) // llodio
                .put( RequestParams.HORA_ORIGEN, "2" )
                .put( RequestParams.FECHA, RenfeRequest.formatDate( format.format( toDay ) ) );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                RenfeRequest r = RenfeRequest.build();
                try {
                    r.setParams( llodio_st );
                    r.buildURL();
                    r.connect( MainActivity.this.openFileOutput( LLODIO_ST_H_FILE, MODE_PRIVATE ) );
                    Toast.makeText( MainActivity.this.getApplicationContext(),
                            "Horarios Actualizados", Toast.LENGTH_SHORT ).show();
                } catch ( RequestParams.ParamNotFoundException e ) {
                    Log.e( "HORARIOS", "Parametros erroneos", e );
                } catch ( FileNotFoundException e ) {
                    Log.e( "HORARIOS", "File not found", e );
                } catch ( MalformedURLException e ) {
                    Log.e( "HORARIOS", "URL erronea", e );
                } catch ( IOException e ) {
                    Log.e( "HORARIOS", "", e );
                }
            }
        }, 1000 );
    }
}
