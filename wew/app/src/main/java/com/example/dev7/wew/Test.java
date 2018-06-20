package com.example.dev7.wew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Test extends AppCompatActivity {

    Button BtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        BtnSubmit = (Button)findViewById(R.id.BtnSubmit);
//
        BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getF(), "Anda telah Submit", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Test.this, PertanyaanFix.class));
            }
        });

    }
}
