package com.game2048.number.puzzle;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.game2048.number.BuildConfig;
import com.game2048.number.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    public Activity activity;
   // public Dialog d;
    public TextView tvRate_us, tvYes, tvNo;

    public CustomDialog(@NonNull Context context) {
        super(context);
        this.activity = (Activity) context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_custom_dialog);
        tvRate_us = findViewById(R.id.rate_us);
        tvYes = findViewById(R.id.yes);
        tvNo = findViewById(R.id.no);
        tvRate_us.setOnClickListener(this);
        tvYes.setOnClickListener(this);
        tvNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rate_us:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + BuildConfig.APPLICATION_ID)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)));
                }
            case R.id.yes:
                activity.finish();
                break;
            case R.id.no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();

    }
}
