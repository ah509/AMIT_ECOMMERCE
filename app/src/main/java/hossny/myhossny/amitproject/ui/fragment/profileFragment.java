package hossny.myhossny.amitproject.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import hossny.myhossny.amitproject.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class profileFragment extends Fragment {



    public profileFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}