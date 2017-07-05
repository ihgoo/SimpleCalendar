package com.ihgoo.calendar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ihgoo.calendar.R;


/**
 * Created by ihgoo on 2015/3/30.
 */
public class CalendarDayView extends LinearLayout {

    TextView tvCalendarDay;
    TextView tvCalendarInvestmentValue;
    LinearLayout ll;
    String date ;

    private View dayView;

    public CalendarDayView(final Context context) {
        super(context);
        dayView = LinearLayout.inflate(context, R.layout.item_calendar_day, this);
        tvCalendarDay = (TextView) dayView.findViewById(R.id.tv_calendar_day);
        tvCalendarInvestmentValue = (TextView) dayView.findViewById(R.id.tv_calendar_investment_value);
        ll = (LinearLayout) dayView.findViewById(R.id.ll);
        dayView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,
                        date,
                        Toast.LENGTH_SHORT).show();

            }
        });
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
        tvCalendarDay.setTextColor(getResources().getColor(R.color.color_F2));
    }
    public void setWeekendColor(){
        tvCalendarDay.setTextColor(getResources().getColor(R.color.gray2));
    }

    public void setDate(String getDate){
        date = getDate;
    }
    public void setThisDayColor(){
        tvCalendarDay.setBackground(getResources().getDrawable(R.mipmap.bg_calendar_select));
        tvCalendarDay.setTextColor(getResources().getColor(R.color.white));
    }
}
