package com.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class Items extends Fragment implements Serializable {
    int v;


    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(v,container,false);          //关联布局文件

        return view;
    }
}
