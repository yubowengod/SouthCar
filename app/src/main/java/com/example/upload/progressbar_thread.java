package com.example.upload;
import android.widget.ProgressBar;

/**
 * Created by GOD on 2016/9/2.
 */
public class progressbar_thread {




    public void getProgressBar(ProgressBar progressBar){
        int progress = progressBar.getProgress();
        progress = progress + 10;
        progressBar.setProgress(progress);
    }




}
