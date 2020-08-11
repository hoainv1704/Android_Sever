package vn.com.ps10686.bookzone.Activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Adapter.TagAdapter;
import vn.com.ps10686.bookzone.Model.Tag;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

import static vn.com.ps10686.bookzone.Adapter.TagAdapter.sothichs;

public class InterestSurveyActivity extends AppCompatActivity {
    GridView gridViewYeuThich;
    TextView tvNext;
    ArrayList<Tag> tagList;
    private RetrofitClient retrofitClient = new RetrofitClient();
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_survey);
        map();
        fakeData();
        b = getIntent().getBundleExtra("info");
        TagAdapter tagAdapter = new TagAdapter(this, tagList);
        gridViewYeuThich.setAdapter(tagAdapter);
        chuyenTiep();
//        lamSurvey(b.getString("username"));

    }
    //Người dùng làm survey và update vào CSDL
    String tag1, tag2;

    void lamSurvey(String tenNguoiDung){
        API api = retrofitClient.getClien().create(API.class);
        if(sothichs.size()>0){
            tag1 = sothichs.get(0);
            if(sothichs.get(1)!=null){
                tag2 = sothichs.get(1);
            }
            else {
                tag2 = "Trống";
            }
            api.capNhatSoThich(tenNguoiDung, tag1, tag2).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.code()==201){

                    }
                    else if(response.code()==404){
                        Toast.makeText(InterestSurveyActivity.this, "Fail rồi", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
        else {
            tag1 = "Trống";
            tag2 = "Trống";
            api.capNhatSoThich(tenNguoiDung, tag1, tag2).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if(response.code()==201){

                    }
                    else if(response.code()==404){
                        Toast.makeText(InterestSurveyActivity.this, "Fail rồi", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
    }

    //Chuyển tiếp
    void chuyenTiep(){
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lamSurvey(b.getString("username"));
                Intent i = new Intent(InterestSurveyActivity.this, MainActivity.class);
                i.putExtra("info", b);
                startActivity(i);
            }
        });
    }
    void map(){
        tvNext = findViewById(R.id.tvNext);
        gridViewYeuThich = findViewById(R.id.gridViewYeuThich);
    }
    void fakeData(){
        tagList = new ArrayList<>();
        Tag tag1 = new Tag(R.drawable.tag1, "tag01", "Khoa học");
        Tag tag2 = new Tag(R.drawable.tag2, "tag02", "Lịch sử");
        Tag tag3 = new Tag(R.drawable.tag3, "tag03", "Xã hội");
        Tag tag4 = new Tag(R.drawable.tag4, "tag04", "Kinh tế");
        tagList.add(tag1);
        tagList.add(tag2);
        tagList.add(tag3);
        tagList.add(tag4);

    }
}