package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;

import static vn.com.ps10686.bookzone.api.RetrofitClient.ROOT_URL;

public class FlipperAdapter extends BaseAdapter {

    private Context context;
    private List<Sach1> list;
    private LayoutInflater inflater;

    public FlipperAdapter(Context context, ArrayList<Sach1> list) {
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
        TextView tenSach = (TextView) view.findViewById(R.id.tenSach);
        TextView tenLoai = (TextView) view.findViewById(R.id.tenLoai);
        TextView tacGia = (TextView) view.findViewById(R.id.tacGia);
        TextView nhaXuatBan = (TextView) view.findViewById(R.id.nhaXuatBan);
        TextView namXuatBan = (TextView) view.findViewById(R.id.namXuatBan);
        TextView taiBan = (TextView) view.findViewById(R.id.taiBan);

        tenSach.setText("Tên Sách: " + list.get(i).getTenSach());
        tenLoai.setText("Tên Loại: " + list.get(i).getTenLoai());
        tacGia.setText("Tác Giả: " + list.get(i).getTacGia());
        nhaXuatBan.setText("Nhà Xuất Bản: " + list.get(i).getNhaXuatBan());
        namXuatBan.setText("Năm Xuất Bản: " + list.get(i).getNamXuatBan());
        taiBan.setText("Tái Bản: " + list.get(i).getTaiBan());


        ImageView topSach = (ImageView) view.findViewById(R.id.topSach);
        Picasso.with(context)
                .load(ROOT_URL + "uploads/bia1.jpg")
                .placeholder(R.drawable.avatar)
                .into(topSach);
        return view;
    }
}
