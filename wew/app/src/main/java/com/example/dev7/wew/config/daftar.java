package com.example.dev7.wew.config;

/**
 * Created by smartos on 07/05/18.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class daftar extends AsyncTask<String, Void, String> {
    private Context context;
    private String link = server.link;
    public daftar(Context context) {
        this.context = context;
    }

    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... arg0) {
//        String android_id   = arg0[0];
//        String nama  = arg0[1];
        String umur  = arg0[0];
        String lulusan = arg0[1];
        String bidang = arg0[2];
//        String skill = arg0[5];


        String data;
        BufferedReader bufferedReader;
        String result;
        try {
//            data = "?android_id=" + URLEncoder.encode(android_id, "UTF-8");
//            data += "&nama=" + URLEncoder.encode(nama, "UTF-8");
            data = "?umur=" + URLEncoder.encode(umur, "UTF-8");
            data += "&lulusan=" + URLEncoder.encode(lulusan, "UTF-8");
            data += "&bidang=" + URLEncoder.encode(bidang, "UTF-8");
//            data += "&skill=" + URLEncoder.encode(skill, "UTF-8");


            link = link + "insert.php" + data;

            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            result = bufferedReader.readLine();
            return result;
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        String jsonStr = result;
        Log.e("Url", link);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String response = jsonObj.getString("response");
                if (response.equals("success")) {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();

//                    ((Activity)(context)).finish();
                } else if (response.equals("failed")) {
                    Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                } else {
                    Log.d("Log error", "Couldn't connect to remote database.");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.d("Log error", "Couldn't get any JSON data.");
        }

    }


}
