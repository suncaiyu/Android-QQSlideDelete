package com.mingrisoft.slidingdeletemenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import adapter.Adapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lRecyclerView;     //列表控件
    private Adapter lAdapter;                //适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();             //初始化控件
        setAdapter();           //设置适配器

    }

    /**
     * 初始化控件方法
     */
    private void initView(){
        //获取列表控件
        lRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    /**
     * 设置适配器方法
     */
    private void setAdapter(){
        //设置列表布局管理
        lRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        lRecyclerView.setAdapter(lAdapter = new Adapter(this));
        //设置列表中子项的动画
        lRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }

}
