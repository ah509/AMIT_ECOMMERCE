package hossny.myhossny.amitproject.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import hossny.myhossny.amitproject.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_products_details extends Fragment {




    public Fragment_products_details() {
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
        return inflater.inflate(R.layout.fragment_products_details, container, false);
    }
}