package com.example.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private ImageView imageView;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }
        String url = bundle.getString("photo","");
        String desc = bundle.getString("desc","");
        Log.i("Michael","url : "+url + " , desc : "+desc);


        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.desc);
        textView.setTransitionName("desc");
        imageView.setTransitionName("photo");

        loadData(url,desc);


    }

    private void loadData(String url, String desc) {
        textView.setText(desc);

        addTransitionListener(url);

        loadThumbnail(url);

    }

    private void addTransitionListener(final String url) {
        Transition transition = getWindow().getSharedElementEnterTransition();
        if (transition == null){
            return;
        }
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                loadThumbnail(url);
                transition.removeListener(this);
            }

            @Override
            public void onTransitionCancel(Transition transition) {
                transition.removeListener(this);
            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });

    }

    private void loadThumbnail(String url) {
        NewImageLoaderManager.getInstance(this).setPhotoUrl(url,imageView);
    }
}