package com.leohan.drawerlayoutdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * 船况纪录
 * @author Leo
 */
public class ShipRecordAdapter extends ListBaseAdapter {

    private ViewHolder vh;

    public ShipRecordAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public View getRealView(int position, View convertView, ViewGroup parent) {
        // 判断当前条目是否为null
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_ship_record, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        //绑定数据
        bindData(vh, position);
        return convertView;
    }


    private void bindData(ViewHolder vh, int position) {

        /* Map<String, Object> map = data.get(position);
        String content = map.get("content").toString();
        vh.textView.setText(name);*/

    }

    static class ViewHolder {

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

}