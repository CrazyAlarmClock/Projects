package github.com.crazyalarmclock.tap_tapcolors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends WearableActivity implements View.OnClickListener {


    Button btn1;
    TextView  textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        textView2 = (TextView) findViewById(R.id.textView2);

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGHT_SCORE", 0);

        textView2.setText("High Score : " + highScore);

    }

    @Override
    public void onClick(View view) {

        if (view ==btn1 ){
            startActivity(new Intent(MainActivity.this, Game.class));


        }
    }

}