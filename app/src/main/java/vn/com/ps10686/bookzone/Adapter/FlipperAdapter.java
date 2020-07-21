package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.R;

public class FlipperAdapter extends BaseAdapter {

    private Context context;
    private List<Sach> list;
    private LayoutInflater inflater;

    public FlipperAdapter(Context context, List<Sach> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.view_adapter_item, null);
        ImageView topSach = (ImageView) view.findViewById(R.id.topSach);
        TextView tenTopSach = (TextView) view.findViewById(R.id.tenSachTop);
        tenTopSach.setText(list.get(i).getTenSach());
        topSach.setImageResource(list.get(i).getBia());
        return view;
    }
}
