package com.support.android.designlibdemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kai on 2018/1/3.
 */

public class ActivityTransitionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_transition, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        View explode = view.findViewById(R.id.btn_explode);
        View slide = view.findViewById(R.id.btn_slide);
        View fade = view.findViewById(R.id.btn_fade);
        explode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naviTo("explode");
            }
        });
        slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naviTo("slide");
            }
        });
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naviTo("fade");
            }
        });
    }

    public void naviTo(String flag) {
        Intent intent = new Intent(getActivity(), CheeseDetailActivity.class);
        intent.putExtra(CheeseDetailActivity.EXTRA_NAME, "wasami");
        intent.putExtra("flag", flag);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getActivity().startActivity(intent,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity()).toBundle());
        } else {
            getActivity().startActivity(intent);
        }
    }
}
