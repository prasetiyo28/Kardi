package com.example.dev7.wew.main_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev7.wew.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Loker extends Fragment {

    ListView lstLoker;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    public Loker() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loker, container, false);

        lstLoker =(ListView)view.findViewById(R.id.lstLoker);

        setLoker();

        return view;

    }

    private void setLoker(){

        for (int i= 1; i<=1; i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("PT.KARYA ANAK BANGSA", "PT.KARYA ANAK BANGSA");
            arrayList.add(map);
        }

        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_loker,
                new String[] {"PT.KARYA ANAK BANGSA"},
                new int[] {R.id.txtIklan });
        lstLoker.setAdapter(simpleAdapter);
        lstLoker.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tittle = ((TextView)view.findViewById(R.id.txtIklan)).getText().toString();
                Toast.makeText(getActivity(), tittle, Toast.LENGTH_LONG).show();

//                kie nggo pindah aring sliding tab, tab beranda kue 0 nek
//                tab merek kui 1 begitu seterusnya

//                MainActivity.tabLayout.setupWithViewPager(MainActivity.viewPager);
//                MainActivity.viewPager.setCurrentItem(0);
            }
        });
    }

}
