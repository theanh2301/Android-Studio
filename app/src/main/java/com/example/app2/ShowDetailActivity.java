package com.example.app2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.app2.Domain.FoodDomain;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView orderBtn;
    private TextView name, type, description, numberOrder, rate, fee, mins;
    private ImageView plusBtn, minusBtn, pic;
    private FoodDomain object;
    int numOrder = 1;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.viewholder_show_detail);

        initView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());

        Glide.with(this).load(drawableResourceId).into(pic);

        name.setText(object.getName());
        type.setText(object.getType());
        description.setText(object.getDescription());
        fee.setText("$" + object.getFee());
        rate.setText("" + object.getRate());
        numberOrder.setText(String.valueOf(numberOrder));
        mins.setText(object.getMins() + " mins");

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numOrder = numOrder + 1;
                numberOrder.setText(String.valueOf(numOrder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numOrder > 1) {
                    numOrder = numOrder - 1;
                }
                numberOrder.setText(String.valueOf(numOrder));
            }
        });
    }

    private void initView() {
        name = findViewById(R.id.nameTxt);
        type = findViewById(R.id.typeTxt);
        description = findViewById(R.id.descriptionTxt);
        rate = findViewById(R.id.rateTxt);
        fee = findViewById(R.id.feeTxt);
        mins = findViewById(R.id.minsTxt);
        numberOrder = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.phusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        pic = findViewById(R.id.pic);
    }
}
