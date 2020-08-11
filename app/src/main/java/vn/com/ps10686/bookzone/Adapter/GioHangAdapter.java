package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

import vn.com.ps10686.bookzone.Model.CauHoi;
import vn.com.ps10686.bookzone.R;

public class GioHangAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<CauHoi> cauhois;

    public GioHangAdapter(Context context, int layout, List<CauHoi> cauhois) {
        this.context = context;
        this.layout = layout;
        this.cauhois = cauhois;
    }

    @Override
    public int getCount() {
        return cauhois.size();
    }

    @Override
    public Object getItem(int position) {
        return cauhois.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        viewHolder.cauhoi = convertView.findViewById(R.id.tv_cart_cauhoi);
        viewHolder.gia = convertView.findViewById(R.id.tv_cart_gia);
        viewHolder.xoa = convertView.findViewById(R.id.imv_cart_xoa);

        viewHolder.cauhoi.setText(cauhois.get(position).getCauHoi());
        viewHolder.gia.setText(cauhois.get(position).getGia());
        convertView.setTag(viewHolder);

        viewHolder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhois.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    public class ViewHolder{
        TextView cauhoi;
        TextView gia;
        ImageView xoa;
    }
}
