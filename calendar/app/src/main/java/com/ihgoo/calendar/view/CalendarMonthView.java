package com.ihgoo.calendar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihgoo.calendar.R;

import java.util.Calendar;

/**
 * Created by ihgoo on 2015/3/30.
 */
public class CalendarMonthView extends LinearLayout {

    int mYear;
    int mMonth;
    int mDay;
    Calendar calendar;
    CalendarDayView[][] dateViews;
    int day = 0;
    boolean thisMonthEnd = false;
    View header;

    public CalendarMonthView(Context context, int month) {
        super(context);
        this.setOrientation(VERTICAL);
        this.mMonth = month+1;
        calendar = Calendar.getInstance();
        initData();
        initView(context);
    }


    private void initData() {
        calendar.set(2015, mMonth, 1);
        int week = calendar.getMaximum(Calendar.WEEK_OF_MONTH);
        dateViews = new CalendarDayView[week][7];
    }


    public CalendarMonthView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CalendarMonthView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initView(Context context) {
        this.removeAllViews();
        if(mMonth%2==0){
            header = View.inflate(context, R.layout.item_calendar_header_left, null);
        }else{
            header = View.inflate(context, R.layout.item_calendar_header_right, null);
        }


        TextView monthTv = (TextView)header.findViewById(R.id.tv_month);
        monthTv.setText(mMonth+"月");
        this.addView(header);


        int week = calendar.get(Calendar.DAY_OF_WEEK);

        for (int i = 0; i < dateViews.length; i++) {

            if (thisMonthEnd) {
                break;
            }

            LinearLayout weekView = new LinearLayout(context);
            LayoutParams weekLP = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            weekView.setLayoutParams(weekLP);
            weekView.setOrientation(HORIZONTAL);
            weekView.setBackgroundColor(getResources().getColor(R.color.white));


            for (int g = 0; g < week - 1; g++) {
                View view = new View(context);
                LayoutParams layoutParams = new LayoutParams(0, 1, 1.0f);
                view.setLayoutParams(layoutParams);
                weekView.addView(view);
            }


            for (int j = week - 1; j < dateViews[i].length; j++) {
                mDay = calendar.get(Calendar.DAY_OF_MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                dateViews[i][j] = new CalendarDayView(context);
                LayoutParams lp = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
                dateViews[i][j].setLayoutParams(lp);
                dateViews[i][j].setDay(String.valueOf(mDay) + "");
                weekView.addView(dateViews[i][j]);

                if (thisMonthEnd) {
                    dateViews[i][j].setVisibility(View.INVISIBLE);
                }

                if (calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    thisMonthEnd = true;
                }

                if (j==0||j==6){
                    dateViews[i][j].setDayTextColor();
                }

                calendar.roll(Calendar.DAY_OF_MONTH, true);
            }
            week = 1;
            this.addView(weekView);

        }


    }


}
