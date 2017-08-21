package github.com.crazyalarmclock.tap_tapcolors;

import android.content.Intent;
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

/**
 * Created by Pavel on 21.05.2017.
 */

public class Game extends WearableActivity implements View.OnClickListener {

    final Random random = new Random();
    Button btn;
    public int score = 1, r, rr;
    private Handler handler = new Handler();
    private int time = 1500;
    TextView text, sc0re;

    private String[] names = {
            "Red         ",
            "Pink        ",
            "Purple      ",
            "Blue        ",
            "Green       ",
            "Yellow      ",
            "Orange      ",
            "Brown       ",
            "Grey        ",
    };

    private int[] colors = {
            Color.parseColor("#F44336"),                //Red
            Color.parseColor("#E91E63"),                //Pink
            Color.parseColor("#9C27B0"),                //Purple
            Color.parseColor("#2196F3"),                //Blue
            Color.parseColor("#4CAF50"),                //Green
            Color.parseColor("#FFEB3B"),                //Yellow
            Color.parseColor("#FF9800"),                //Orange
            Color.parseColor("#795548"),                //Brown
            Color.parseColor("#9E9E9E"),                //Grey

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        text = (TextView) findViewById(R.id.textView);
        sc0re = (TextView) findViewById(R.id.sc0re);

        handler.postDelayed(timeUpdaterRunnable, 0);

        sc0re.setText("Score: " + 0);
        text.setText("Tap to play!");

        rr = random.nextInt(9);

    }

    private Runnable timeUpdaterRunnable = new Runnable() {
        @Override
        public void run() {
            r = random.nextInt(9);
            btn.setBackgroundColor(colors[r]);
            handler.postDelayed(this, time);
        }
    };

    @Override
    public void onClick(View view) {
        if (r == rr) {
            rr = random.nextInt(9);
            sc0re.setText("Score:" + score++);

            time -= 50;

        } else if (score > 1) {
            Intent intent = new Intent(getApplicationContext(), Result.class);
            intent.putExtra("SCORE", score - 1);
            startActivity(intent);


        }
        text.setTextColor(colors[rr]);
        text.setText(names[rr]);
    }


}