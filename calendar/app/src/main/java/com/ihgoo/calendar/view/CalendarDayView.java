package com.ihgoo.calendar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ihgoo.calendar.R;


/**
 * Created by ihgoo on 2015/3/30.
 */
public class CalendarDayView extends LinearLayout {

    TextView tvCalendarDay;
    TextView tvCalendarInvestmentValue;
    LinearLayout ll;


    private View dayView;

    public CalendarDayView(Context context) {
        super(context);
        dayView = LinearLayout.inflate(context, R.layout.item_calendar_day, this);
        tvCalendarDay = (TextView) dayView.findViewById(R.id.tv_calendar_day);
        tvCalendarInvestmentValue = (TextView) dayView.findViewById(R.id.tv_calendar_investment_value);
        ll = (LinearLayout) dayView.findViewById(R.id.ll);
    }

    public CalendarDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public CalendarDayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    public void setInvestment(String investmentValue) {
        tvCalendarInvestmentValue.setText(investmentValue);
    }

    public void setDay(String day) {
        tvCalendarDay.setText(day);
    }

    public void setDayTextColor(){
        tvCalendarDay.setTextColor(getResources().getColor(R.color.red));
    }

}
