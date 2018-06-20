package com.example.dev7.wew;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.dev7.wew.main_fragment.Loker;

public class Final extends AppCompatActivity {
//    Button btnLihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//    btnLihat = (Button)findViewById(R.id.BtnLihat);

//    btnLihat.setOnClickListener(new View.OnClickListener() {
//
//        @Override
//        public void onClick(View view) {
//            startActivity(new Intent(Final.this , Loker.class));
//        }
//    });

    }

    public void lihat(View view){
        startActivity(new Intent(Final.this,MainActivity.class));
    }

}
