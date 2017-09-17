package com.nishanth.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button get,post;
   public static TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get = (Button)findViewById(R.id.button);
        post = (Button)findViewById(R.id.button2);
        txt = (TextView)findViewById(R.id.textView);
         get.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 fetchData fd = new fetchData();
                 fd.execute();
             }
         });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             postData pd = new postData();
                pd.execute();
            }
        });
    }
}
