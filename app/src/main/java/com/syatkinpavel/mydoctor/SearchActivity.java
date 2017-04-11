package com.syatkinpavel.mydoctor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import static com.syatkinpavel.mydoctor.R.id.calendarView;
import static com.syatkinpavel.mydoctor.R.id.clockView;

public class SearchActivity extends Activity implements View.OnClickListener{

    private Button calendar;
    private Button clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        TabHost tabHost = (TabHost) findViewById(R.id.TabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");


        tabSpec.setContent(R.id.one);
        tabSpec.setIndicator("1");
        tabHost.addTab(tabSpec);




        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.two);
        tabSpec.setIndicator("2");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.thre);
        tabSpec.setIndicator("3");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

        calendar = (Button) findViewById(calendarView);
        calendar.setOnClickListener(this);

        clock = (Button) findViewById(clockView);
        clock.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case calendarView:
               /* Intent calend = new Intent(this, CalendarActivity.class);
                startActivity(calend);
                break;
            case clockView:
                Intent clock = new Intent(this, ClockActivity.class);
                startActivity(clock);
                break;*/
            default:
                break;

        }
    }
}
