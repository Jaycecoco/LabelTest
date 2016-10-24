package com.huangxiao.labletest;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pinger.library.FlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
//    private String[] mDatas = new String[10] ;
    private List<String> list=new ArrayList<String>();

    private Button addPersonlabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        addPersonlabel=(Button)findViewById(R.id.add_person_label);
        addPersonlabel.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View v){
                
            }
        });

        Random random = new Random();

        // 循环添加TextView到容器
        for (int i = 0; i < list.size(); i++) {
            final TextView view = new TextView(this);
            view.setText(list.get(i));
            view.setTextColor(Color.WHITE);
            view.setPadding(5, 5, 5, 5);
            view.setGravity(Gravity.CENTER);
            view.setTextSize(14);

            // 设置点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            // 设置彩色背景
            GradientDrawable normalDrawable = new GradientDrawable();
            normalDrawable.setShape(GradientDrawable.RECTANGLE);
//            int a = 255;
//            int r = 50 + random.nextInt(150);
//            int g = 50 + random.nextInt(150);
//            int b = 50 + random.nextInt(150);
            normalDrawable.setColor(Color.argb(200, 20, 200, 200));

            // 设置按下的灰色背景
            GradientDrawable pressedDrawable = new GradientDrawable();
            pressedDrawable.setShape(GradientDrawable.RECTANGLE);
            pressedDrawable.setColor(Color.GRAY);

            // 背景选择器
            StateListDrawable stateDrawable = new StateListDrawable();
            stateDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
            stateDrawable.addState(new int[]{}, normalDrawable);

            // 设置背景选择器到TextView上
            view.setBackground(stateDrawable);
//
            flowLayout.addView(view);
        }
    }
}
