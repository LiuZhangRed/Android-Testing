package com.example.jerry.testing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jerry.testing.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jerry on 2016/12/29.
 */

public class MainAdpter extends BaseAdapter {
    Context mContext;
    LinearLayout linearLayout = null;
    LayoutInflater inflater;
    private HashMap<Integer, Boolean> isSelected;

    final int VIEW_TYPE_COUNT = 2;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    List<String> list = new ArrayList<>();
    public MainAdpter (Context context, List<String> list) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private void initDate() {
        for (int i = 0; i < list.size(); i++) {
            getIsSelected().put(i, false);
        }
    }

    public List<String> getlist() {
        return list;
    }

    public void setlist(List<String> list) {
        this.list = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        if (convertView == null) {
            convertView = inflater.inflate(
                    R.layout.layout_main,
                    parent, false);
            holder2 = new ViewHolder2(convertView);
            convertView.setTag(holder2);
        } else {
            holder2 = (ViewHolder2) convertView.getTag();
        }
        return null;
    }
    public HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        this.isSelected = isSelected;
    }

    public void updateIsSelected() {
        initDate();
    }


    class ViewHolder1 {
    }
    class ViewHolder2 {
     ImageView habit_finish,star;
        TextView sleep,tv_habit;
        public ViewHolder2(View convertView) {
            star=(ImageView)convertView.findViewById(R.id.star);
            habit_finish=(ImageView)convertView.findViewById(R.id.habit_finish);
            sleep=(TextView)convertView.findViewById(R.id.sleep);
            tv_habit=(TextView)convertView.findViewById(R.id.tv_habit);
        }
    }
}
