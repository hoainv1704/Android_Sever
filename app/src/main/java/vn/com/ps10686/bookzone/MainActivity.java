package vn.com.ps10686.bookzone;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        int mau= Color.parseColor("#31b1d1");
        toolbar.setBackgroundColor(mau);


        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
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
}

