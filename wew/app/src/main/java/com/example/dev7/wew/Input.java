package com.example.dev7.wew;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev7.wew.config.daftar;

public class Input extends AppCompatActivity {

    EditText edit_umur;
    Spinner edit_lulusan, edit_bidang;

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSubmit = (Button)findViewById(R.id.kirim);

        edit_umur = (EditText)findViewById(R.id.edit_umur);
        edit_lulusan = (Spinner)findViewById(R.id.lulusan);
        edit_bidang = (Spinner)findViewById(R.id.bidang);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), Input.class);
//                startActivity(intent);


                new daftar(Input.this).execute(
                        edit_umur.getText().toString(), edit_lulusan.getSelectedItem().toString(),
                        edit_bidang.getSelectedItem().toString()


                );

                Toast.makeText(Input.this,
                        "Data Terkirim", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Input.this, PertanyaanFix.class);
                startActivity(i);



            }
        });

    }

}
