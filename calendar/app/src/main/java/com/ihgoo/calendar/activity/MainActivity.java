package com.ihgoo.calendar.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.ihgoo.calendar.R;
import com.ihgoo.calendar.adapter.CalendarMonthAdapter;

/**
 * Created by ihgoo on 2015/3/30.
 */
public class MainActivity extends Activity {

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
        investmentDetailMonthAdapter = new CalendarMonthAdapter(this);
        lv.setAdapter(investmentDetailMonthAdapter);
    }
}
