package com.zhy.view.flowlayout;

import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class TagAdapter<T> {
    private List<T> mTagDatas;
    private OnDataChangedListener mOnDataChangedListener;
    private HashSet<Integer> mCheckedPosList = new HashSet<Integer>();

    public TagAdapter() {

    }

    public TagAdapter(List<T> datas) {
        if (datas != null)
            mTagDatas = datas;
    }

    public TagAdapter(T[] datas) {
        if (datas != null)
            mTagDatas = new ArrayList<T>(Arrays.asList(datas));
    }


    public void addRange(List<T> data) {
        if (mTagDatas == null)
            mTagDatas = data;
        else
            mTagDatas.addAll(data);
        notifyDataChanged();
    }

    public void refresh(List<T> data) {
        if (mTagDatas == null) {
            mTagDatas = data;
        } else {
            mTagDatas.clear();
            mTagDatas.addAll(data);
        }
        notifyDataChanged();
    }

    public void insert(T t) {
        if (mTagDatas == null)
            mTagDatas = new ArrayList<>();
        mTagDatas.add(t);
        notifyDataChanged();
    }

    public void remove(int position) {
        if (mTagDatas == null) return;
        if (mTagDatas.size() <= position) return;
        mTagDatas.remove(position);
        notifyDataChanged();
    }

    interface OnDataChangedListener {
        void onChanged();
    }

    void setOnDataChangedListener(OnDataChangedListener listener) {
        mOnDataChangedListener = listener;
    }

    public void setSelectedList(int... poses) {
        Set<Integer> set = new HashSet<>();
        for (int pos : poses) {
            set.add(pos);
        }
        setSelectedList(set);
    }

    public void setSelectedList(Set<Integer> set) {
        mCheckedPosList.clear();
        if (set != null)
            mCheckedPosList.addAll(set);
        notifyDataChanged();
    }

    HashSet<Integer> getPreCheckedList() {
        return mCheckedPosList;
    }


    public int getCount() {
        return mTagDatas == null ? 0 : mTagDatas.size();
    }

    public void notifyDataChanged() {
        if (mOnDataChangedListener != null)
            mOnDataChangedListener.onChanged();
    }

    public T getItem(int position) {
        return mTagDatas.get(position);
    }

    public abstract View getView(FlowLayout parent, int position, T t);

    public boolean setSelected(int position, T t) {
        return false;
    }


}