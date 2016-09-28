package com.subinkrishna.tigdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button submitButton;
    private TextView loginStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);
        submitButton = (Button) findViewById(R.id.submit);
        loginStatusTextView = (TextView) findViewById(R.id.login_status);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                loginStatusTextView.setVisibility(View.GONE);
                final String username = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                // Successful login
                if ("test".equals(password)) {
                    startActivity(DetailsActivity.getStartIntent(MainActivity.this, username));
                }
                // Invalid credentials
                else {
                    loginStatusTextView.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
