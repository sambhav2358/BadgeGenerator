package com.sambhav2358.badgegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;

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
        binding.done.setOnClickListener(v -> {
            binding.badge.setColor(binding.colorED.getText().toString());
            binding.badge.setMessage(binding.messageED.getText().toString());
            binding.badge.setLabel(binding.labelED.getText().toString());
            binding.badge.setType(BadgeType.startText + binding.styleED.getText().toString());
            if (binding.customImage.isChecked()){
                binding.badge.setCustomLogo(binding.customLogoED.getText().toString());
            }else {
                binding.badge.setLogo(binding.logoED.getText().toString());
            }
            binding.badge.setLink(binding.customRedirectED.getText().toString());
            binding.badge.setLabelColor(binding.customLabelED.getText().toString());
            binding.badge.setLogoColor(binding.customLogoColorED.getText().toString());
        });

        binding.customImage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                binding.customLogoED.setVisibility(View.VISIBLE);
                binding.logoED.setVisibility(View.GONE);
            }else {
                binding.customLogoED.setVisibility(View.GONE);
                binding.logoED.setVisibility(View.VISIBLE);
            }
        });
    }
}