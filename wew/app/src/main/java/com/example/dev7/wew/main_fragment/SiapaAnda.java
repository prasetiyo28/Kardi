package com.example.dev7.wew.main_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dev7.wew.Input;
import com.example.dev7.wew.MainActivity;
import com.example.dev7.wew.PertanyaanFix;
import com.example.dev7.wew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiapaAnda extends Fragment {

    Button btnKepo;
    TextView txtSdhTau;


    public SiapaAnda() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_siapa_anda, container, false);

        btnKepo = (Button)view.findViewById(R.id.btnKepo);
        txtSdhTau = (TextView)view.findViewById(R.id.txtSdhTau);

        btnKepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Input.class);
                startActivity(intent);
            }
        });


        txtSdhTau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment mFragment = new Loker();
//                getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();

                MainActivity.tabStatus.setupWithViewPager(MainActivity.viewPager);
                MainActivity.viewPager.setCurrentItem(1);
//                Intent intent = new Intent(getActivity(), Loker.class);
//                startActivity(intent);

//                public void ButtonClick(View view) {
//                    Fragment mFragment = new YourNextFragment();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, mFragment).commit();
//                }
            }
        });


        return view;
    }

}
