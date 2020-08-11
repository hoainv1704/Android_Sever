package vn.com.ps10686.bookzone.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vn.com.ps10686.bookzone.BuildConfig;
import vn.com.ps10686.bookzone.R;


public class OptionActivity extends AppCompatActivity {
    Button btnGuest, btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        btnGuest=findViewById(R.id.btnGuest);
        btnLog=findViewById(R.id.btnLog);


        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLog = new Intent(OptionActivity.this,LoginActivity.class);
                startActivity(intentLog);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNguoiDungDaLamSurvey();
            }
        });
    }
    SharedPreferences sharedPref;
    boolean isNguoiDungCu1=true;

    void checkNguoiDungDaLamSurvey(){
        //Nếu đã làm survey
        if(isNguoiDungCu1){
            Intent i=new Intent(OptionActivity.this,MainActivity.class);
            Bundle b = new Bundle();
            b.putString("username","Guest");
            b.putFloat("sodu", 0);

            i.putExtra("info", b);

            startActivity(i);
        }
        //Nếu chưa làm survey
        else {
            Intent i=new Intent(OptionActivity.this,InterestSurveyActivity.class);
            Bundle b = new Bundle();
            b.putString("username", "Guest");
            b.putFloat("sodu", 0);
            i.putExtra("info", b);
            startActivity(i);
        }
    }
}
