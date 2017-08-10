package com.example.zz.listviewcountdemo.apater;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zz.listviewcountdemo.R;
import com.example.zz.listviewcountdemo.bean.DataBean;

import java.util.List;

/**
 * 类描述：适配器类
 * 创建人：zz
 * 创建时间： 2017/8/9 17:54
 */


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<DataBean> mDatas;
    private Context mContext;
    private OnItemClickListener mListener;

    public DataAdapter(List<DataBean> mDatas,Context context) {
        this.mDatas = mDatas;
        this.mContext = context;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
       if(0 == mDatas.get(position).getStatus()){
           holder.relativeBack.setBackgroundColor(Color.RED);
       }else if(1 == mDatas.get(position).getStatus()){
           holder.relativeBack.setBackgroundColor(Color.YELLOW);
       }else if(2 == mDatas.get(position).getStatus()){
           holder.relativeBack.setBackgroundColor(Color.GREEN);
       }
        holder.textCotent.setText(mDatas.get(position).getMoney());

        holder.relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout relativeBack;
        private TextView textCotent;

        public DataViewHolder(View itemView) {
            super(itemView);
            relativeBack = ((RelativeLayout) itemView.findViewById(R.id.relative_background));
            textCotent = ((TextView) itemView.findViewById(R.id.textview_content));
        }
    }



    public interface OnItemClickListener{
        public void onItemClick(View view,int position);

    }
}
