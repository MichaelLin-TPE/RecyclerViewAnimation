package com.example.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewClickAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_click_animation);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.addItemDecoration(new SpacesItemDecoration(3,DpConvertTool.getInstance().getDp(10),true));

        ArrayList<AnimationData> dataArray = new ArrayList<>();
        dataArray.add(new AnimationData("https://i.imgur.com/Fy2kFNo.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/uqvHfCS.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/FfL00Qy.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/utMmDlz.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/Xz6rclT.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/IgCgLL0.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/quY91m9.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/Io9zLND.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/jdh2t94.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/nnCeOLw.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/HkUMPHb.jpg","山岳"));
        dataArray.add(new AnimationData("https://i.imgur.com/CBVoS7z.jpg","山岳"));

        AnimationAdapter animationAdapter = new AnimationAdapter();
        animationAdapter.setDataArray(dataArray);
        recyclerView.setAdapter(animationAdapter);

        animationAdapter.setOnItemClickListener(new AnimationAdapter.OnItemClickListener() {
            @Override
            public void onClick(String url, String description, ImageView imageView, TextView textView) {
                Intent it = new Intent(RecyclerViewClickAnimationActivity.this,DetailActivity.class);
                it.putExtra("photo",url);
                it.putExtra("desc",description);
                //這裡是關鍵
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(RecyclerViewClickAnimationActivity.this
                        ,new Pair<View, String>(imageView,"photo"),new Pair<View, String>(textView,"desc"));
                startActivity(it,optionsCompat.toBundle());

            }
        });

    }
}