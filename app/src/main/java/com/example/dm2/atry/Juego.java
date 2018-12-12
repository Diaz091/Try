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

public class Juego extends AppCompatActivity {

    private ListView juego;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_juego );
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        final Image[] imgs  = new Image[]{

                // FOTOS ARBOL
                new Image( getDrawable( R.drawable.arbol_1 ), 10 ),
                new Image( getDrawable( R.mipmap.ic_arbol_2 ), 20 ),
                new Image( getDrawable( R.mipmap.ic_arbol_3 ), 30 ),
                new Image( getDrawable( R.mipmap.ic_arbol_4 ), 40 ),
                new Image( getDrawable( R.mipmap.ic_arbol_5 ), 50 ),
                new Image( getDrawable( R.mipmap.ic_arbol_6 ), 60 ),
                new Image( getDrawable( R.mipmap.ic_arbol_7 ), 70 ),
                new Image( getDrawable( R.mipmap.ic_arbol_8 ), 80 ),

                // FOTOS PLACA
                new Image( getDrawable( R.mipmap.ic_placa_1 ), 11 ),
                new Image( getDrawable( R.mipmap.ic_placa_2 ), 21 ),
                new Image( getDrawable( R.mipmap.ic_placa_3 ), 31 ),
                new Image( getDrawable( R.mipmap.ic_placa_4 ), 41 ),
                new Image( getDrawable( R.mipmap.ic_placa_5 ), 51 ),
                new Image( getDrawable( R.mipmap.ic_placa_6 ), 61 ),
                new Image( getDrawable( R.mipmap.ic_placa_7 ), 71 ),
                new Image( getDrawable( R.mipmap.ic_placa_8 ), 81 ),
        };

        AdaptadorImg ai = new AdaptadorImg( this , imgs );

        juego = findViewById( R.id.listaImgs );
        juego.setAdapter( ai );

        View header=getLayoutInflater().inflate(R.layout.lista_header,null);
        juego.addHeaderView( header );

    }
}


    class AdaptadorImg extends ArrayAdapter<Image>{

        private Image[] imgs;

        AdaptadorImg( Context contexto , Image[] imgs ){
            super(contexto, R.layout.list_item, imgs);
            this.imgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from( getContext() );
            View vista = inflater.inflate( R.layout.list_item , null);

            ImageButton arbolBut = vista.findViewById( R.id.arbolImg );
            arbolBut.setImageDrawable( imgs[position].getImg() );

            ImageButton placaBut = vista.findViewById( R.id.placaImg );
            placaBut.setImageDrawable( imgs[position].getImg() );

            return  vista;
        }

    }

