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
//  private  Handler handler = new Handler();
    ImageView star;
    TextView ss;
    TextView cod;
    TextView kk;
    ImageView pic2;
    ProgressBar mProgress;



    int count = 0;
    public static int count2=0;
    int a=0;
    int ra1=(int)(Math.random()* 20 + 10);
    int[] picture={R.drawable.a2, R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,
            R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,
            R.drawable.a20,R.drawable.a21,R.drawable.a22,R.drawable.a23,R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a27,R.drawable.a28,
            R.drawable.a29,R.drawable.a30,R.drawable.a31,R.drawable.a32,R.drawable.a33};
    private MediaPlayer mp=new MediaPlayer();

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
        mProgress=(ProgressBar)findViewById(R.id.progressBar);
        final MediaPlayer mp =MediaPlayer.create(this, R.raw.music);
        mp.setLooping(true);
        mp.start();

        star.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                count++;
                showToast();
                /* TODO: 被點擊後要執行的動作 */

//           handler.postDelayed(runnable, 1000);
//             pic2.setVisibility(View.VISIBLE); // 出現
//                count++; //點擊一次就+1

                    if (count == ra1) //當亂數==點擊次數
                    {
                        star.setImageResource(picture[count2++]);//換圖
                        count = 0;
                    }

//             pic2.setVisibility(View.INVISIBLE); // 出現
//                handler.postDelayed(runnable2, 3000);
//                  kk.setText(String.valueOf(ra1));//顯示亂數值
            }
        });


        new CountDownTimer(60000,1000)
        {
            @Override
            public void onFinish()
            {
//                cod.setText("Done!");
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, Main3Activity.class);
//                Bundle bundle = new Bundle();
//                bundle.putString("name", etName.getText().toString());
//                intent.putExtras(bundle);
                startActivityForResult(intent,0);
            }
            @Override
            public void onTick(long millisUntilFinished) {
                cod.setText("所剩時間:"+millisUntilFinished/1000);
            }

        }.start();
        new CountDownTimer(1000,100){
            @Override
            public void onFinish(){
                toast.cancel();
                showToast();
            }
        };

    }


    private void showToast(){
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



