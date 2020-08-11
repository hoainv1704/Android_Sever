package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import vn.com.ps10686.bookzone.Model.CauHoi;
import vn.com.ps10686.bookzone.R;


public class CauHoiAdapter extends BaseAdapter {

    private ArrayList<CauHoi> cauHoiList;
    private int layout;
    private Context context;
    public static ArrayList<CauHoi> cauhoimuonmua = new ArrayList<>();

    public CauHoiAdapter(ArrayList<CauHoi> cauHoiList, Context context, int layout) {
        this.cauHoiList = cauHoiList;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cauHoiList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        viewHolder.cauHoi = (TextView) convertView.findViewById(R.id.tv_cauhoi);
        viewHolder.imvMua = (ImageView) convertView.findViewById(R.id.imv_mua);

        convertView.setTag(viewHolder);
        final CauHoi cauHoi = cauHoiList.get(position);

        viewHolder.cauHoi.setText(cauHoi.getCauHoi());

        viewHolder.imvMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "da them vao gio hang", Toast.LENGTH_SHORT).show();
                cauhoimuonmua.add(cauHoi);
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView cauHoi;

        ImageView imvMua;

    }
}
