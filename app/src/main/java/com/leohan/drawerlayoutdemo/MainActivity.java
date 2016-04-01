package com.leohan.drawerlayoutdemo;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tv_search)
    TextView tvSearch;
    @InjectView(R.id.listView)
    ListView listView;
    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private List data = new ArrayList();
    private ShipRecordAdapter adapter = new ShipRecordAdapter(this, data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setSupportActionBar(toolbar);
        listView.setAdapter(adapter);
        getData();
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 获取类别数据
     */
    private void getData() {
        for (int i = 0; i < 6; i++) {
            Map<String, Object> map = new HashMap<>();
            data.add(map);
        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.tv_search)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search:
                if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    drawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    drawerLayout.openDrawer(Gravity.RIGHT);
                }
                break;
        }
    }
}
