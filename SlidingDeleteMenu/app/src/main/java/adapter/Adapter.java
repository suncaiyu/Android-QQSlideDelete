package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mingrisoft.slidingdeletemenu.R;

import java.util.ArrayList;
import java.util.List;

    import utils.Utils;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

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
    private Context lContext;   //上下文

    //图标集合
    private List<Integer> listIcon = new ArrayList<Integer>();
    //名称集合
    private List<Integer> listName = new ArrayList<Integer>();
    //信息集合
    private List<Integer> listInfo = new ArrayList<Integer>();

    public Adapter(Context context) {

        lContext = context;
        //设置菜单行数与行内图标、名称、信息
        for (int i = 0; i < 11; i++) {
            listIcon.add(icons[i]);
            listName.add(names[i]);
            listInfo.add(infos[i]);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(lContext).inflate(R.layout.layout_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);           //
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Adapter.MyViewHolder holder, int position) {
        //设置图标
        holder.img.setBackgroundResource(listIcon.get(position));
        //设置名称
        holder.name.setText(listName.get(position));
        //设置信息
        holder.info.setText(listInfo.get(position));
        //设置内容布局的宽为屏幕宽度
        holder.layout_content.getLayoutParams().width = Utils.getScreenWidth(lContext);

        //删除按钮的事件，单击后删除整行
        holder.btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = holder.getLayoutPosition();     //获取要删除行的位置
                removeData(n);                          //删除列表中的子项
            }
        });
    }


    @Override
    public int getItemCount() {
        return listIcon.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView btn_Delete;             //删除按钮
        public TextView name, info;               //编号文字
        public ImageView img;                   //图标
        public ViewGroup layout_content;       //图标与编号的布局

        //获取相关控件
        public MyViewHolder(View itemView) {
            super(itemView);
            btn_Delete = (TextView) itemView.findViewById(R.id.tv_delete);
            name = (TextView) itemView.findViewById(R.id.name);
            info = (TextView) itemView.findViewById(R.id.info);
            img = (ImageView) itemView.findViewById(R.id.img);
            layout_content = (ViewGroup) itemView.findViewById(R.id.layout_content);
        }
    }

    /**
     * 删除列表中子项
     */
    public void removeData(int position) {
        listIcon.remove(position);   //删除子项中显示图标
        listName.remove(position);   //删除名字
        listInfo.remove(position);   //删除信息
        notifyItemRemoved(position);    //删除列表

    }
}
