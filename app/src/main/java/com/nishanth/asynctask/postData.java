package com.nishanth.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nishanth on 03-09-2017.
 */

public class postData extends AsyncTask<Void,Void,Void> {
    private static final String TAG = "POST ";
    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL("https://sample-test-rest-api.herokuapp.com/storyapi/person");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream());
            JSONObject jo = new JSONObject();
            jo.put("name","Sachin");
            jo.put("age",44);
            jo.put("title","Trillion Dreams ");
            Log.d(TAG, "doInBackground: " + jo.toString());
            dataOutputStream.writeBytes(jo.toString());

            dataOutputStream.close();
            int res = conn.getResponseCode();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
