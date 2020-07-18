package vn.com.ps10686.bookzone.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import vn.com.ps10686.bookzone.R;

public class IntroActivity extends AppCompatActivity {
    private static int SPLAT_TIME_OUT=7000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(IntroActivity.this,OptionActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLAT_TIME_OUT);
    }
}

