package com.example.rathero.flip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    private static final int ACTION_PLAY = 1;

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
        Intent i = new Intent(this,GameField.class);

        SeekBar seekX = (SeekBar) findViewById(R.id.seekBarX);
        i.putExtra("xValue",seekX.getProgress());

        SeekBar seekY = (SeekBar) findViewById(R.id.seekBarY);
        i.putExtra("yValue",seekY.getProgress());

        SeekBar seekColor = (SeekBar) findViewById(R.id.seekBarColors);
        i.putExtra("colorValue",seekColor.getProgress());

        RadioButton rd = (RadioButton) findViewById(R.id.radioButtonC);
        i.putExtra("colorBool",rd.isChecked()?"C":"N");

        CheckBox check = (CheckBox) findViewById(R.id.checkBoxS);
        i.putExtra("sonidoBool",check.isChecked());

        check = (CheckBox) findViewById(R.id.checkBoxV);
        i.putExtra("vibracionBool",check.isChecked());

        startActivityForResult(i,ACTION_PLAY);
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




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.config, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){
            case R.id.m_about:
                showAbout();
                return true;
            case R.id.m_player:
                showPlayer();
                return true;
            case R.id.m_howto:
                showHowTo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAbout() {
        Intent i = new Intent(this,About.class);
        startActivity(i);
    }
    private void showPlayer() {
        showToast("Clickado sobre Jugador",2);
    }
    private void showHowTo() {
        Intent i = new Intent(this,HowTo.class);
        startActivity(i);
    }

    protected void showToast(String txt, int duration){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context,txt,duration);
        toast.show();
    }
}
