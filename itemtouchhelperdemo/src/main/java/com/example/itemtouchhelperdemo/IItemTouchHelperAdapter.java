package com.example.itemtouchhelperdemo;

/**
 * Created by Administrator on 2018/2/11 0011.
 */

public interface IItemTouchHelperAdapter {
    /**
     * 当item被移动时调用
     * @param fromPosition
     * @param toPosition
     */
    void onItemMove(int fromPosition,int toPosition);

    /**
     * 当item被侧滑时调用
     * @param position
     */
    void onItemDismiss(int position);
}
