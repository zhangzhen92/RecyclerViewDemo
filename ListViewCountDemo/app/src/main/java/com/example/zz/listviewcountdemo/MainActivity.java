package com.example.zz.listviewcountdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zz.listviewcountdemo.apater.DataAdapter;
import com.example.zz.listviewcountdemo.bean.DataBean;
import com.example.zz.listviewcountdemo.utils.CustomLinerLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：测试类
 * 创建人：zz
 * 创建时间：2017/8/9 17:52
 */
public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private TextView textMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        textMore = ((TextView) findViewById(R.id.textview_more));
        recyclerView = ((RecyclerView) findViewById(R.id.recycler_id));
        final CustomLinerLayoutManager manager = new CustomLinerLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        manager.setScrollEnabled(false);
        recyclerView.setLayoutManager(manager);
        final List<DataBean> datas = new ArrayList<>();
        final DataBean dataBean1 = new DataBean("恭喜发财",0) ;
        DataBean dataBean2 = new DataBean("你已领取红包",1) ;
        DataBean dataBean3 = new DataBean("此红包已过期",2) ;
        DataBean dataBean4 = new DataBean("恭喜发财",0) ;
        DataBean dataBean5 = new DataBean("你已领取红包了",1) ;
        datas.add(dataBean1);
        datas.add(dataBean2);
        datas.add(dataBean3);
        datas.add(dataBean4);
        datas.add(dataBean5);
        adapter = new DataAdapter(datas,getApplicationContext());
        recyclerView.setAdapter(adapter);
        textMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.setScrollEnabled(true);
                recyclerView.setLayoutManager(manager);
            }
        });
        adapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(0 ==datas.get(position).getStatus()){
                    DataBean dataBean6 = datas.get(position);
                    dataBean6.setMoney("测试一下");
                    dataBean6.setStatus(1);
                    //如果指定了第二个参数Object payload，可在适配器onBindViewHolder中判断值，
                    // 从而刷新指定的控件，而不是整个item
                    adapter.notifyItemChanged(position);               //刷新指定条目的数据源
                }
            }
        });
    }

}
