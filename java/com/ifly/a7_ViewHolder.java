package com.ifly;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

public class a7_ViewHolder extends RecyclerView.ViewHolder {
    private TextView date, targetName, detail;
    String TAG = "vik";
    View viewThis;

    public a7_ViewHolder(@NonNull View view) {
        super(view);
        this.viewThis = view;

        date = view.findViewById(R.id.a7_detail_date);
        targetName = view.findViewById(R.id.a7_target_name_show);
        detail = view.findViewById(R.id.a7_work_detail_item);
    }

    public void bind(String detailDate, String targetNameS, String detailS) {
        date.setText(detailDate);
        targetName.setText(targetNameS);
        detail.setText(detailS);

    }

    // omitted for future implementation
    private TextView AddTextView(int position) {
        ConstraintLayout layout = (ConstraintLayout) viewThis.findViewById(R.id.a7_item_const_layout);

        ConstraintSet set = new ConstraintSet();

        TextView nTv = new TextView(viewThis.getContext());
        int id = 100+position;

        nTv.setId(id);
        layout.addView(nTv,0);
        set.clone(layout);

        int previousId = id-1;

        if (layout.findViewById(previousId) != null) {
            Log.d(TAG, "AddTextView: 99 block");
            set.connect(nTv.getId(), ConstraintSet.TOP, previousId, ConstraintSet.BOTTOM,10);
        }
        else {
            Log.d(TAG, "AddTextView: noram block"+ previousId + " + " +position);
            set.connect(nTv.getId(), ConstraintSet.TOP, viewThis.findViewById(R.id.a7_work_detail_item).getId(), ConstraintSet.BOTTOM,10);
        }

        set.connect(nTv.getId(),ConstraintSet.START,layout.getId(), ConstraintSet.START);
        set.connect(nTv.getId(),ConstraintSet.END,layout.getId(), ConstraintSet.END);
        set.applyTo(layout);

        return nTv;
    }

    static a7_ViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.a7_item, parent, false);
        return new a7_ViewHolder(view);
    }

}
