package com.example.user.clickgmae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.zxc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById()
                ImageView.setImageDrawable(getResources().getDrawable( R.drawable.ic_launcher_background));


            }
        });
    }
}
