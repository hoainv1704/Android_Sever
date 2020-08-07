package vn.com.ps10686.bookzone.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.BuildConfig;
import vn.com.ps10686.bookzone.Model.NguoiDung;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;


public class IntroActivity extends AppCompatActivity {
    NguoiDung nguoiDungHienTai;
//    public static ArrayList<Sach1> sach1s = new ArrayList<>();
//    public static ArrayList<Sach1> sach2s = new ArrayList<>();;
//    public static ArrayList<Sach1> sach3s = new ArrayList<>();;
//    RetrofitClient retrofitClient = new RetrofitClient();

    //khai bao bien chuyen man hinh
    private static int SPLAT_TIME_OUT=6000;

    //khai bao doi tuong
    private ImageView logoSplash, chmaraTech, logoWhite;
    private Animation anim1, anim2, anim3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
//        getSach();
        //Gọi hàm
        init();
        fullScreen();
        intentScreen();
        actionSplash();
        dieuHuong();
    }

    //Kiểm tra người dùng hiện tại
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    private void dieuHuong() {
        sharedPref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());



        String saved_user = sharedPref.getString(getString(R.string.saved_user_name),"");
        Toast.makeText(IntroActivity.this, saved_user, Toast.LENGTH_SHORT).show();

        if (saved_user.equals("")) {
            //Lần chạy thứ 1
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(IntroActivity.this, OptionActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLAT_TIME_OUT);

        } else {

            //Lần chạy thứ 2+
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLAT_TIME_OUT);
        }
    }

    //    private void checkFirstRun() {
//
//        Context context = getApplication();
//
//        final String PREF_VERSION_CODE_KEY = "version_code";
//        final int DOESNT_EXIST = -1;
//        // Get current version code
//        int currentVersionCode = BuildConfig.VERSION_CODE;
//
//        // Get saved version code
//        SharedPreferences prefs = context.getSharedPreferences(getString(R.string.saved_user_name), MODE_PRIVATE);
//        int savedVersionCode = prefs.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);
//
//        // Check for first run or upgrade
//        if (currentVersionCode == savedVersionCode) {
//            // This is just a normal run
//            dieuHuong();
//
//            return;
//
//        } else if (savedVersionCode == DOESNT_EXIST) {
//
//            // TODO This is a new install (or the user cleared the shared preferences)
//            dieuHuong();
//
//        } else if (currentVersionCode > savedVersionCode) {
//
//            // TODO This is an upgrade
//        }
//
//        // Update the shared preferences with the current version code
//        prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).apply();
//    }



    private void actionSplash() {
        logoSplash.startAnimation(anim1);
        anim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                logoSplash.startAnimation(anim2);
                logoSplash.setVisibility(View.GONE);

                logoWhite.startAnimation(anim3);
                chmaraTech.startAnimation(anim3);
                anim3.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        logoWhite.setVisibility(View.VISIBLE);
                        chmaraTech.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void intentScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLAT_TIME_OUT);
    }

    private void fullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    //anhXa
    private void init() {
        logoSplash = findViewById(R.id.ivLogoSplash);
        logoWhite = findViewById(R.id.ivLogoWhite);
        chmaraTech = findViewById(R.id.ivCHTtext);
        anim1 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        anim2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadeout);
        anim3 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadein);
    }

//    private void getSach(){
//        API api = retrofitClient.getClien().create(API.class);
//        api.getSach().enqueue(new Callback<List<Sach1>>() {
//            @Override
//            public void onResponse(Call<List<Sach1>> call, Response<List<Sach1>> response) {
//                List<Sach1> ds = response.body();
//                System.out.println("id sach: " + response.body());
//                for (int i = 0; i <ds.size(); i++){
//                    Sach1 sach1 = ds.get(i);
//
//                    sach1s.add(sach1);
//                    sach2s.add(sach1);
//                    sach3s.add(sach1);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Sach1>> call, Throwable t) {
//                Log.i("Sach", t.getMessage());
//            }
//        });
//    }
}

