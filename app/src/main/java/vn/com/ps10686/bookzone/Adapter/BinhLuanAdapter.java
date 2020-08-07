package vn.com.ps10686.bookzone.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.com.ps10686.bookzone.Model.BinhLuan;
import vn.com.ps10686.bookzone.R;

public class BinhLuanAdapter extends RecyclerView.Adapter<BinhLuanAdapter.ViewHolder> {
    static Context context;

    LinearLayoutManager mLayoutManager;
    BinhLuan binhluan;
    List<BinhLuan> ds;

    public BinhLuanAdapter(Context context, List<BinhLuan> ds){
        this.context = context;
        this.ds = ds;
    }

    @NonNull
    @Override
    public BinhLuanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context)
                .inflate(R.layout.binhluan_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final BinhLuanAdapter.ViewHolder holder, final int position) {

        final BinhLuan bl = ds.get(position);
        holder.tvTenND.setText(bl.getTenNguoiDung()+"");
        holder.tvNDBL.setText(bl.getNdBL()+"");

    }

    @Override
    public int getItemCount() {
        return ds.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTenND, tvNDBL;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTenND = itemView.findViewById(R.id.tv_tenND);
            tvNDBL = itemView.findViewById(R.id.tv_NDBL);
        }
    }
}
