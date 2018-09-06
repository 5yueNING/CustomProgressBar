package com.view.custom.progressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.custom.view.progressbarlib.CircleProgressBarView;
import com.custom.view.progressbarlib.HorizontalCursorProgressBar;
import com.custom.view.progressbarlib.HorizontalTextProgressBar;
import com.custom.view.progressbarlib.LoadingLineView;

public class ProgressBarActivity extends AppCompatActivity {
    CircleProgressBarView circleProgressBarView;
    HorizontalCursorProgressBar horizontalProgressBar;
    HorizontalTextProgressBar productProgressBar;
    LoadingLineView loadingLineView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        circleProgressBarView = findViewById(R.id.circle_progress_view);

        horizontalProgressBar = findViewById(R.id.horizontal_progress_view);
        productProgressBar = findViewById(R.id.product_progress_view);
        loadingLineView = findViewById(R.id.loading_line_view);

        button = (Button) findViewById(R.id.startAnimationBtn);

        circleProgressBarView.setProgressWithAnimation(60);
        circleProgressBarView.setProgressListener(new CircleProgressBarView.ProgressListener() {
            @Override
            public void currentProgressListener(float currentProgress) {
                //textView.setText("当前进度：" + currentProgress);
            }
        });
        circleProgressBarView.startProgressAnimation();

        horizontalProgressBar.setProgressWithAnimation(60).setProgressListener(new HorizontalCursorProgressBar.ProgressListener() {
            @Override
            public void currentProgressListener(float currentProgress) {
            }
        });
        horizontalProgressBar.startProgressAnimation();

        productProgressBar.setProgress(60).setProgressListener(new HorizontalTextProgressBar.ProgressListener() {
            @Override
            public void currentProgressListener(float currentProgress) {
                Log.e("allen", "currentProgressListener: " + currentProgress);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingLineView.stopLoading();
                horizontalProgressBar.setProgressWithAnimation(50);
                productProgressBar.setProgress(80);
                circleProgressBarView.setProgressWithAnimation(90).startProgressAnimation();
                circleProgressBarView.setProgressListener(new CircleProgressBarView.ProgressListener() {
                    @Override
                    public void currentProgressListener(float currentProgress) {
                        //textView.setText("当前进度：" + currentProgress);
                    }
                });
            }
        });
    }
}
