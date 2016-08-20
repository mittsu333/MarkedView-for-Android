package com.mittsu.markedviewlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mittsu.markedview.MarkedView;

import java.io.File;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        FileCopyManager fcm = new FileCopyManager(this);

        MarkedView mdView = (MarkedView)findViewById(R.id.md_view);
        // code block in scrolling be deactivated.
        // mdView.setCodeScrollDisable();

        File mdFile = new File(fcm.getSampleFilePath(this));
        mdView.loadMDFile(mdFile);

    }
}
