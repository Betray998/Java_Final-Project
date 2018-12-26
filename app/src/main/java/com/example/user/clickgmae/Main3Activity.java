package com.example.user.clickgmae;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView aa;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        aa=(TextView)findViewById(R.id.textView2);
        aa.setText(String.valueOf(Main2Activity.count2));
        Main2Activity.count2=0;

        button =(Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent();
                i.setClass(Main3Activity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
