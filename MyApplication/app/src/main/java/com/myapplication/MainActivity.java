package com.myapplication;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    int mposition;
    boolean isfollow=true;
    List<Fragment> list = new LinkedList();
    List<Object> list1=new ArrayList();
    RecyclerviewAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Items it0=new Items();
        Items it1=new Items();
        Items it2 =new Items();
        Items it3=new Items();
        Items it4=new Items();
        Items it5=new Items();
        it0.setV(R.layout.item_viewpage);
        it1.setV(R.layout.item_xiaomi);
        it2.setV(R.layout.item_huawei);
        it3.setV(R.layout.item_apple);
        it4.setV(R.layout.item_oppo);
        it5.setV(R.layout.item_vivo);
        list.add(it0);
        list.add(it1);
        list.add(it2);
        list.add(it3);
        list.add(it4);
        list.add(it5);

        Data all=new Data("ALL",R.drawable.all,"粉丝数：0");
        Data xm=new Data("XIAOMI",R.drawable.xiaomi,"粉丝数：1500");
        Data hw=new Data("HUAWEI",R.drawable.huawei,"粉丝数：1560");
        Data ap=new Data("APPLE",R.drawable.apple,"粉丝数：1600");
        Data op=new Data("OPPO",R.drawable.oppo,"粉丝数：1230");
        Data vi=new Data("VIVO",R.drawable.vivo,"粉丝数：1350");
        list1.add(all);
        list1.add(xm);
        list1.add(hw);
        list1.add(ap);
        list1.add(op);
        list1.add(vi);

        todo();

    }

    public void todo() {
        ViewPager2 viewpage=findViewById(R.id.viewpager2);
        viewpage.setOffscreenPageLimit(list.size() - 1);
        MyFragmentStateAdapter adapter=new MyFragmentStateAdapter(MainActivity.this,list){
            @Override
            public Fragment createFragment(int position) {
                return (Fragment) list.get(position);
            }
        };
        viewpage.setAdapter(adapter);

        RecyclerView mRecyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        myAdapter=new RecyclerviewAdapter(MainActivity.this,list1);
        mRecyclerView.setAdapter(myAdapter);
        mRecyclerView.setLayoutManager(layoutManager);
        RecyclerviewAdapter.OnItemClickListener recyc= new RecyclerviewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                viewpage.setCurrentItem(position,true);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                if(position!=0) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) list);
                    bundle.putSerializable("list1", (Serializable) list1);
                    bundle.putInt("p", position);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, 1);
                }
            }

        };
        myAdapter.setOnItemClickListener(recyc);
        if(isfollow==false){
            myAdapter.notifyDataSetChanged();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();
        mposition=bundle.getInt("pback");
        isfollow=bundle.getBoolean("follow");
        if(isfollow==false){
            list1.remove(mposition);
            myAdapter.notifyDataSetChanged();

        }
    }

}