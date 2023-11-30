package com.example.mentalhealthapp.ui.onboarding.components.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.ui.onboarding.components.onBoardingPage;

public class OnboardingFragment extends Fragment {
    private static final String ARG_PAGE = "arg_page";

    public static OnboardingFragment newInstance(onBoardingPage page) {
        OnboardingFragment fragment = new OnboardingFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PAGE, (Parcelable) page);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("OnboardingFragment", "onCreateView called");
        View view = inflater.inflate(R.layout.slider_layout, container, false);
        assert getArguments() != null;
        onBoardingPage page = (onBoardingPage) getArguments().getParcelable(ARG_PAGE);

        ImageView imageView = view.findViewById(R.id.image_view);
        TextView titleTextView = view.findViewById(R.id.text_title);
        TextView descriptionTextView = view.findViewById(R.id.text_description);

        assert page != null;
        imageView.setImageResource(page.getImageResourceId());
        titleTextView.setText(page.getHeading());
        descriptionTextView.setText(page.getDescription());

        return view;
    }
}

