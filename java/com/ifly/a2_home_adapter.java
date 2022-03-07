package com.ifly;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class a2_home_adapter extends BaseAdapter {
    List<a2_home_item_container> list ;
    String TAG = "vik";


    public a2_home_adapter(List<a2_home_item_container> list) {
        this.list = list;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.a2_home_item, parent, false);
        } else {
            view = convertView;
        }

        TextView slot = view.findViewById(R.id.a2_home_slot);
        TextView work = view.findViewById(R.id.a2_work);

        slot.setText(list.get(position).slot);
        work.setText(list.get(position).work);


        if (position == 2) {
            int color = parent.getResources().getColor(R.color.pink_red);
            ((TextView)(view.findViewById(R.id.a2_home_slot))).setTextColor(color);
            work.setTextColor(color);
        }
        if (position == list.size() - 1) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new Universal().OpenGivenActivity(parent.getContext(),a6_edit_schedule.class);
                }
            });
        }

        return view;
    }
}
