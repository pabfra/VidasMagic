package com.example.vidasmagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.vidasmagic.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private int lifeP1;
    private int lifeP2;
    private int poissonP1;
    private int poissonP2;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        resetCounters();
        if(savedInstanceState != null){
            lifeP1 = (int) savedInstanceState.get("lifeP1");
            lifeP2 = (int) savedInstanceState.get("lifeP2");
            poissonP1 = (int) savedInstanceState.get("poissonP1");
            poissonP2 = (int) savedInstanceState.get("poissonP2");
        }
        updateCounters();

        return binding.getRoot();

    }

    private void resetCounters() {
        lifeP1 = 20;
        lifeP2 = 20;
        poissonP1 = 0;
        poissonP2 = 0;
    }

    private void updateCounters() {
        binding.textCounterP1.setText(lifeP1 + "/" + poissonP1);
        binding.textCounterP2.setText(lifeP2 + "/" + poissonP2);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnLifePlusP1.setOnClickListener(btn -> {
            lifeP1++;
            updateCounters();
        });

        binding.btnLifePlusP2.setOnClickListener(btn -> {
            lifeP2++;
            updateCounters();
        });

        binding.btnLifeLessP1.setOnClickListener(btn -> {
            if(lifeP1 > 0)
                lifeP1--;
            updateCounters();
        });

        binding.btnLifeLessP2.setOnClickListener(btn -> {
            if (lifeP2 > 0)
                lifeP2--;
            updateCounters();
        });

        binding.btnPoissonPlusP1.setOnClickListener(btn -> {
            poissonP1++;
            updateCounters();
        });

        binding.btnPoissonPlusP2.setOnClickListener(btn -> {
            poissonP2++;
            updateCounters();
        });

        binding.btnPoissonLessP1.setOnClickListener(btn -> {
            if (poissonP1 > 0)
                poissonP1--;
            updateCounters();
        });

        binding.btnPoissonLessP2.setOnClickListener(btn -> {
            if (poissonP2 > 0)
                poissonP2--;
            updateCounters();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onSaveInstanceState(Bundle outState){
        outState.putInt("lifeP1", lifeP1);
        outState.putInt("lifeP2", lifeP2);
        outState.putInt("poissonP1", poissonP1);
        outState.putInt("poissonP2", poissonP2);
    }
}