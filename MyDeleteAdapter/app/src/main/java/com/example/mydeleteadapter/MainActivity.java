package com.example.mydeleteadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mydeleteadapter.Adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.myListView);
        MyAdapter adapter = new MyAdapter(this);
        lv.setAdapter(adapter);
    }
}
