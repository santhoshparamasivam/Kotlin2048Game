package com.example.game2048;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;


public class Card extends FrameLayout {

    private int num = 0;
    private TextView lable;

    public Card(Context context) {
        super(context);
        lable = new TextView(getContext());
        lable.setTextSize(32);
        lable.setGravity(Gravity.CENTER);
        LayoutParams lp = new LayoutParams(-1, -1);
        lp.setMargins(10, 10, 0, 0);
        addView(lable, lp);
        setNum(0);
    }

    public int getNum() {
        return num;
    }


    public void setNum(int num) {

        this.num = num;
        if (num > 0) {
            lable.setText(num + "");
        } else {
            lable.setText("");
        }

        switch (num) {
            case 0: lable.setBackgroundColor(getResources().getColor(R.color.colorone)); break;
            case 2: lable.setBackgroundColor(getResources().getColor(R.color.colortwo)); break;
            case 4: lable.setBackgroundColor(getResources().getColor(R.color.colorthree)); break;
            case 8: lable.setBackgroundColor(getResources().getColor(R.color.colorfour)); break;
            case 16: lable.setBackgroundColor(getResources().getColor(R.color.colorfive)); break;
            case 32: lable.setBackgroundColor(getResources().getColor(R.color.colorsix)); break;
            case 64: lable.setBackgroundColor(getResources().getColor(R.color.colorseveen)); break;
            case 128: lable.setBackgroundColor(getResources().getColor(R.color.coloreight)); break;
            case 256: lable.setBackgroundColor(getResources().getColor(R.color.colornine)); break;
            case 512: lable.setBackgroundColor(getResources().getColor(R.color.colorten)); break;
            case 1024: lable.setBackgroundColor(getResources().getColor(R.color.coloreleven)); break;
            default: lable.setBackgroundColor(getResources().getColor(R.color.colortwelve)); break;
        }

    }


    public boolean equals(Card card) {
        return getNum()==card.getNum();
    }

}
