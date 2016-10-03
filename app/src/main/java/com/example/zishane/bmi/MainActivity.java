package com.example.zishane.bmi;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{

    private EditText edWeight;
    private EditText edHeight;
    private Button bHelp;
    private TextView tvWeight;
    TextView tvHeight;
    Button bChangeColor;
    LinearLayout viewMain;
    RadioGroup rgSex;
    TextView tvSex;

    int size = 30;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();

        bChangeColor.setOnClickListener(this);
        tvWeight.setOnTouchListener(this);
        viewMain.setOnTouchListener(this);


        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("體重(kg)/身高的平方(m)")
                        .setTitle("BMI說明")
                        .setPositiveButton("ok", null)
                        .show();
            }
        });
    }

    private void findView() {
        edWeight = (EditText) findViewById(R.id.ed_Weight);
        edHeight = (EditText) findViewById(R.id.ed_Height);
        bHelp = (Button) findViewById(R.id.b_help);
        tvWeight = (TextView) findViewById(R.id.tv_Weight);
        tvHeight = (TextView) findViewById(R.id.tv_Height);
        bChangeColor = (Button) findViewById(R.id.b_ChangeColor);
        viewMain = (LinearLayout) findViewById(R.id.background);
        rgSex = (RadioGroup) findViewById(R.id.rg_Sex);
        tvSex = (TextView) findViewById(R.id.tv_Sex);
    }

    public void bmi (View v) {
        try {
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();

        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);


        Log.d("BMI", String.valueOf(bmi));
        Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();

        new AlertDialog.Builder(this)
                .setMessage(String.valueOf(bmi))
                .setTitle("bmi")
                .setPositiveButton("ok", null)
                .setNeutralButton("cancel", null)
                .setNegativeButton("NO", null)
                .show();}
        catch (Exception e) {}
    }

    public void bigger (View v) {
        tvWeight.setTextSize(++size);
        tvHeight.setTextSize(++size);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b_ChangeColor){
            Random r = new Random();
            int red = r.nextInt(256);
            int green = r.nextInt(256);
            int blue = r.nextInt(256);
            tvWeight.setTextColor(Color.rgb(red, green, blue));
            tvHeight.setTextColor(Color.rgb(red, green, blue));
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //long[] pattern = {0, 3000, 2000, 3000};

        if (v.getId() == R.id.tv_Weight){
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                vb.vibrate(new long[] {0, 3000, 2000, 3000}, 2);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                vb.cancel();
            }
            else if (event.getAction() == MotionEvent.ACTION_MOVE){
                vb.vibrate(new long[] {0, 3000, 2000, 3000}, 2);
            }
        }

        if (v.getId() == R.id.background){
            if (event.getAction() == MotionEvent.ACTION_DOWN){
                vb.vibrate(new long[] {0, 3000, 2000, 3000}, 2);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP) {
                vb.cancel();
            }
            else if (event.getAction() == MotionEvent.ACTION_MOVE){
                vb.vibrate(new long[] {0, 3000, 2000, 3000}, 2);
            }
        }

        return true;
    }
}
