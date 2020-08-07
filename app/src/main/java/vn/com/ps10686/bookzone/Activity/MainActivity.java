package vn.com.ps10686.bookzone.Activity;


import android.content.DialogInterface;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Fragments.NguoiDungFragment;
import vn.com.ps10686.bookzone.GioHangFragment;
import vn.com.ps10686.bookzone.GioiThieuFragment;
import vn.com.ps10686.bookzone.HoaDonFragment;
import vn.com.ps10686.bookzone.Model.BinhLuan;
import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.SachFragment;
import vn.com.ps10686.bookzone.TheLoaiFragment;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    private DrawerLayout drawer;

//    public static NguoiDung nguoiDungSauDangNhap;
    public static String username;
    public static float sodu;
    public static ArrayList<Sach1> sach1s = new ArrayList<>();
    public static ArrayList<Sach1> sach2s = new ArrayList<>();;
    public static ArrayList<Sach1> sach3s = new ArrayList<>();;
    RetrofitClient retrofitClient = new RetrofitClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSach();
        sharedPref=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPref.edit();

        fakeData();
        setNguoiDungSauDangNhap();
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int mau= Color.parseColor("#31b1d1");
        toolbar.setBackgroundColor(mau);

        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        getInfoBeforeView();
        View view = navigationView.getHeaderView(0);
        TextView tvUser = view.findViewById(R.id.tvUser);
        tvUser.setText(saved_user);
        TextView tvSoDu = view.findViewById(R.id.tvSoDu);


        tvSoDu.setText(saved_sodu);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SachFragment()).commit();
            navigationView.setCheckedItem(R.id.sach);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.sach:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SachFragment()).commit();
                toolbar.setTitle("Sách");
                break;
            case R.id.theloai:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TheLoaiFragment()).commit();
                toolbar.setTitle("Thể loại");
                break;
            case R.id.hoadon:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HoaDonFragment()).commit();
                toolbar.setTitle("Hóa đơn");
                break;
            case R.id.thongtinnguoidung:
                if(!saved_user.equals("Guest")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new NguoiDungFragment()).commit();
                    toolbar.setTitle("Thông tin cá nhân");

                    break;
                }
                else {
                    Toast.makeText(MainActivity.this, "Chức năng không khả dụng!", Toast.LENGTH_SHORT).show();
                    break;
                }

            case R.id.gioithieu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GioiThieuFragment()).commit();
                toolbar.setTitle("Giới thiệu");
                break;
            case R.id.thoat:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Đăng xuất");
                builder.setMessage("Bạn có thật sự muốn đăng xuất?");

                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        editor.putString(getString(R.string.saved_user_name), "");
                        editor.putString(getString(R.string.saved_so_du),"");
                        editor.commit();
                        Intent i = new Intent(MainActivity.this, IntroActivity.class);
                        startActivity(i);
                        finish();
                    }
                });

                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog thoatdialog=builder.create();
                thoatdialog.show();


        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.search:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                        new SachFragment()).commit();
//                toolbar.setTitle("Sách");
//                return true;

            case R.id.cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new GioHangFragment()).commit();
                toolbar.setTitle("Giỏ hàng");
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    public static String saved_user, saved_sodu;
    //Sau khi đăng nhập lưu người dùng vào lần sau
    private void setNguoiDungSauDangNhap() {
            // TODO This is a new install (or the user cleared the shared preferences)
            // Sau khi đăng nhập có tài khoản và số dư
        saved_user = sharedPref.getString(getString(R.string.saved_user_name),"");
        saved_sodu = sharedPref.getString(getString(R.string.saved_so_du),"");

        if(saved_user.equals("")){
            Bundle b = getIntent().getBundleExtra("info");
            username = b.getString("username");
            sodu = b.getFloat("sodu");

//            Context context = getApplication();
//            sharedPref = MainActivity.this.getSharedPreferences(getString(R.string.package_name),Context.MODE_PRIVATE);

            editor.putString(getString(R.string.saved_user_name), username);
            editor.putString(getString(R.string.saved_so_du),sodu+"");

            editor.commit();}

//        Toast.makeText(MainActivity.this, saved_user, Toast.LENGTH_SHORT).show();
    }

    void getInfoBeforeView(){
        saved_user = sharedPref.getString(getString(R.string.saved_user_name),"");
        saved_sodu = sharedPref.getString(getString(R.string.saved_so_du),"");
    }
    void fakeData(){


//        binhLuans.add(new BinhLuan("Duc", "Something"));
//        binhLuans.add(new BinhLuan("Huy", "Do something"));


    }
    //Dựa vào tài khoản đăng nhập kiểm tra số dư
    void checkSoDu(){

    }

    private void getSach(){
        API api = retrofitClient.getClien().create(API.class);
        api.getSach().enqueue(new Callback<List<Sach1>>() {
            @Override
            public void onResponse(Call<List<Sach1>> call, Response<List<Sach1>> response) {
                List<Sach1> ds = response.body();
                System.out.println("id sach: " + response.body());
                for (int i = 0; i <ds.size(); i++){
                    Sach1 sach1 = ds.get(i);

                    sach1s.add(sach1);
                    sach2s.add(sach1);
                    sach3s.add(sach1);
                }
            }

            @Override
            public void onFailure(Call<List<Sach1>> call, Throwable t) {
                Log.i("Sach", t.getMessage());
            }
        });
    }



}

