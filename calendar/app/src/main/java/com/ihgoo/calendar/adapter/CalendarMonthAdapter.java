package com.ihgoo.calendar.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ihgoo.calendar.view.CalendarMonthView;

/**
 * Created by ihgoo on 2015/3/20.
 */
public class CalendarMonthAdapter extends BaseAdapter {
    private Context mContext;


    public CalendarMonthAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 12;
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
        View view = new CalendarMonthView(mContext, position);
        return view;
    }

}
