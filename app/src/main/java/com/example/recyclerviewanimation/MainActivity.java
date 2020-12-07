package com.example.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.addItemDecoration(new SpacesItemDecoration(4,DpConvertTool.getInstance().getDp(10),true));

        Button btnFadeIn,btnFadeInReverse,btnFadeInRandom,btnLeft,btnRotate,btnNext;


        btnFadeIn = findViewById(R.id.btn_fade_in);
        btnFadeInReverse = findViewById(R.id.btn_fade_in_reverse);
        btnFadeInRandom = findViewById(R.id.btn_fade_in_random);
        btnLeft = findViewById(R.id.btn_left);
        btnRotate = findViewById(R.id.btn_rotate);
        btnNext = findViewById(R.id.btn_next);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ButtonAnimationActivity.class));
            }
        });


        btnFadeIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_animation_fade_in));
                MyAdapter adapter = new MyAdapter();
                recyclerView.setAdapter(adapter);
            }
        });

        btnFadeInRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_animation_fade_in_random));
                MyAdapter adapter = new MyAdapter();
                recyclerView.setAdapter(adapter);
            }
        });

        btnFadeInReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_animation_fade_in_reverse));
                MyAdapter adapter = new MyAdapter();
                recyclerView.setAdapter(adapter);
            }
        });
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_animation_left));
                MyAdapter adapter = new MyAdapter();
                recyclerView.setAdapter(adapter);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this,R.anim.layout_animation_rotate));
                MyAdapter adapter = new MyAdapter();
                recyclerView.setAdapter(adapter);
            }
        });

    }
}