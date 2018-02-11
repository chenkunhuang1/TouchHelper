package com.example.itemtouchhelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnStartDragListener{
    private List<ItemEntity> mList;
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        RecyclerView recyclerview = findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mList,this);
        adapter.setOnClickSwitchListener(new RecyclerViewAdapter.OnClickSwitchListener() {
            @Override
            public void onClick(int position, boolean isChecked) {

            }
        });
        recyclerview.setAdapter(adapter);
        mItemTouchHelper = new ItemTouchHelper(new MyItemTouchHelperCallback(adapter));
        mItemTouchHelper.attachToRecyclerView(recyclerview);
    }

    private void initData() {
        mList = new ArrayList<>();
        String[] strings = {
                "Android","后端","IOS","人工智能","产品","工具资源","阅读","设计"
        };
        for (String string:strings) {
            ItemEntity item = new ItemEntity();
            item.setChecked(false);
            item.setText(string);
            mList.add(item);
        }
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
