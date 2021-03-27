package com.rais.app.lemparkoinrais;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LemparKoin extends Activity implements View.OnClickListener {
    private Button btnToss;
    private Button btnRepeat;
    private Button btnExit;
    private Random rand;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rand=new Random();
        setContentView(R.layout.activity_lempar_koin);
        btnToss=(Button)findViewById(R.id.btn1);
        btnRepeat=(Button)findViewById(R.id.btn2);
        btnExit=(Button)findViewById(R.id.btn3);
        btnToss.setOnClickListener(this);
        btnRepeat.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==btnToss) {
            Log.d("CLICK_EVENT", "Toss button clicked");
            TextView tw=(TextView)findViewById(R.id.textView1);
            ImageView iw=(ImageView)findViewById(R.id.imgView);

            if (rand.nextDouble() < 0.5) {
                tw.setText("Kepala");
                iw.setImageResource(R.drawable.head);
            }else {
                tw.setText("Cross");
                iw.setImageResource(R.drawable.tail);
            }
            btnToss.setVisibility(View.INVISIBLE);
            btnRepeat.setVisibility(View.VISIBLE);
            btnExit.setVisibility(View.VISIBLE);
        }
        else if (view==btnRepeat) {
            TextView tw=(TextView)findViewById(R.id.textView1);
            ImageView iw=(ImageView)findViewById(R.id.imgView);

            btnToss.setVisibility(View.VISIBLE);
            btnRepeat.setVisibility(View.INVISIBLE);
            btnExit.setVisibility(View.INVISIBLE);
            tw.setText("");
            iw.setImageResource(R.drawable.question);
        }
        else if (view==btnExit){
            this.finish();
        }
    }

}
