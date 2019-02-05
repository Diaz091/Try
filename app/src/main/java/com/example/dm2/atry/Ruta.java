package com.example.dm2.atry;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ruta extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_ruta );


        new Handler(  ).postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent ruta = new Intent( Ruta.this , LamuzaParkea.class );
                startActivity( ruta );
                finish();
            }
        },1000 );
    }
}
