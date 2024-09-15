package com.example.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.shop.MainActivity;
import com.example.shop.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputLayout usernameTextInputLogin = findViewById(R.id.username_text_input);
        TextInputLayout passwordTextInputLogin = findViewById(R.id.password_text_input);
        Button login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(view -> {
            EditText usernameEditText = usernameTextInputLogin.getEditText();
            String username = usernameEditText.getText().toString();
            if (username.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("UserName", username);
            startActivity(intent);
        });
    }
}