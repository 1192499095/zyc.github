package com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    TextView name,fans;
    ImageView image;
    int position;
    Button bt;
    ImageButton ib;
    boolean isFollow=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name=findViewById(R.id.dname);
        fans=findViewById(R.id.dfans);
        image=findViewById(R.id.dimage);
        bt=findViewById(R.id.dbutton);
        ib=findViewById(R.id.imageButton);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position=bundle.getInt("p");
        List list = new LinkedList();
        List list1= new LinkedList();
        list= (List) bundle.getSerializable("list");
        list1= (List) bundle.getSerializable("list1");
        name.setText(((Data)list1.get(position)).getText());
        fans.setText(((Data)list1.get(position)).getFans());
        image.setImageResource(((Data)list1.get(position)).getImagesrc());
        Items its= (Items) list.get(position);
        getSupportFragmentManager().beginTransaction().add(R.id.dl,its).commitAllowingStateLoss();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this,"取关成功" , Toast.LENGTH_SHORT).show();
                isFollow=false;
            }
        });
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                Bundle bl=new Bundle();
                bl.putInt("pback",position);
                bl.putBoolean("follow",isFollow);
                intent2.putExtras(bl);
                setResult(Activity.RESULT_OK, intent2);
                finish();
            }
        });




    }
    @Override
    public void onBackPressed()
    {
        Intent intent1 = new Intent();
        Bundle bl=new Bundle();
        bl.putInt("pback",position);
        bl.putBoolean("follow",isFollow);
        intent1.putExtras(bl);
        setResult(Activity.RESULT_OK, intent1);
        finish();
    }
}