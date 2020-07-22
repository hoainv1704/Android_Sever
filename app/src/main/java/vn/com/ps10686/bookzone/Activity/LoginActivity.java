package vn.com.ps10686.bookzone.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import vn.com.ps10686.bookzone.R;

public class LoginActivity extends AppCompatActivity {
    AutoCompleteTextView atvpass, atvuser;
    TextView tvSignUp;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        atvuser=findViewById(R.id.atvUser);
        atvpass=findViewById(R.id.atvPasswordLog);
        bt=findViewById(R.id.btnSignIn);
        tvSignUp=findViewById(R.id.tvSignUp);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(atvuser.getText().toString().equals("abc") && atvpass.getText().toString().equals("123456789"))
                {
                     checkNguoiDungDaLamSurvey();
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    overridePendingTransition(R.anim.next_in,R.anim.next_out);
                }
            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });

    }
    boolean isNguoiDungCu=true;
    void checkNguoiDungDaLamSurvey(){
        //Nếu đã làm survey
        if(isNguoiDungCu){
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            Bundle b = new Bundle();
            b.putString("username", atvuser.getText().toString());
            b.putFloat("sodu", 0);
            i.putExtra("info", b);

            startActivity(i);
        }
        //Nếu chưa làm survey
        else {
            Intent i=new Intent(LoginActivity.this,InterestSurveyActivity.class);
            Bundle b = new Bundle();
            b.putString("username", atvuser.getText().toString());
            b.putFloat("sodu", 0);
            i.putExtra("info", b);
            startActivity(i);
        }
    }
}



