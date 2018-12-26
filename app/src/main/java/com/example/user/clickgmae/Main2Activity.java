package com.example.user.clickgmae;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {
    ImageView star; //怪物圖
    TextView ss;
    TextView cod;   //顯示倒數
    TextView kk;
    ImageView pic2;

    int count = 0;//預設點擊數
    public static int count2=0; //換圖數
    int a=0;
    int ra1=(int)(Math.random()* 20 + 10);//取亂數
    int[] picture={R.drawable.a2, R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,
            R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,
            R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a23,R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a27,R.drawable.a28,
            R.drawable.a29,R.drawable.a30,R.drawable.a31,R.drawable.a32,R.drawable.a33};//怪物圖檔
    private MediaPlayer mp=new MediaPlayer();   //背景音樂





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        star=(ImageView)findViewById(R.id.imageView);
        ss=(TextView) findViewById(R.id.textView);
        kk=(TextView) findViewById(R.id.textView3);
        cod = (TextView)findViewById(R.id.down);
        pic2=(ImageView)findViewById(R.id.imageView2);
        final MediaPlayer mp =MediaPlayer.create(this, R.raw.music3);//背景音樂
        mp.setLooping(true);//持續播放
        mp.start();//開始

        star.setOnClickListener(new View.OnClickListener()      //監聽怪物圖
        {
            public void onClick(View v)
            {
                count++; //點擊一次就+1
                showToast();
                /* TODO: 被點擊後要執行的動作 */

//             pic2.setVisibility(View.VISIBLE); // 出現

                    if (count == ra1) //當亂數==點擊次數
                    {
                        star.setImageResource(picture[count2++]);//換圖
                        count = 0;
                    }

//             pic2.setVisibility(View.INVISIBLE); // 出現

            }
        });


        new CountDownTimer(60000,1000) //倒數60秒，一次下數1秒
        {
            @Override
            public void onFinish()  //跳往Main3Activity結算頁
            {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
                startActivityForResult(intent,0);
            }
            @Override
            public void onTick(long millisUntilFinished) {              //顯示所剩時間
                cod.setText("所剩時間:"+millisUntilFinished/1000);
            }

        }.start();

//        Toast toast=new Toast(Context){
//            toast.show();
//            new CountDownTimer(1000,100)
//            {
//                onFinish(); {
//                toast.cancel;
//            }
//            }
//        }
       };

    private void showToast(){       //顯示炸彈
        Toast toast = new Toast(Main2Activity.this);
        toast.setGravity(Gravity.TOP,400,400);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater=getLayoutInflater();
        View layout=inflater.inflate(R.layout.activity_main4,(ViewGroup)findViewById(R.id.booom));
        toast.setView(layout);
        toast.show();
    }

@Override
protected void onDestroy() {
    super.onDestroy();
    if (mp != null) {
        mp.stop();
        mp.release();
    }
}
}



