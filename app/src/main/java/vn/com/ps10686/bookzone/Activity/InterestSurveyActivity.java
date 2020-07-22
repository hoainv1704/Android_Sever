package vn.com.ps10686.bookzone.Activity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.com.ps10686.bookzone.Adapter.TagAdapter;
import vn.com.ps10686.bookzone.Model.Tag;
import vn.com.ps10686.bookzone.R;

public class InterestSurveyActivity extends AppCompatActivity {
    GridView gridViewYeuThich;
    TextView tvNext;
    ArrayList<Tag> tagList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_survey);
        map();
        fakeData();
        final Bundle b = getIntent().getBundleExtra("info");
        TagAdapter tagAdapter = new TagAdapter(this, tagList);
        gridViewYeuThich.setAdapter(tagAdapter);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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