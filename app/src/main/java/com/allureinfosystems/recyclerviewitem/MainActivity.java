package com.allureinfosystems.recyclerviewitem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    String[] url = {
            "http://www.google.com",
            "http://www.amazon.com",
            "http://www.google.com",
            "http://www.amazon.com"};
    String[] countryName = {"INDIA","USA","UK","FRANCE"};
    private RecyclerView.Adapter DataAdapter;
    int [] flag = { R.drawable.india,R.drawable.usa,R.drawable.uk,R.drawable.france};
    static ArrayList<HashMap<String, String>> dataItem;
    HashMap<String, String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        dataItem = new ArrayList<>();

        for (int i = 0; i < countryName.length ; i++) {

            map = new HashMap<String, String>();
            map.put("CName", countryName[i]);
            map.put("Cflag", flag[i] + "");
            map.put("Curl",url[i]);
            dataItem.add(map);
        }
        DataAdapter = new mDataAdapter(getApplicationContext(),dataItem);
        recyclerView.setAdapter(DataAdapter);

    }
}



