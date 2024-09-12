package com.example.shop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shop.R;
import com.example.shop.activity.LoginActivity;
import com.example.shop.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {
    private ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Khởi tạo View Binding để ràng buộc các thành phần giao diện
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Thiết lập sự kiện khi bấm nút Start
        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Chuyển đến LoginActivity khi người dùng nhấn nút
                    Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Log.d("IntroActivity", "LoginActivity started successfully");
                } catch (Exception e) {
                    // Ghi log nếu có lỗi khi khởi động LoginActivity
                    Log.e("IntroActivity", "Error starting LoginActivity", e);
                }
            }
        });
    }
}
