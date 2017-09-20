package com.h2kresearch.iepread;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

  TextView test1;
  TextView test2;
  Button button;
  ProgressBar progressBar;

  String[] test1String = {"이", "야", "에", "아", "어", "오"};
  String[] test2String = {"에", "유", "오", "에", "오", "으"};
  int indexString = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    progressBar = (ProgressBar) findViewById(R.id.progressBar3);
    progressBar.setMax(test1String.length);
    progressBar.setProgress(1);

    test1 = (TextView) findViewById(R.id.textView);
    test2 = (TextView) findViewById(R.id.textView2);
    button = (Button) findViewById(R.id.button2);
    button.setEnabled(false);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (indexString >= test1String.length) {
          Intent intent = new Intent(getBaseContext(), Test2Activity.class);
          startActivity(intent);
        } else {
          button.setEnabled(false);
          //button.setBackgroundColor(Color.parseColor("#EDEDED"));

          test1.setBackground(getDrawable(R.drawable.roundcorner));
          test1.setTextColor(Color.parseColor("#404040"));
          test2.setBackground(getDrawable(R.drawable.roundcorner));
          test2.setTextColor(Color.parseColor("#404040"));

          test1.setText(test1String[indexString]);
          test2.setText(test2String[indexString]);
          indexString++;
          progressBar.setProgress(indexString);
        }
      }
    });

    test1.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
          button.setEnabled(true);
          //button.setBackgroundColor(Color.parseColor("#7ABC4F"));

          test1.setBackground(getDrawable(R.drawable.roundcorner_clicked));
          test1.setTextColor(Color.parseColor("#ffffff"));
          test2.setBackground(getDrawable(R.drawable.roundcorner));
          test2.setTextColor(Color.parseColor("#404040"));
        }
        return false;
      }
    });

    test2.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
          button.setEnabled(true);
          //button.setBackgroundColor(Color.parseColor("#7ABC4F"));

          test1.setBackground(getDrawable(R.drawable.roundcorner));
          test1.setTextColor(Color.parseColor("#404040"));
          test2.setBackground(getDrawable(R.drawable.roundcorner_clicked));
          test2.setTextColor(Color.parseColor("#ffffff"));
        }
        return false;
      }
    });
  }
}
