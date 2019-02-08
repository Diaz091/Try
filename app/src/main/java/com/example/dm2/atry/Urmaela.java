package com.example.dm2.atry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Urmaela extends AppCompatActivity {


    private Button sakatu;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_urmaela );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        sakatu = findViewById( R.id.botSakatu );

        sakatu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent skate = new Intent( Urmaela.this , Skate.class );
                startActivity( skate );

            }
        } );


    }
}
