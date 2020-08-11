package vn.com.ps10686.bookzone.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.com.ps10686.bookzone.Model.CauHoi;
import vn.com.ps10686.bookzone.Model.HoaDonFinal;
import vn.com.ps10686.bookzone.R;
import vn.com.ps10686.bookzone.api.API;
import vn.com.ps10686.bookzone.api.RetrofitClient;

public class SachCuaBanAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<HoaDonFinal> hoaDonFinals;
    RetrofitClient retrofitClient;

    public SachCuaBanAdapter(Context context, int layout, List<HoaDonFinal> hoaDonFinals) {
        this.context = context;
        this.layout = layout;
        this.hoaDonFinals = hoaDonFinals;
    }

    @Override
    public int getCount() {
        return hoaDonFinals.size();
    }

    @Override
    public Object getItem(int position) {
        return hoaDonFinals.get(position);
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

        viewHolder.cauHoi = convertView.findViewById(R.id.scb_cauhoi);

        viewHolder.cauHoi.setText(hoaDonFinals.get(position).getCauHoi());

        final HoaDonFinal hoaDonFinal = hoaDonFinals.get(position);

        viewHolder.cauHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Cau tra loi")
                        .setMessage(getCTL(hoaDonFinal.getMaSach(),hoaDonFinal.getCauHoi()))
                        .show();
            }
        });

        convertView.setTag(viewHolder);

        return convertView;
    }

    public class ViewHolder{

        TextView cauHoi;
    }
    String ctl;
    String getCTL(String maSach ,String cauHoi){
        API api = retrofitClient.getClien().create(API.class);

        api.getCTL(maSach, cauHoi).enqueue(new Callback<CauHoi>() {
            @Override
            public void onResponse(Call<CauHoi> call, Response<CauHoi> response) {
                if (response.code() == 200){
//                    List<CauHoi> cauTL =  response.body();
                    CauHoi cauHoi = response.body();
                    ctl = cauHoi.getCauTraLoi();

                }else if(response.code() == 404){
                    ctl = "";
                }
            }

            @Override
            public void onFailure(Call<CauHoi> call, Throwable t) {

            }
        });
        return ctl;
    }

}
