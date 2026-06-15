package com.difa.endemikdb.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.difa.endemikdb.R;

public class ProfilFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        
        ImageView photo = view.findViewById(R.id.profile_image);
        TextView name = view.findViewById(R.id.profile_name);
        TextView nim = view.findViewById(R.id.profile_nim);

        // Set your data here
        name.setText("Difa Calista Felicia");
        nim.setText("2410501018");
        photo.setImageResource(R.drawable.ciaw);

        return view;
    }
}