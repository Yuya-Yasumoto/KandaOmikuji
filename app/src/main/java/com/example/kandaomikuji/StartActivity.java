package com.example.kandaomikuji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //イメージボタンに設定したid属性から、おみくじを引くのイメージボタンの情報を取得する
        ImageButton buttonStart = (ImageButton) findViewById(R.id.buttonStart);
        //おみくじを引くのイメージボタンの情報とボタンがクリックされたときの処理を関連付ける
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ShakeActivityに遷移するように設定
                Intent intent = new Intent(getApplicationContext(), ShakeActivity.class);

                //インテントの開始
                startActivity(intent);

                //StartActivityの終了
                finish();
            }
        });

    }
}
