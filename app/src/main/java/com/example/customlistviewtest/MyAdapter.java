package com.example.customlistviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    // 아이템을 세트로 담기 위한 어레이
    private ArrayList<MyItem> mItems = new ArrayList<>();

    // ListView에 보여질 Item 수
    @Override
    public int getCount() {
        return mItems.size();   // mItems의 사이즈 반환
    }

    // 하나의 Item(ImageView 하나, TextView 두개)
    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    // Item의 Id : Item을 구별하기 위한 것으로 position 사용.
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 실제로 item이 보여지는 부분
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_custom, null, false);

            holder = new CustomViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.iv_img);
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.contents = (TextView) convertView.findViewById(R.id.tv_contents);

            convertView.setTag(holder);
        } else {
            holder = (CustomViewHolder) convertView.getTag();
        }

        MyItem item = mItems.get(position);

        holder.icon.setImageResource(item.getResId());
        holder.name.setText(item.getName());
        holder.contents.setText(item.getContents());

        return convertView;
    }

    class CustomViewHolder {
        ImageView icon;
        TextView name;
        TextView contents;
    }

    // 아이템 데이터 추가를 위한 함수. 원하는대로 작성.
    public void addItem(MyItem mitem) {
        mItems.add(mitem);
    }
}
