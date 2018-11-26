package com.example.qd.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {
    private View view;
    private String title;
    private TextView tv_text;

    public MainFragment(String title) {
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(),R.layout.fragment_main,null);

        tv_text = view.findViewById(R.id.tv_text);
        tv_text.setText(title);
        return view;
    }
}
