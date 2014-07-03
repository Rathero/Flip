package com.example.rathero.flip;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        updateX(0);
        updateY(0);
        updateColor(0);
        //Configuracion boton play
        Button b = (Button) findViewById(R.id.buttonPlay);
        b.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {
             startPlay();
             }
        });

        //Configuración del primer seekbar
        SeekBar seekX = (SeekBar) findViewById(R.id.seekBarX);
        seekX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                updateX(seekBar.getProgress());
            }
            public void onStartTrackingTouch(SeekBar seekBar){}
            public void onStopTrackingTouch(SeekBar seekBar){}
        });

        //Configuración del segundo seekbar
        SeekBar seekY = (SeekBar) findViewById(R.id.seekBarY);
        seekY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                updateY(seekBar.getProgress());
            }
            public void onStartTrackingTouch(SeekBar seekBar){}
            public void onStopTrackingTouch(SeekBar seekBar){}
        });

        //Configuración del tercer seekbar
        SeekBar seekColor = (SeekBar) findViewById(R.id.seekBarColors);
        seekColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                updateColor(seekBar.getProgress());
            }
            public void onStartTrackingTouch(SeekBar seekBar){}
            public void onStopTrackingTouch(SeekBar seekBar){}
        });
    }
    protected void startPlay() {
        //Start the game
    }
    protected void updateX(int progress) {
        //Set x parameter
        TextView t = (TextView) findViewById(R.id.textViewX);
        t.setText(getString(R.string.value) + ":" + (progress + 3));
    }

    protected void updateY(int progress) {
        //Set Y parameter
        TextView t = (TextView) findViewById(R.id.textViewY);
        t.setText(getString(R.string.value) + ":" + (progress + 3));
    }

    protected void updateColor(int progress) {
        //Set Color parameter
        TextView t = (TextView) findViewById(R.id.textViewColors);
        t.setText(getString(R.string.value) + ":" + (progress + 2));
    }



/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
