package com.example.dm2.atry;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dm2.atry.horarios.HorariosListAdapter;
import com.marck.renfeApi.contentSelector.Selector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class HorarioActivity extends AppCompatActivity {
    public static final int LLODIO_ST = 0x00f2;
    public static final String DIRECCION = "DIRECCION";
    public static final int ST_LLODIO = 0x00f1;
    private String[][] data;
    private Selector s;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_horario );

        Bundle b = getIntent().getExtras();
        int chose = b.getInt( DIRECCION );
        String file = Katuxa.ST_LLODIO_H_FILE;
        if( chose == LLODIO_ST )
            file = Katuxa.LLODIO_ST_H_FILE;
        try {
            s = Selector.build().setDocument( new BufferedReader( new FileReader( getFileStreamPath( file ) ) ) );

            String info = String.format( getString( R.string.h_last_update ), s.getDate() );
            data = null;
            ( ( TextView ) findViewById( R.id.h_info ) ).setText( s.getOrigen() + " - " + s.getDestino() );
            ( ( TextView ) findViewById( R.id.h_date ) ).setText( info );
            Toast.makeText( getApplicationContext(), "Leyendo los horarios", Toast.LENGTH_LONG ).show();
            new Handler().postDelayed(  new Runnable() {
                @Override
                public void run() {
                    try {
                        data = s.getTabla();
                        HorariosListAdapter ad = new HorariosListAdapter( HorarioActivity.this, R.id.h_lista, data );
                        ( ( ListView )findViewById( R.id.h_lista ) ).setAdapter( ad );
                    } catch ( Selector.EmptyDocumentException e ) {
                        Log.e( "Horarios", "Error de lectura", e );
                    }
                }
            } , 300 );



        } catch ( FileNotFoundException e ) {
           Toast.makeText( getApplicationContext(), "No se han encontrado los horario", Toast.LENGTH_SHORT ).show();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
