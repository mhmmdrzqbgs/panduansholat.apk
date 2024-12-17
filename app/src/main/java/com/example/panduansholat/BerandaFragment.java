package com.example.panduansholat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BerandaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the views for the linear layouts
        LinearLayout linearShalat = view.findViewById(R.id.linearShalat);
        LinearLayout linearNiat = view.findViewById(R.id.linearNiat);
        LinearLayout linearDoa = view.findViewById(R.id.linearDoa);

        // Set click listeners for the linear layouts
        linearShalat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SholatActivity.class);
                startActivity(intent);
                // Handle click on linearShalat
            }
        });

        linearNiat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NiatActivity.class);
                startActivity(intent);
                // Handle click on linearBacaanShalat
            }
        });

        linearDoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DoaActivity.class);
                startActivity(intent);
                // Handle click on linearDoa
            }
        });
    }
}