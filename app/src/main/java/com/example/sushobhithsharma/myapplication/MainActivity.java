package com.example.sushobhithsharma.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private DataAdapter listAdapter;
    private List<DataItem> feedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void parseJsonFeed(JSONObject response) {
        try {
            JSONArray feedArray = response.getJSONArray("feed");

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                DataItem item = new DataItem();
                item.setName(feedObj.getString("name"));

                // Image might be null sometimes
                String image = feedObj.isNull("imageUrl") ? null : feedObj
                        .getString("imageUrl");
                item.setImage(image);

                item.setTitle(feedObj.getString("title"));
                item.setText(feedObj.getString("text"));
                item.setTimeStamp(feedObj.getString("time"));
                item.setDescription(feedObj.getString("description"));

                feedItems.add(item);
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
