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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    private CalendarView mCalendar;

    //meditation variables
    private Spinner mSpinner;

    private ListView mSleepList;
    private ListView mStressList;
    private ListView mConfidenceList;
    private ListView mRelaxList;
    private ListView mLoveList;
    private ListView mHappinessList;

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

                    mSleepList.setVisibility(View.VISIBLE);
                    mStressList.setVisibility(View.GONE);
                    mConfidenceList.setVisibility(View.GONE);
                    mHappinessList.setVisibility(View.GONE);
                    mLoveList.setVisibility(View.GONE);
                    mRelaxList.setVisibility(View.GONE);

                    class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
                        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                            switch ( pos ) {   //parent.getItemAtPosition(pos).toString()) {
                                case 0:

                                    mSleepList.setVisibility(View.VISIBLE);
                                    mStressList.setVisibility(View.GONE);
                                    mConfidenceList.setVisibility(View.GONE);
                                    mHappinessList.setVisibility(View.GONE);
                                    mLoveList.setVisibility(View.GONE);
                                    mRelaxList.setVisibility(View.GONE);

                                case 1:
                                    mSleepList.setVisibility(View.GONE);
                                    mStressList.setVisibility(View.VISIBLE);
                                    mConfidenceList.setVisibility(View.GONE);
                                    mHappinessList.setVisibility(View.GONE);
                                    mLoveList.setVisibility(View.GONE);
                                    mRelaxList.setVisibility(View.GONE);

                                case 2:
                                    mSleepList.setVisibility(View.GONE);
                                    mStressList.setVisibility(View.GONE);
                                    mConfidenceList.setVisibility(View.GONE);
                                    mHappinessList.setVisibility(View.GONE);
                                    mLoveList.setVisibility(View.GONE);
                                    mRelaxList.setVisibility(View.VISIBLE);

                                case 3:
                                    mSleepList.setVisibility(View.GONE);
                                    mStressList.setVisibility(View.GONE);
                                    mConfidenceList.setVisibility(View.VISIBLE);
                                    mHappinessList.setVisibility(View.GONE);
                                    mLoveList.setVisibility(View.GONE);
                                    mRelaxList.setVisibility(View.GONE);

                                case 4:
                                    mSleepList.setVisibility(View.GONE);
                                    mStressList.setVisibility(View.GONE);
                                    mConfidenceList.setVisibility(View.GONE);
                                    mHappinessList.setVisibility(View.VISIBLE);
                                    mLoveList.setVisibility(View.GONE);
                                    mRelaxList.setVisibility(View.GONE);

                                case 5:
                                    mSleepList.setVisibility(View.GONE);
                                    mStressList.setVisibility(View.GONE);
                                    mConfidenceList.setVisibility(View.GONE);
                                    mHappinessList.setVisibility(View.GONE);
                                    mLoveList.setVisibility(View.VISIBLE);
                                    mRelaxList.setVisibility(View.GONE);

                            }
                        }

                        public void onNothingSelected(AdapterView<?> parent) {
                            //do nothing
                        }
                    }

                    return true;

                case R.id.navigation_sleep:
                    mTextMessage.setText(R.string.title_sleep);

                    mSpinner.setVisibility(View.GONE);
                    mSleepList.setVisibility(View.GONE);

                    mCalendar.setVisibility(View.GONE);
                    return true;

                case R.id.navigation_cal:
                    mTextMessage.setText(R.string.title_calendar);

                    mSpinner.setVisibility(View.GONE);
                    mSleepList.setVisibility(View.GONE);

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalendar = (CalendarView) findViewById(R.id.calendarView);
        mCalendar.setVisibility(View.GONE);

        mTextMessage = (TextView) findViewById(R.id.message);

        mSleepList = (ListView) findViewById(R.id.sleep_list);
        mStressList = (ListView) findViewById(R.id.stress_list);
        mConfidenceList = (ListView) findViewById(R.id.confidence_list);
        mRelaxList = (ListView) findViewById(R.id.relax_list);
        mLoveList = (ListView) findViewById(R.id.love_list);
        mHappinessList = (ListView) findViewById(R.id.happiness_list);

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

        mStressList.setVisibility(View.GONE);
        mConfidenceList.setVisibility(View.GONE);
        mHappinessList.setVisibility(View.GONE);
        mLoveList.setVisibility(View.GONE);
        mRelaxList.setVisibility(View.GONE);

        mSpinner = (Spinner) findViewById(R.id.meditation_spinner);
 /*       mSpinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_main, R.id.sleep_list);
        adapter.setDropDownViewResource(android.R.layout.activity_list_item);

        mSpinner.setAdapter(adapter); */
    /*    mSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        }); */
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}


