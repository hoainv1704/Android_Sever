package vn.com.ps10686.bookzone.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import vn.com.ps10686.bookzone.BuildConfig;
import vn.com.ps10686.bookzone.Model.NguoiDung;
import vn.com.ps10686.bookzone.R;


public class IntroActivity extends AppCompatActivity {
    private static int SPLAT_TIME_OUT=2000;
    NguoiDung nguoiDungHienTai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
//        dieuHuong();
//        nguoiDungHienTai = new NguoiDung();
//        checkFirstRun();
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
}

