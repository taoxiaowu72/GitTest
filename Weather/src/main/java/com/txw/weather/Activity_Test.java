package com.txw.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_Test extends AppCompatActivity {

    @BindView(R.id.test_text)
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__test);

        ButterKnife.bind(this);

        test.setText("这是测试控件");
    }
}
