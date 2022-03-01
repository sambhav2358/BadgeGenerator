package com.sambhav2358.badgegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;

import com.sambhav2358.badgegenerator.databinding.ActivityMainBinding;
import com.sambhav2358.badgegeneratorlibrary.BadgeColor;
import com.sambhav2358.badgegeneratorlibrary.BadgeType;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
    }

    private void init(){
        binding.badge.setLink("slither.io");
        binding.done.setOnClickListener(v -> {
            binding.badge.setColor(binding.colorED.getText().toString());
            binding.badge.setMessage(binding.messageED.getText().toString());
            binding.badge.setLabel(binding.labelED.getText().toString());
            binding.badge.setType(BadgeType.startText + binding.styleED.getText().toString());
        });
    }
}