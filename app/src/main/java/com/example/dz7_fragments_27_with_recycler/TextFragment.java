package com.example.dz7_fragments_27_with_recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TextFragment extends Fragment {

    private static final String MODEL_TEXT_FR = "param1";

    private Destination mModel;

    private TextView textTitle;
    private TextView textSubTitle;
    private ImageView imageView;


    public TextFragment() {

    }

    public static TextFragment newInstance(Destination destination) {
        TextFragment fragment = new TextFragment();
        Bundle args = new Bundle();
        args.putSerializable(MODEL_TEXT_FR, destination);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        textTitle = view.findViewById(R.id.txtTitle);
        textSubTitle = view.findViewById(R.id.txtSubTitle);
        imageView = view.findViewById(R.id.imageV);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mModel = (Destination) getArguments().getSerializable(MODEL_TEXT_FR);
            displayDetails(mModel);
        }
    }

    void displayDetails(Destination destination) {
        textTitle.setText(destination.getTitle());
        textSubTitle.setText(destination.getSubTitle());
        imageView.setImageResource(destination.getImage());
    }
}