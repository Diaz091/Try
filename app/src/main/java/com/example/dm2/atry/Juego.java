package com.example.dm2.atry;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Juego extends AppCompatActivity {

    private ListView juego;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_juego );
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final Image[] arbol  = new Image[]{

                // FOTOS ARBOL
                new Image( getDrawable( R.drawable.arbol_1 ), 10 ),
                new Image( getDrawable( R.drawable.arbol_2 ), 20 ),
                new Image( getDrawable( R.drawable.arbol_3 ), 30 ),
                new Image( getDrawable( R.drawable.arbol_4 ), 40 ),
                new Image( getDrawable( R.drawable.arbol_5 ), 50 ),
                new Image( getDrawable( R.drawable.arbol_6 ), 60 ),
                new Image( getDrawable( R.drawable.arbol_7 ), 70 ),
                new Image( getDrawable( R.drawable.arbol_8 ), 80 ),
        };
        final Image[] placa  = new Image[]{

                // FOTOS PLACA
                new Image( getDrawable( R.drawable.placa_1 ), 11 ),
                new Image( getDrawable( R.drawable.placa_2 ), 21 ),
                new Image( getDrawable( R.drawable.placa_3 ), 31 ),
                new Image( getDrawable( R.drawable.placa_4 ), 41 ),
                new Image( getDrawable( R.drawable.placa_5 ), 51 ),
                new Image( getDrawable( R.drawable.placa_6 ), 61 ),
                new Image( getDrawable( R.drawable.placa_7 ), 71 ),
                new Image( getDrawable( R.drawable.placa_8 ), 81 ),
        };

        AdaptadorImg ai = new AdaptadorImg( this , arbol , placa );

        juego = findViewById( R.id.listaImgs );
        juego.setAdapter( ai );


        View header=getLayoutInflater().inflate(R.layout.lista_header,null);
        juego.addHeaderView( header );

    }
}

    class AdaptadorImg extends ArrayAdapter<Image>{

        private Image[] arbol;
        private Image[] placa;
        private int[] indiceArb;
        private int[] indicePlc;

        AdaptadorImg( Context contexto , Image[] arbol , Image[] placa){
            super(contexto, R.layout.list_item, arbol );
            this.arbol = arbol;
            this.placa = placa;
            indiceArb = new int[arbol.length];
            indicePlc = new int[placa.length];

            for ( int i = 0; i < arbol.length; i++ ) {
                indiceArb[i]=indiceArb.length+1;

                int idA = (int) Math.floor( (Math.random() * indiceArb.length) );

                boolean containsArb = true;

                while ( containsArb ){
                    for( int j=0; j<=i; j++ ){
                        // Comprobamos si esta en el array
                        if( indiceArb[j]==idA ){
                            containsArb = true;
                            idA = (int) Math.floor( (Math.random() * indiceArb.length) );
                            break;

                        }else{
                            containsArb=false;
                        }
                    }
                }
                indiceArb[ i ] = idA;
            }

            for ( int i = 0; i < placa.length; i++ ) {
                indicePlc[i]=indicePlc.length+1;

                int idP = (int) Math.floor( (Math.random() * indicePlc.length) );
                boolean containsPlc = true;

                while ( containsPlc ){
                    for( int j=0; j<=i; j++ ){
                        // Comprobamos si esta en el array
                        if( indicePlc[j]==idP ){
                            containsPlc = true;
                            idP = (int) Math.floor( (Math.random() * indicePlc.length) );
                            break;

                        }else{
                            containsPlc=false;
                        }
                    }
                }
                indicePlc[ i ] = idP;
            }
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from( getContext() );
            View vista = inflater.inflate( R.layout.list_item , null);

            ImageButton arbolBut = vista.findViewById( R.id.arbolImg );
            arbolBut.setImageDrawable( arbol[ indiceArb[position] ].getImg() );


            ImageButton placaBut = vista.findViewById( R.id.placaImg );
            placaBut.setImageDrawable( placa[ indicePlc[position] ].getImg() );

            return  vista;
        }

    }

