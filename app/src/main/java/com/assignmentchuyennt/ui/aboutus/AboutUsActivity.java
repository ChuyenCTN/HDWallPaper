package com.assignmentchuyennt.ui.aboutus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.assignmentchuyennt.R;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about_us);
    }

    public void backActivity(View view) {
        onBackPressed();
        finish();
    }
}
