package com.subinkrishna.tigdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    // Log tag
    private static final String TAG = DetailsActivity.class.getSimpleName();

    // Keys
    public static final String KEY_USER = "user";

    TextView welcomeTextView;

    public static Intent getStartIntent(@NonNull Context context,
                                        String username) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(KEY_USER, username);
        return intent;
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final Intent intent = getIntent();
        final String username = (null != intent) ? intent.getStringExtra(KEY_USER) : null;

        if (!TextUtils.isEmpty(username)) {
            Log.d(TAG, "Prepare dashboard for " + username);
            welcomeTextView = (TextView) findViewById(R.id.welcome_message);
            welcomeTextView.setText(getResources().getString(R.string.dashboard_welcome_message, username));
        } else {
            Log.e(TAG, "No username found!");
        }
    }
}
