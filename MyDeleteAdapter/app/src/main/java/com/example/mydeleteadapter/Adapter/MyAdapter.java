package com.example.mydeleteadapter.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mydeleteadapter.R;
import com.example.mydeleteadapter.view.MyScrollView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private int btn_width;
    private View nowView = null;
    private View preView = null;


    //图标数组
    private int[] icons = {
            R.drawable.icon_1, R.drawable.icon_2, R.drawable.icon_3,
            R.drawable.icon_4, R.drawable.icon_5, R.drawable.icon_6,
            R.drawable.icon_7, R.drawable.icon_8, R.drawable.icon_9,
            R.drawable.icon_10, R.drawable.icon_11

    };
    //名字数组
    private int[] names = {
            R.string.name1, R.string.name2, R.string.name3,
            R.string.name4, R.string.name5, R.string.name6,
            R.string.name7, R.string.name8, R.string.name9,
            R.string.name10, R.string.name11


    };
    //信息数组
    private int[] infos = {
            R.string.info1, R.string.info2, R.string.info3,
            R.string.info4, R.string.info5, R.string.info6,
            R.string.info7, R.string.info8, R.string.info9,
            R.string.info10, R.string.info11

    };
    private List<Integer> iconlist = new ArrayList<Integer>();
    private List<Integer> namelist = new ArrayList<Integer>();
    private List<Integer> infolist = new ArrayList<Integer>();

    ViewHolder holder;
    public MyAdapter(Context context){
        mContext = context;
        for(int i =0;i<names.length;i++){
            namelist.add(names[i]);
            infolist.add(infos[i]);
            iconlist.add(icons[i]);
        }
    }
    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        holder = null;
        if(view == null){
            view = (View) LayoutInflater.from(mContext).inflate(R.layout.list_item, viewGroup,false);
            holder = new ViewHolder();
            holder.info = view.findViewById(R.id.Myinfo);
            holder.name = view.findViewById(R.id.name);
            holder.touxiang = view.findViewById(R.id.image_touxiang);
            holder.l = view.findViewById(R.id.context);
            holder.btn = view.findViewById(R.id.myDelete);
            holder.sv = view.findViewById(R.id.main_item_layout);
            WindowManager wm = (WindowManager) mContext
                    .getSystemService(Context.WINDOW_SERVICE);
            holder.l.getLayoutParams().width =wm.getDefaultDisplay().getWidth();
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        final View finalView = view;
        holder.sv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View vi, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    Log.i("Furrain","sss");
                    if(nowView == null){
                        preView = null;
                    }else{
                        preView = nowView;
                    }
                    if(nowView == vi){
                        return false;
                    }
                    nowView = vi;
                    autoHide();
                }
                return false;
            }
        });
        holder.btn.setTag(i);
        holder.touxiang.setImageResource(iconlist.get(i));
        holder.name.setText(namelist.get(i));
        holder.info.setText(infolist.get(i));
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = (int) v.getTag();
                namelist.remove(i);

                infolist.remove(i);
                iconlist.remove(i);
                notifyDataSetChanged();
            }
        });
        view.scrollTo(0,0);
        return view;
    }

    private void autoHide() {
        if(preView != null){
            MyScrollView v = (MyScrollView)preView;
            v.smoothScrollTo(0,0);
        }
    }

    class ViewHolder{
        TextView name;
        TextView info;
        ImageView touxiang;
        RelativeLayout l;
        Button btn;
        MyScrollView sv;
    }
}
