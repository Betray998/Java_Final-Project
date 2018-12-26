package com.example.user.clickgmae;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn =(Button) findViewById(R.id.start_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)//當按下Button進到Main2Activity
            {
                Intent i = new Intent();
                i.setClass(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });
    }

}
