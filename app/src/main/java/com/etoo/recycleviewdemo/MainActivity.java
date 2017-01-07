package com.etoo.recycleviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        datas = new ArrayList<>();
        initData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new BaseAdapter());

    }

    private void initData() {
        for (int i = 0; i< 100;i++){
            datas.add(i + "#");
        }
    }


    private class BaseAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.item, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tx.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tx;

        public MyViewHolder(View itemView) {
            super(itemView);
            tx = (TextView) itemView.findViewById(R.id.item_tx);
        }
    }

    private class DividerItemDecoration extends RecyclerView.ItemDecoration{
        private  final int [] ATTRS  = new int[]{android.R.attr.listDivider};
        private final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
        private final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
        private Drawable mDrawable;
        private int mOrientation;

        public DividerItemDecoration(Context context,int orientation){
            TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDrawable = a.getDrawable(0);
            a.recycle();

        }

        public void setOrientation(int orientation){
            if(orientation != HORIZONTAL_LIST || orientation != VERTICAL_LIST){
                throw new IllegalArgumentException("invalid orientation");
            }
            mOrientation = orientation;
        }

        public void drawVertical(Canvas canvas,RecyclerView parent){
            final int left = parent.getPaddingLeft();
            final int right = parent.getPaddingRight();

            final int childCount = parent.getChildCount();
            for(int i = 0;  i < childCount;i++){
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            }
        }
    }
}
