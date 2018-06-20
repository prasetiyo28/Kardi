package com.example.dev7.wew;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dev7.wew.config.server;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PertanyaanFix extends AppCompatActivity {

    private String json_result, link;
    private ListView list_pertanyaan;

    private ListView list_jawaban;

    SimpleAdapter simpleAdapter;

    ArrayList<HashMap<String, String>> pertanyaanes = new ArrayList<HashMap<String, String>>();
    ArrayList<HashMap<String, String>> jawabanes = new ArrayList<HashMap<String, String>>();

    public static String kategori = "1";
    //    Button selesai;
//    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan_fix);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pertanyaan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        lstPertanyaan =(ListView) findViewById(R.id.lstPertanyaan);
//
//        setPertanyaan();


        json_result = ""; link = "";

        list_pertanyaan    = (ListView) findViewById(R.id.list_pertanyaan);

        list_jawaban    = (ListView) findViewById(R.id.list_jawaban);

        if (kategori.equals("final")){
            startActivity(new Intent(PertanyaanFix.this,Final.class));
        }else{
            link = server.link + "per.php?id_kategori="+kategori;
            Log.d("Log link", link );
            AccessService();
        }

    }

    private class JsonReadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(params[0]);
            try {
                HttpResponse response = httpclient.execute(httppost);
                json_result = inputStreamToString(
                        response.getEntity().getContent()).toString();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(String result) {
            JsonResponses();
            JsonResponses2();
        }
    }

    private StringBuilder inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));

        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public void AccessService() {
        JsonReadTask task = new JsonReadTask();
        task.execute(new String[]{link});
    }

    public void JsonResponses() {

        try {
            JSONObject jsonResponse = new JSONObject(json_result);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("result2");

            for (int i = 0; i < jsonMainNode.length(); i++) {

                JSONObject jsonChildNode    = jsonMainNode.getJSONObject(i);
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("id_pertanyaan", jsonChildNode.optString("id_pertanyaan"));
                map.put("pertanyaan",    jsonChildNode.optString("pertanyaan"));
                pertanyaanes.add(map);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        simpleAdapter = new SimpleAdapter(this, pertanyaanes, R.layout.list_pertanyaan,
                new String[] {"pertanyaan"},
                new int[] {R.id.text_pertanyaan}){

        };



        list_pertanyaan.setAdapter(simpleAdapter);
//        list_pertanyaan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                String id_pertanyaan = ((TextView) view.findViewById(R.id.text_pertanyaan_id)).getText().toString();
//                String pertanyaan = ((TextView) view.findViewById(R.id.text_pertanyaan)).getText().toString();
//                Log.d("Log id_pertanyaan", id_pertanyaan);
//
//                finish();
//            }
//        });
    }

    public void JsonResponses2() {

        try {
//            RadioGroup group = (RadioGroup) findViewById(R.id.GroupJawaban);

            JSONObject jsonResponse2 = new JSONObject(json_result);
            JSONArray jsonMainNode = jsonResponse2.optJSONArray("result");

            for (int i = 0; i < jsonMainNode.length(); i++) {

//                int jsonMainNod = jsonMainNode[i];
                JSONObject jsonChildNode    = jsonMainNode.getJSONObject(i);
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("value", jsonChildNode.optString("value"));
                map.put("jawaban", jsonChildNode.optString("jawaban"));
                jawabanes.add(map);

//                RadioButton button = new RadioButton(this);
//                button.setText(jsonChildNode + "jawaban");
//                group.addView(button);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        simpleAdapter = new SimpleAdapter(this, jawabanes, R.layout.list_jawaban,
                new String[] { "value" , "jawaban"},
                new int[] { R.id.id_jawaban, R.id.txtjawaban }){

        };

        list_jawaban.setAdapter(simpleAdapter);
        list_jawaban.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                            RadioGroup rdr = (RadioGroup) findViewById(R.id.GroupJawaban);
//
//                String id_jawaban = ((TextView) view.findViewById(R.id.text_pertanyaan_id)).getText().toString();
//                                RadioButton rdbtn = new RadioButton(this);
//                rdr.addView(rdbtn);
//                rdbtn.setId(i);
                String jawaban = ((TextView)findViewById(R.id.id_jawaban)).getText().toString();
//                Log.d("Log id_pertanyaan", jawaban);
                kategori = jawaban;
                startActivity(new Intent(PertanyaanFix.this,PertanyaanFix.class));

//                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

//    private void setPertanyaan(){
//
//        for (int i= 0; i<=3; i++){
//            HashMap<String, String> map = new HashMap<>();
//            map.put("Kategori", "Kategori - " + String.valueOf(i));
//            arrayList.add(map);
//        }
//
//        simpleAdapter = new SimpleAdapter(getApplicationContext(), arrayList, R.layout.adapter_pertanyaan,
//                new String[] {"Kategori"},
//                new int[] {R.id.txtJawaban });
//        lstPertanyaan.setAdapter(simpleAdapter);
//        lstPertanyaan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String Kategori = ((TextView)view.findViewById(R.id.txtJawaban)).getText().toString();
//                Toast.makeText(getApplicationContext(), "Ya", Toast.LENGTH_SHORT).show();
////
//////                kie nggo pindah aring sliding tab, tab beranda kue 0 nek
//////                tab merek kui 1 begitu seterusnya
////
//            }
//        });
//    }

}
