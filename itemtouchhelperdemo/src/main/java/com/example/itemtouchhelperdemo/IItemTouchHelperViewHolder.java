package com.example.itemtouchhelperdemo;

/**
 * Created by Administrator on 2018/2/11 0011.
 */

public interface IItemTouchHelperViewHolder {
    /**
     * item被选中,在侧滑或拖拽过程中更新状态
     */
    void onItemSelected();

    /**
     * item 的拖拽或侧滑结束,恢复默认的状态
     */
    void onItemClear();
}
