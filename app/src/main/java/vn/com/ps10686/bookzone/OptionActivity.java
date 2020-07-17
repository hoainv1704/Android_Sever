package vn.com.ps10686.bookzone;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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
                Intent intentGuest = new Intent(OptionActivity.this,MainActivity.class);
                startActivity(intentGuest);

            }
        });


    }
}
