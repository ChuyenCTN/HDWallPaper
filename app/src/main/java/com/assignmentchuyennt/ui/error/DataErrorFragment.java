package com.assignmentchuyennt.ui.error;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignmentchuyennt.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataErrorFragment extends Fragment {


    public DataErrorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_error, container, false);
    }

}
