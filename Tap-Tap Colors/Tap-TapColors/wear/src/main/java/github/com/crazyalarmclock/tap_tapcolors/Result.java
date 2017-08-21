package github.com.crazyalarmclock.tap_tapcolors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Pavel on 21.05.2017.
 */

public class Result extends WearableActivity implements View.OnClickListener  {
    Button btn2;
    TextView scoreLabel,hightScoreLabel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        btn2 = (Button) findViewById(R.id.btn2);


        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        hightScoreLabel = (TextView) findViewById(R.id.hightScoreLabel);

        int score = getIntent().getIntExtra("SCORE", 0);
        scoreLabel.setText(score + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGHT_SCORE", 0);

        if (score > highScore) {
            hightScoreLabel.setText("High Score : " + score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGHT_SCORE", score );
            editor.commit();
        } else {
            hightScoreLabel.setText("High Score : " + highScore);
        }
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==btn2){
            startActivity(new Intent(Result.this, Game.class));
            finish();
        }
    }
}
