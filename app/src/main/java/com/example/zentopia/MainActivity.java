package com.example.zentopia;

import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //variables for adapters (hyperlinks in list)
    private TextView mTextMessage;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> dataList;
    private ArrayAdapter<String> dataAdapter;
    private ArrayList<String> stressList;
    private ArrayAdapter<String> stressAdapter;
    private ArrayList<String> happinessList;
    private ArrayAdapter<String> happinessAdapter;
    private ArrayList<String> confidenceList;
    private ArrayAdapter<String> confidenceAdapter;
    private ArrayList<String> loveList;
    private ArrayAdapter<String> loveAdapter;
    private ArrayList<String> relaxList;
    private ArrayAdapter<String> relaxAdapter;
    private CalendarView mCalendar;

    //meditation variables
    private Spinner mSpinner;

    //lists for different meditation categories
    private ListView mSleepList;
    private ListView mStressList;
    private ListView mConfidenceList;
    private ListView mRelaxList;
    private ListView mLoveList;
    private ListView mHappinessList;

    private ImageView mSleepSchedule;

    private BottomNavigationView mBottomNav;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_med:
                    mTextMessage.setText(R.string.title_meditation);
                    mCalendar.setVisibility(View.GONE);

                    mSpinner.setVisibility(View.VISIBLE);
                    mSleepSchedule.setVisibility(View.GONE);

                    mSleepList.setVisibility(View.VISIBLE);
                    mStressList.setVisibility(View.GONE);
                    mConfidenceList.setVisibility(View.GONE);
                    mHappinessList.setVisibility(View.GONE);
                    mLoveList.setVisibility(View.GONE);
                    mRelaxList.setVisibility(View.GONE);

                    return true;

                case R.id.navigation_sleep:
                    mTextMessage.setText(R.string.title_sleep);

                    mSpinner.setVisibility(View.GONE);
                    mSleepList.setVisibility(View.GONE);

                    mSleepSchedule.setVisibility(View.VISIBLE);
                    mCalendar.setVisibility(View.GONE);
                    return true;

                case R.id.navigation_cal:
                    mTextMessage.setText(R.string.title_calendar);

                    mSpinner.setVisibility(View.GONE);
                    mSleepList.setVisibility(View.GONE);
                    mSleepSchedule.setVisibility(View.GONE);

                    mCalendar.setVisibility(View.VISIBLE);

                    return true;
            }
            return false;
        }
    };

 /*   public void onItemSelected(AdapterView<?> arg0, View view, int pos, long id) {
        System.out.println("I'M HEEEEEEEERE");
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        //auto-generated
    }*/

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        switch ( item ) {   //parent.getItemAtPosition(pos).toString()) {
            case "Sleep":

                mTextMessage.setText(R.string.title_meditation);
                mCalendar.setVisibility(View.GONE);

                mSpinner.setVisibility(View.VISIBLE);
                mSleepSchedule.setVisibility(View.GONE);

                mSleepList.setVisibility(View.VISIBLE);
                mStressList.setVisibility(View.GONE);
                mConfidenceList.setVisibility(View.GONE);
                mHappinessList.setVisibility(View.GONE);
                mLoveList.setVisibility(View.GONE);
                mRelaxList.setVisibility(View.GONE);
                break;

            case "Stress":
                mSleepList.setVisibility(View.GONE);
                mStressList.setVisibility(View.VISIBLE);
                mConfidenceList.setVisibility(View.GONE);
                mHappinessList.setVisibility(View.GONE);
                mLoveList.setVisibility(View.GONE);
                mRelaxList.setVisibility(View.GONE);
                break;

            case "Relax":
                mSleepList.setVisibility(View.GONE);
                mStressList.setVisibility(View.GONE);
                mConfidenceList.setVisibility(View.GONE);
                mHappinessList.setVisibility(View.GONE);
                mLoveList.setVisibility(View.GONE);
                mRelaxList.setVisibility(View.VISIBLE);
                break;

            case "Confidence":
                mSleepList.setVisibility(View.GONE);
                mStressList.setVisibility(View.GONE);
                mConfidenceList.setVisibility(View.VISIBLE);
                mHappinessList.setVisibility(View.GONE);
                mLoveList.setVisibility(View.GONE);
                mRelaxList.setVisibility(View.GONE);
                break;

            case "Happiness":
                mSleepList.setVisibility(View.GONE);
                mStressList.setVisibility(View.GONE);
                mConfidenceList.setVisibility(View.GONE);
                mHappinessList.setVisibility(View.VISIBLE);
                mLoveList.setVisibility(View.GONE);
                mRelaxList.setVisibility(View.GONE);
                break;

            case "Love":
                mSleepList.setVisibility(View.GONE);
                mStressList.setVisibility(View.GONE);
                mConfidenceList.setVisibility(View.GONE);
                mHappinessList.setVisibility(View.GONE);
                mLoveList.setVisibility(View.VISIBLE);
                mRelaxList.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalendar = (CalendarView) findViewById(R.id.calendarView);
        mCalendar.setVisibility(View.GONE);

        mTextMessage = (TextView) findViewById(R.id.message);

        //list items, used to link to meditation video
        mSleepList = (ListView) findViewById(R.id.sleep_list);
        mStressList = (ListView) findViewById(R.id.stress_list);
        mConfidenceList = (ListView) findViewById(R.id.confidence_list);
        mRelaxList = (ListView) findViewById(R.id.relax_list);
        mLoveList = (ListView) findViewById(R.id.love_list);
        mHappinessList = (ListView) findViewById(R.id.happiness_list);

        //sleepList adapter
        mSleepList.setVisibility(View.VISIBLE);
        String[] items = getResources().getStringArray(R.array.sleep_items);
        arrayList=new ArrayList<>(Arrays.asList(items));
        arrayAdapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, arrayList);
        mSleepList.setAdapter(arrayAdapter);
        mSleepList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=F28MGLlpP90");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //stressList adapter
        mStressList.setVisibility(View.GONE);
        String[] stressItems = getResources().getStringArray(R.array.stress_items);
        stressList=new ArrayList<>(Arrays.asList(stressItems));
        stressAdapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, stressList);
        mStressList.setAdapter(stressAdapter);
        mStressList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=mFlrc16xjik");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //confidenceList adapter
        mConfidenceList.setVisibility(View.GONE);
        String[] confidenceItems = getResources().getStringArray(R.array.confidence_items);
        confidenceList=new ArrayList<>(Arrays.asList(confidenceItems));
        confidenceAdapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, confidenceList);
        mConfidenceList.setAdapter(confidenceAdapter);
        mConfidenceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=5Za1RZWmnYA");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //happinessList adapter
        mHappinessList.setVisibility(View.GONE);
        String[] happinessItems = getResources().getStringArray(R.array.happiness_items);
        happinessList=new ArrayList<>(Arrays.asList(happinessItems));
        happinessAdapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, happinessList);
        mHappinessList.setAdapter(happinessAdapter);
        mHappinessList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=Jyy0ra2WcQQ");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //loveList adapter
        mRelaxList.setVisibility(View.GONE);
        String[] relaxItems = getResources().getStringArray(R.array.relax_items);
        relaxList=new ArrayList<>(Arrays.asList(relaxItems));
        relaxAdapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, relaxList);
        mRelaxList.setAdapter(relaxAdapter);
        mRelaxList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=CdbzDMSGsyg");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //relaxList adapter
        mLoveList.setVisibility(View.GONE);
        String[] loveItems = getResources().getStringArray(R.array.love_items);
        loveList=new ArrayList<>(Arrays.asList(loveItems));
        loveAdapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, loveList);
        mLoveList.setAdapter(loveAdapter);
        mLoveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Uri uri = Uri.parse("https://www.youtube.com/watch?v=xB4WOgoRO54");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //sleep schedule variables
        mSleepSchedule = (ImageView) findViewById(R.id.sleepScheduleView);
        mSleepSchedule.setVisibility(View.GONE);


        //spinner stuff
        mSpinner = (Spinner) findViewById(R.id.meditation_spinner);
        mSpinner.setOnItemSelectedListener(this);

        String[] categories = getResources().getStringArray(R.array.meditation_entries);
        dataList=new ArrayList<>(Arrays.asList(categories));
        dataAdapter=new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, dataList);
        mSpinner.setAdapter(dataAdapter);
        //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //bottom navigation
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}


