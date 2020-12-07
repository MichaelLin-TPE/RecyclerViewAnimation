package com.example.recyclerviewanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ButtonAnimationActivity extends AppCompatActivity {

    private int buttonIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animation);
        final LinearLayout resultLayout = findViewById(R.id.result_layout);
        final Button btnAdd,btnRemove,btnNext;

        btnAdd = findViewById(R.id.btn_add);
        btnRemove = findViewById(R.id.btn_remove);
        btnNext = findViewById(R.id.btn_next);
        final ArrayList<Button> buttonArray = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = new Button(ButtonAnimationActivity.this);

                button.setText("Button "+buttonIndex);
                buttonArray.add(button);
                resultLayout.addView(button);

                buttonIndex ++;
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultLayout.removeView(buttonArray.get(buttonIndex-1));
                buttonIndex --;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ButtonAnimationActivity.this, RecyclerViewClickAnimationActivity.class));
            }
        });
    }
}