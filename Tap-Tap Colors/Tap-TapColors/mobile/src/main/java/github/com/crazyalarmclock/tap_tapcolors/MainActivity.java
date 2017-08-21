package github.com.crazyalarmclock.tap_tapcolors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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