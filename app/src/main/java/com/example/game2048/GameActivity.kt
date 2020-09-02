package com.example.game2048

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.game2048.GameActivity

class GameActivity : AppCompatActivity() {
    private var gameView: ViewGame? = null
    private var txt_Score: TextView? = null
    lateinit var maxScore: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        gameActivity = this
        gameView = findViewById(R.id.gameView)
        txt_Score = findViewById(R.id.txt_Score)
        maxScore = findViewById(R.id.maxScore)
        maxScore.setText(getSharedPreferences("pMaxScore", MODE_PRIVATE).getInt("maxScore", 0).toString() + "")
    }

    fun clearScore() {
        score = 0
        showScore()
    }

    private fun showScore() {
        txt_Score!!.text = score.toString() + ""
    }

    fun addScore(num: Int) {
        Log.e("Sum score", "$num  ")
        score += num
        showScore()
        val pref = getSharedPreferences("pMaxScore", MODE_PRIVATE)
        if (score > pref.getInt("maxScore", 0)) {
            val editor = pref.edit()
            editor.putInt("maxScore", score)
            editor.commit()
            maxScore!!.text = pref.getInt("maxScore", 0).toString() + ""
        }
    }

    override fun onBackPressed() {
        createExitTipDialog()
    }

    private fun createExitTipDialog() {
        AlertDialog.Builder(this@GameActivity)
                .setMessage("Are you Sure quit the Game")
                .setPositiveButton("Yes") { dialogInterface, i ->
                    dialogInterface.dismiss()
                    finish()
                }
                .setNegativeButton("No") { dialogInterface, i -> dialogInterface.dismiss() }
                .show()
    }

    companion object {
        @JvmStatic
        var gameActivity: GameActivity? = null
        @JvmField
        var score = 0
    }
}