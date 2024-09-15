package com.example.shop;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        String username = getIntent().getStringExtra("UserName");
        if (username != null) {
            TextView welcomeTextView = findViewById(R.id.textView); // Assuming you have a TextView with this ID
            welcomeTextView.setText("Welcome, " + username + "!");
        }
    }
}