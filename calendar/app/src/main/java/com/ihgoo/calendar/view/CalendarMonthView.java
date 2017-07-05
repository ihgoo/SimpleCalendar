package com.ihgoo.calendar.view;

import android.content.Context;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihgoo.calendar.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ihgoo on 2015/3/30.
 */
public class CalendarMonthView extends LinearLayout {
    protected Calendar minDay;
    protected Time today;
    int mYear;
    int mMonth;
    int mDay;
    Calendar calendar;
    CalendarDayView[][] dateViews;
    Calendar chinesCalendar;
    int day = 0;
    boolean thisMonthEnd = false;
    View header;
    public CalendarMonthView(Context context, int month) {
        super(context);
        this.setOrientation(VERTICAL);
        this.mMonth = month+1;
        calendar = Calendar.getInstance();
        chinesCalendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        initData();
        initView(context);
    }


    private void initData() {
        calendar.set(2015, mMonth, 1);
        chinesCalendar.set(2015,mMonth-1,1);
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
        if (mMonth>12){
            mMonth = mMonth -12;
            mYear++;
        }
        header = View.inflate(context, R.layout.item_calendar_header, null);

        TextView monthTv = (TextView)header.findViewById(R.id.tv_month);
        monthTv.setText(mYear+"年"+(mMonth)+"月");
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
                dateViews[i][j].setDate(monthTv.getText().toString()+mDay+"日");

                if (thisMonthEnd) {
                    dateViews[i][j].setVisibility(View.INVISIBLE);
                }

                if (calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    thisMonthEnd = true;
                }
//              周末置灰
                if (j==0||j==6){
                    dateViews[i][j].setWeekendColor();
                }
//              今日前置灰
                if (prevDay(day,today)){
                    dateViews[i][j].setDayTextColor();
                }
                if (thisDay(day,today)){
                    dateViews[i][j].setThisDayColor();
                }
                calendar.roll(Calendar.DAY_OF_MONTH, true);
            }
            week = 1;
            this.addView(weekView);

        }


    }

    /**
     * 今天之前的时间
     *
     * @param monthDay
     * @param time
     * @return
     */
    private boolean prevDay(int monthDay, Time time) {
        if (minDay != null) {
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.set(mYear, mMonth, monthDay);
            return currentCalendar.getTimeInMillis() < minDay.getTimeInMillis();
        }
        return ((mYear < time.year)) || (mYear == time.year && mMonth-1 < time.month)
                || (mYear == time.year && mMonth-1 == time.month && monthDay < time.monthDay);
    }

    private boolean thisDay(int monthDay,Time time){
        if (minDay != null) {
            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.set(mYear, mMonth, monthDay);
            return currentCalendar.getTimeInMillis() < minDay.getTimeInMillis();
        }
        return (mYear == time.year && mMonth-1 == time.month && monthDay == time.monthDay);
    }
//    private String getChineseDay(Date myDate){
//        Calendar calCalendar = Calendar.getInstance();
//        calCalendar.setTime(myDate);
//        CalenderUtils calendarUtil = new CalenderUtils(calCalendar);
//        return calendarUtil.toString();
//
//    }
}
