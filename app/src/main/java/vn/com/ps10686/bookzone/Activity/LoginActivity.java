package vn.com.ps10686.bookzone.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Model.NguoiDung;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

public class LoginActivity extends AppCompatActivity {
    AutoCompleteTextView atvpass, atvuser;
    TextView tvSignUp;
    Button bt;
    private RetrofitClient retrofitClient = new RetrofitClient();
    public static ArrayList<NguoiDung> nguoiDungs = new ArrayList<>();
    public static ArrayList<NguoiDung> nguoiDungs1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        atvuser=findViewById(R.id.atvUser);
        atvpass=findViewById(R.id.atvPasswordLog);
        bt=findViewById(R.id.btnSignIn);
        tvSignUp=findViewById(R.id.tvSignUp);

//        dangNhap1();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangNhap();
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
//    public static boolean isNguoiDungCu=false;
    void checkNguoiDungDaLamSurvey(){
        //Nếu đã làm survey\
        NguoiDung nguoiDung = nguoiDungs.get(0);
        if(nguoiDung.isDaLamSurvey()){
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            Bundle b = new Bundle();
            b.putString("_id", nguoiDung.get_id());
            b.putString("username", nguoiDung.getTenNguoiDung());
            b.putFloat("sodu", nguoiDung.getSoDu());
            i.putExtra("info", b);

            startActivity(i);
        }
        //Nếu chưa làm survey
        else {
            Intent i=new Intent(LoginActivity.this,InterestSurveyActivity.class);
            Bundle b = new Bundle();
            b.putString("username", nguoiDung.getTenNguoiDung());
            b.putFloat("sodu", nguoiDung.getSoDu());
            b.putString("_id", nguoiDung.get_id());
            i.putExtra("info", b);
            startActivity(i);
        }
    }

    public void dangNhap(){
        API api = retrofitClient.getClien().create(API.class);
        api.dangNhap(atvuser.getText().toString(), atvpass.getText().toString()).enqueue(new Callback<NguoiDung>() {
            @Override
            public void onResponse(Call<NguoiDung> call, Response<NguoiDung> response) {
                nguoiDungs.clear();
                if (response.code() == 200){
                    nguoiDungs.add(response.body());
                    System.out.println(nguoiDungs);
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    checkNguoiDungDaLamSurvey();

                    overridePendingTransition(R.anim.next_in,R.anim.next_out);
                }
                else if (response.code() == 404){
                    Toast.makeText(LoginActivity.this, "Thông tin đăng nhập sai", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NguoiDung> call, Throwable t) {
                Log.i("Sach", t.getMessage());
            }
        });
    }
    public void dangNhap1(){
        API api = retrofitClient.getClien().create(API.class);
        api.dangNhap(atvuser.getText().toString(), atvpass.getText().toString()).enqueue(new Callback<NguoiDung>() {
            @Override
            public void onResponse(Call<NguoiDung> call, Response<NguoiDung> response) {
                if (response.code() == 200){
                    nguoiDungs1.add(response.body());
                    System.out.println(nguoiDungs);

//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else if (response.code() == 404){

                }
            }

            @Override
            public void onFailure(Call<NguoiDung> call, Throwable t) {
                Log.i("Sach", t.getMessage());
            }
        });
    }

}



