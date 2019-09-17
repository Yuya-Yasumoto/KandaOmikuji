package com.example.kandaomikuji;


//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.Random;


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //ランダムな背景画像を設定
        setBackGroundView();
    }

    /**
     * おみくじの結果を背景画像にセットするメソッド
     * @return なし
     */
    private void setBackGroundView() {

        //リレーティブレイアウトに設定したid属性から、リレーティブレイアウトの情報を取得する
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layoutResult);

        //おみくじ用の画像IDを格納する配列
        //{大吉、中吉、小吉、吉、末吉、凶、大凶}
        final int[] omikujiResult =
                {R.drawable.result1,R.drawable.result2, R.drawable.result3,R.drawable.result4,
                        R.drawable.result5, R.drawable.result6,R.drawable.result7};

        //ランダムな数字を出力する
        Random random = new Random();
        int randNum = random.nextInt(omikujiResult.length);

        //リレーティブレイアウトにおみくじの画像をセットする
        relativeLayout.setBackgroundResource(omikujiResult[randNum]);

    }

}

