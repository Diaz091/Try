package com.example.dm2.atry;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MapFragment extends Fragment {
    private ImageView imgTxomin;
    private MediaPlayer txomin18;
    private Button botonTren;
    private Lorategia lr;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.activity_map_fragment, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        imgTxomin = ( ImageView ) view.findViewById( R.id.imgTxomin );
        imgTxomin.setVisibility( View.INVISIBLE );


        txomin18 = MediaPlayer.create( this.getContext() , R.raw.txomin18 ); // Reproductor del Sonido
        botonTren= ( Button ) view.findViewById( R.id.botTren );

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
        },5000 );

        botonTren.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {

                Intent horario = new Intent( getContext() , LamuzaParkea.class );
                startActivity( horario );

            }
        } );


    }
}
