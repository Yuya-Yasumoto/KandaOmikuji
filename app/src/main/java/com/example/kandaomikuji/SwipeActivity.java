package com.example.kandaomikuji;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class SwipeActivity extends AppCompatActivity  {

    private static final int SWIPE_MIN_DISTANCE_Y = 120; //縦の移動距離の最低値
    private static final int SWIPE_MAX_DISTANCE_X = 250; //横の移動距離の最高値
    private static final int SWIPE_THRESHOLD_VELOCITY_Y = 200; //縦の移動速度の最低値
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);

        mGestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

            /**
             * 画面をスワイプしたときに呼び出される処理
             * @param beforeEvent : 移動前の座標
             * @param afterEvent : 移動後の座標
             * @param velocityX : 横（X軸）の移動速度
             * @param velocityY : 横（Y軸）の移動速度
             * @return false
             */
            @Override
            public boolean onFling(MotionEvent beforeEvent, MotionEvent afterEvent, float velocityX, float velocityY) {

                // 横（X軸）の移動距離が大きすぎる場合は無視
                if (Math.abs(beforeEvent.getX() - afterEvent.getX()) > SWIPE_MAX_DISTANCE_X) {
                    return false;
                }

                //縦の移動距離が指定値より大きい、かつ縦の移動速度が指定値より大きいとき
                if (beforeEvent.getY() - afterEvent.getY() > SWIPE_MIN_DISTANCE_Y && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY_Y) {

                    //ResultActivityに遷移するように設定
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                    //インテントの開始
                    startActivity(intent);

                    //SwipeActivityの終了
                    finish();
                }
                return false;
            }
        });

    }

    /**
     * 画面をタッチした時に呼び出される処理
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

}

