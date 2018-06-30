package com.example.administrator.immomo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.immomo.view.BottomBarLayout;
import com.example.administrator.immomo.view.TabEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomBarLayout bottomBarLayout;
    private List<TabEntity> tabEntityList;
    private String[] tabText = {"首页","社区","聊hi","我的"};

    private int[] normalIcon = {R.mipmap.ic_main_bottom_home,R.mipmap.ic_main_bottom_community,R.mipmap.ic_main_bottom_chatroom,R.mipmap.ic_main_bottom_user};
    private int[] selectIcon = {R.mipmap.ic_main_bottom_home_select,R.mipmap.ic_main_bottom_community_select,R.mipmap.ic_main_bottom_chatroom_select,R.mipmap.ic_main_bottom_user_select};

    private int normalTextColor = Color.parseColor("#000000");
    private int selectTextColor = Color.parseColor("#f4ea2a");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBarLayout = (BottomBarLayout) findViewById(R.id.bottom_nav);
        tabEntityList = new ArrayList<>();
        for (int i=0;i<tabText.length;i++){
            TabEntity item = new TabEntity();
            item.setText(tabText[i]);
            item.setNormalIconId(normalIcon[i]);
            item.setSelectIconId(selectIcon[i]);
            if(i==2 || i==3){
                item.setShowPoint(true);
            }else{
                item.setShowPoint(false);
            }
            if(i==0 || i==1){
                item.setNewsCount(i+1);
            }else {
                item.setNewsCount(0);
            }
            tabEntityList.add(item);
        }

        bottomBarLayout.setNormalTextColor(normalTextColor);
        bottomBarLayout.setSelectTextColor(selectTextColor);
        bottomBarLayout.setTabList(tabEntityList);

        bottomBarLayout.setOnItemClickListener(new BottomBarLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
