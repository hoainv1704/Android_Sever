package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import vn.com.ps10686.bookzone.Model.Tag;
import vn.com.ps10686.bookzone.R;

public class TagAdapter extends BaseAdapter {
    private Context context;
//    private final int idLayout = R.layout.check_box_item_layout;
    private ArrayList<Tag> listTag;
    private int positionSelect = -1;

    public TagAdapter(Context context, ArrayList<Tag> listTag) {
        this.context = context;
        this.listTag = listTag;
    }

    @Override
    public int getCount() {
        if (listTag.size() != 0 && !listTag.isEmpty()) {
            return listTag.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.check_box_item_layout, viewGroup,false);
        }
        mapOnEachItem(view);
        Tag tag = listTag.get(i);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(context.getResources().getDrawable(tag.getMauNhan()));
        }
        tvTenTag.setText(tag.getTenNhan());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, i+"", Toast.LENGTH_SHORT).show();
                chkBoxYeuThich= view.findViewById(R.id.chkBoxYeuThich);

                chkBoxYeuThich.setChecked(!chkBoxYeuThich.isChecked());
            }
        });

        return view;
    }
    TextView tvTenTag;
    CheckBox chkBoxYeuThich;
    void mapOnEachItem(View v){
        tvTenTag = v.findViewById(R.id.tvTenTag);
        chkBoxYeuThich = v.findViewById(R.id.chkBoxYeuThich);
    }
}
