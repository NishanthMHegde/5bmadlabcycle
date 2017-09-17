package com.nishanth.asynctask;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nishanth on 03-09-2017.
 */

public class fetchData extends AsyncTask<Void,Void,Void>{
     String line ="";
    String data = "";
    String lineparsedData = "";
    String parsedData = "";
    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL("https://sample-test-rest-api.herokuapp.com/storyapi/story");
            HttpURLConnection hurl = (HttpURLConnection)url.openConnection();
            InputStream input = hurl.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            while(line!=null){
                line = br.readLine();
                data+=line;
            }
            JSONArray JA = new JSONArray(data);
            for(int i=0;i<JA.length();i++){
                JSONObject jo = (JSONObject)JA.get(i);
                JSONArray JB = jo.getJSONArray("creator");
                JSONObject creator = (JSONObject)JB.get(0);
                lineparsedData= jo.get("title")+"\n" + creator.get("name") + "\n";
                parsedData = parsedData +lineparsedData;

            }
            return null;
        }
        catch(MalformedURLException e){

        }
        catch(IOException e){

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.txt.setText(parsedData);
    }
}
