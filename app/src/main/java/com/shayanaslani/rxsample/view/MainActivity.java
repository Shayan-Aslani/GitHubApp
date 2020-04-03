package com.shayanaslani.rxsample.view;

import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.shayanaslani.rxsample.R;

public class MainActivity extends SingleFragmentActivity {



    @Override
    public Fragment createFragment() {
        return MainFragment.newInstance();
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
    }
}
