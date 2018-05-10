package com.example.han.btest;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //隐藏掉整个ActionBar，包括下面的Tabs

        getSupportActionBar().hide();

        VideoView videoView = (VideoView) this.findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        mc.setVisibility(View.INVISIBLE);
        videoView.setMediaController(mc);




        //透過 url 播放
        //videoView.setVideoURI(Uri .parse("http://www.test.123/testmovie.mp4"));

        //透過 sdcard 路徑播放
        //videoView.setVideoPath("/sdcard/testmovie.mp4");

  /*其他 sdcard 路徑的範例，給大家參考
  videoView.setVideoURI(
   Uri.parse("file://" +
   Environment.getExternalStoragePublicDirectory(
   Environment.DIRECTORY_MOVIES) + "/testmovie.mp4"));
  */


        //本次用project下的目錄作為路徑來示範
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.st1));


        videoView.requestFocus();
        videoView.start();


        mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 9000); //9秒跳轉
    }
    private static final int GOTO_MAIN_ACTIVITY = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    Intent intent = new Intent();
                    //將原本Activity的換成MainActivity
                    intent.setClass(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                default:
                    break;
            }
        }

    };

}
