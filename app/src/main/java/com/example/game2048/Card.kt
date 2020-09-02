package com.example.game2048

import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView

class Card(context: Context?) : FrameLayout(context!!) {
    var num = 0
        set(num) {
            field = num
            if (num > 0) {
                lable.text = num.toString() + ""
            } else {
                lable.text = ""
            }
            when (num) {
                0 -> lable.setBackgroundColor(resources.getColor(R.color.colorone))
                2 -> lable.setBackgroundColor(resources.getColor(R.color.colortwo))
                4 -> lable.setBackgroundColor(resources.getColor(R.color.colorthree))
                8 -> lable.setBackgroundColor(resources.getColor(R.color.colorfour))
                16 -> lable.setBackgroundColor(resources.getColor(R.color.colorfive))
                32 -> lable.setBackgroundColor(resources.getColor(R.color.colorsix))
                64 -> lable.setBackgroundColor(resources.getColor(R.color.colorseveen))
                128 -> lable.setBackgroundColor(resources.getColor(R.color.coloreight))
                256 -> lable.setBackgroundColor(resources.getColor(R.color.colornine))
                512 -> lable.setBackgroundColor(resources.getColor(R.color.colorten))
                1024 -> lable.setBackgroundColor(resources.getColor(R.color.coloreleven))
                else -> lable.setBackgroundColor(resources.getColor(R.color.colortwelve))
            }
        }
    private val lable: TextView
    fun equals(card: Card): Boolean {
        return num == card.num
    }

    init {
        lable = TextView(getContext())
        lable.textSize = 32f
        lable.gravity = Gravity.CENTER
        val lp = LayoutParams(-1, -1)
        lp.setMargins(10, 10, 0, 0)
        addView(lable, lp)
        num = 0
    }
}