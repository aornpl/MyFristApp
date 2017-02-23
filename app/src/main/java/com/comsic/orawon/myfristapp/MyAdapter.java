package com.comsic.orawon.myfristapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by macbookair on 2/23/17.
 */
//Activity สร้างเพื่อทำเลเอ้าท์เสมือนเพื่อเอาไปแสดงผลบนหน้าMain Acitivity
public class MyAdapter extends BaseAdapter {

    //Explicit
    private Context context;
    private int[]ints;
    private String[] titleStrings, detailStrings;

    public MyAdapter(Context context, int[] ints, String[] titleStrings, String[] detailStrings) {
        this.context = context;
        this.ints = ints;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return ints.length;

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

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);

        //Initial View
        ImageView imageView = (ImageView) view.findViewById(R.id. imvicon);
        TextView titleTextView = (TextView) view.findViewById(R.id.txtTitleLiv) ;
        TextView detailTextView = (TextView) view.findViewById(R.id.txtDetailLiv) ;
        //Show View เอาข้อมูลไปแสดงผลบนหน้าแอพ
        imageView.setImageResource(ints[position]);
        titleTextView.setText(titleStrings[position]);
        detailTextView.setText(detailStrings[position]);

        return view;
    }
} //Moin Closs
