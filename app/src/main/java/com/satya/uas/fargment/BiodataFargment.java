package com.satya.uas.fargment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satya.uas.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BiodataFargment extends Fragment {


    public BiodataFargment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biodata_fargment, container, false);
    }

}
