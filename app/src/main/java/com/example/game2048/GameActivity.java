package com.example.game2048;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class GameActivity extends AppCompatActivity {
    private ViewGame gameView;
    private TextView txt_Score;
    static GameActivity gameActivity;
    public static int score = 0;
    TextView maxScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameActivity=this;
        gameView=findViewById(R.id.gameView);
        txt_Score=findViewById(R.id.txt_Score);
        maxScore=findViewById(R.id.maxScore);
        maxScore.setText(getSharedPreferences("pMaxScore", MODE_PRIVATE).getInt("maxScore", 0) + "");


    }
    public void clearScore() {
        score = 0;
        showScore();
    }

    private  void showScore() {

        txt_Score.setText(score + "");
    }
    public static GameActivity getGameActivity() {

        return gameActivity;
    }

    public void addScore(int num) {
        Log.e("Sum score",num+"  ");
        score += num;
        showScore();
        SharedPreferences pref = getSharedPreferences("pMaxScore", MODE_PRIVATE);

        if (score > pref.getInt("maxScore", 0)) {
            SharedPreferences.Editor editor = pref.edit();
            editor.putInt("maxScore", score);
            editor.commit();
            maxScore.setText(pref.getInt("maxScore", 0) + "");
        }

    }
    @Override
    public void onBackPressed() {
        createExitTipDialog();
    }

    private void createExitTipDialog() {
        new AlertDialog.Builder(GameActivity.this)
                .setMessage("Are you Sure quit the Game")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

}
