package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.R;

public class SachAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Sach> saches;

    public SachAdapter(Context context, int layout, List<Sach> saches) {
        this.context = context;
        this.layout = layout;
        this.saches = saches;
    }

    @Override
    public int getCount() {
        return saches.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imgView = (ImageView) view.findViewById(R.id.rowImg);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        Sach sach = saches.get(i);
           holder.imgView.setImageResource(sach.getBia());
        return view;
    }
}
