package com.example.itemtouchhelperdemo;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Administrator on 2018/2/11 0011.
 */

public interface OnStartDragListener {
    /**
     * 当View 需要拖拽时回调
     */
    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
