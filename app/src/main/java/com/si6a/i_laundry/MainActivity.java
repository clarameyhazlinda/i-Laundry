package com.si6a.i_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.si6a.i_laundry.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}