package vn.com.ps10686.bookzone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import vn.com.ps10686.bookzone.Model.Sach;
import vn.com.ps10686.bookzone.Model.Sach1;
import vn.com.ps10686.bookzone.R;

public class SearchAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    private List<Sach1> list = null;
    private ArrayList<Sach1> arraylist;

    public SearchAdapter(Context context, List<Sach1> list) {
        this.arraylist = new ArrayList<>();
        this.context = context;
        this.list = list;
        this.arraylist.addAll(list);
        inflater = LayoutInflater.from(context);
    }

    public class ViewHolder {
        TextView tenSach;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.search_item, null);
            // Locate the TextViews in listview_item.xml
            holder.tenSach = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        Sach1 sach1 = list.get(i);
        holder.tenSach.setText(sach1.getTenSach());
        return view;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        list.clear();
        if (charText.length() == 0) {
            list.addAll(arraylist);
        } else {
            for (Sach1 wp : arraylist) {
                if (wp.getTenSach().toLowerCase(Locale.getDefault()).contains(charText)) {
                    list.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
