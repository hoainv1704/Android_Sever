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
    TextView tvSignIn;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        atvuser=findViewById(R.id.atvEmailLog);
        atvpass=findViewById(R.id.atvPasswordLog);
        bt=findViewById(R.id.btnSignIn);
        tvSignIn=findViewById(R.id.tvSignIn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(atvuser.getText().toString().equals("abc@gmail.com") && atvpass.getText().toString().equals("123456789"))
                {
                    Intent i=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(i);
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    overridePendingTransition(R.anim.next_in,R.anim.next_out);
                }
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i1);
            }
        });

    }
}



