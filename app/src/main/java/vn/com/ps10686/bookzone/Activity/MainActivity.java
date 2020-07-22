package vn.com.ps10686.bookzone.Activity;


import android.content.Context;
import android.content.DialogInterface;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
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

import vn.com.ps10686.bookzone.Fragments.NguoiDungFragment;
import vn.com.ps10686.bookzone.GioiThieuFragment;
import vn.com.ps10686.bookzone.HoaDonFragment;
import vn.com.ps10686.bookzone.Model.NguoiDung;
import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.SachFragment;
import vn.com.ps10686.bookzone.TheLoaiFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private DrawerLayout drawer;
    public static ArrayList<Sach> arrayList = new ArrayList<>();
    public static ArrayList<Sach> arrayList1 = new ArrayList<>();
//    public static NguoiDung nguoiDungSauDangNhap;
    static String username;
    static float sodu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NguoiDungFragment()).commit();
                toolbar.setTitle("Thông tin cá nhân");
                break;
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
                        android.os.Process.killProcess(android.os.Process.myPid());
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
    String saved_user, saved_sodu;
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
        arrayList.add(new Sach("Tuổi trẻ đáng giá bao nhiêu",R.drawable.bia1));
        arrayList.add(new Sach("Ngày mai sẽ khác" ,R.drawable.bia2));
        arrayList.add(new Sach("something",R.drawable.bia3));
        arrayList.add(new Sach("something",R.drawable.bia3));
        arrayList.add(new Sach("something",R.drawable.bia3));
        arrayList.add(new Sach("something",R.drawable.bia3));

        arrayList1.add(new Sach("Tuổi trẻ đáng giá bao nhiêu"));
        arrayList1.add(new Sach("Ngày mai sẽ khác"));
        arrayList1.add(new Sach("something"));
        arrayList1.add(new Sach("something mmmm"));
        arrayList1.add(new Sach("something ...."));
        arrayList1.add(new Sach("something ??"));
    }
    //Dựa vào tài khoản đăng nhập kiểm tra số dư
    void checkSoDu(){

    }
}

