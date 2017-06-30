package com.example.deeson.mydrawbitmapmesh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyPSView myPSView;
    private int screenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        screenWidth = display.getWidth();
        screenHeight = display.getHeight();

        final TextView btn_reset = (TextView) findViewById(R.id.btn_reset);
        myPSView = (MyPSView) findViewById(R.id.myPSView);
        btn_reset.setOnClickListener(this);
        myPSView.setScreenSize(screenWidth, screenHeight);
        myPSView.setOnStepChangeListener(new MyPSView.IOnStepChangeListener() {
            @Override
            public void onStepChange(boolean isEmpty) {
                btn_reset.setTextColor(isEmpty ? Color.parseColor("#999999") : Color.parseColor("#000000"));
                btn_reset.setEnabled(!isEmpty);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_reset:
                myPSView.resetView();
                break;
        }
    }
}
