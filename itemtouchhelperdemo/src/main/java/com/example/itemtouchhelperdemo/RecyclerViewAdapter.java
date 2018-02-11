package com.example.itemtouchhelperdemo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2018/2/11 0011.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> implements IItemTouchHelperAdapter{
    private List<ItemEntity> mList;
    private OnStartDragListener mDragListener;

    public RecyclerViewAdapter(List<ItemEntity> list, OnStartDragListener dragListener) {
        mList = list;
        mDragListener = dragListener;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        holder.text.setText(mList.get(position).getText());
        holder.mSwitchCompat.setChecked(mList.get(position).isChecked());
        if (mOnClickSwitchListener != null){
            holder.mSwitchCompat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean b = mList.get(position).isChecked();
                    mList.get(position).setChecked(!b);
                    mOnClickSwitchListener.onClick(position,!b);
                }
            });
        }
        holder.menu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    mDragListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0:mList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);

    }

    @Override
    public void onItemDismiss(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements IItemTouchHelperViewHolder{
        private TextView text;
        private ImageView menu;
        private SwitchCompat mSwitchCompat;
        public ItemViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.item_list_text_textView);
            menu = itemView.findViewById(R.id.item_list_menu_imageView);
            mSwitchCompat = itemView.findViewById(R.id.item_list_switchCompat);
        }


        @Override

        public void onItemSelected() {
            itemView.setTranslationZ(10);
        }

        @Override

        public void onItemClear() {
            itemView.setTranslationZ(0);
        }
    }

    public void setOnClickSwitchListener(OnClickSwitchListener onClickSwitchListener) {
        mOnClickSwitchListener = onClickSwitchListener;
    }

    private OnClickSwitchListener mOnClickSwitchListener;
    public interface OnClickSwitchListener{
        void onClick(int position,boolean isChecked);
    }
}
