package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;

import static vn.com.ps10686.bookzone.api.RetrofitClient.ROOT_URL;

public class SachAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Sach1> saches;

    public SachAdapter(Context context, int layout, List<Sach1> saches) {
        this.context = context;
        this.layout = layout;
        this.saches = saches;
    }

    @Override
    public int getCount() {
        return saches.size();
    }

    @Override
    public Object getItem(int i)
    {
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

        Sach1 sach = saches.get(i);
        Picasso.with(context).load( ROOT_URL + sach.getHinh().substring(7)).into(holder.imgView);

        return view;
    }

}
