package com.example.loginapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.text.TextWatcher;
import android.text.Editable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        LinearLayout registr = findViewById(R.id.registr);
        TextView ruls = findViewById(R.id.ruls);
        TextView enter = findViewById(R.id.enter);

        EditText password = findViewById(R.id.password);
        EditText email = findViewById(R.id.email);
        Button button = findViewById(R.id.button);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    button.setBackgroundResource(R.drawable.bg_button_orange);
                } else {
                    button.setBackgroundResource(R.drawable.bg_button_grey);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        button.setOnClickListener(v -> {
            if (email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                registr.setVisibility(View.GONE);
                ruls.setVisibility(View.GONE);
                enter.setVisibility(View.GONE);
                Snackbar.make(v, "Вы успешно зарегистрировались", Snackbar.LENGTH_LONG).show();
            } else {
                Snackbar.make(v, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
            }
        });




    }
}