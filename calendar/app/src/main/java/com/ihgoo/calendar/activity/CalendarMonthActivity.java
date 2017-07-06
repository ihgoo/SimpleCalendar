package com.ihgoo.calendar.activity;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.huangjh.library.adapter.CalendarMonthAdapter;


/**
 * Created by ihgoo on 2015/3/30.
 */
public class CalendarMonthActivity extends Activity {

    private ListView lv;
    private CalendarMonthAdapter investmentDetailMonthAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_calendar);
        initView();
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
        investmentDetailMonthAdapter = CalendarMonthAdapter(this);
        lv.setAdapter(investmentDetailMonthAdapter);
    }
}
