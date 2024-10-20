package com.example.app2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.Adapter.CategoryAdapter;
import com.example.app2.Adapter.PopularAdapter;
import com.example.app2.Domain.CategoryDomain;
import com.example.app2.Domain.FoodDomain;
import com.example.app2.FragmentBlank.CommentFragment;
import com.example.app2.FragmentBlank.HeartFragment;
import com.example.app2.FragmentBlank.HomeFragment;
import com.example.app2.FragmentBlank.UserFragment;
import com.example.app2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PopularAdapter popularAdapter;
    private RecyclerView.Adapter adapter2, adapter;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.menuHome) {
                replaceFragment(new HomeFragment());
            } else if (itemId == R.id.menuUser) {
                replaceFragment(new UserFragment());
            } else if (itemId == R.id.menuComment) {
                replaceFragment(new CommentFragment());
            } else if (itemId == R.id.menuHeart) {
                replaceFragment(new HeartFragment());
            }
            return true;
        });

        recyclerViewCategory();
        recyclerViewPopular();

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerViewCategory);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("All"));
        category.add(new CategoryDomain("Combos"));
        category.add(new CategoryDomain("Sliders"));
        category.add(new CategoryDomain("Classic"));

        adapter2 = new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter2);

    }
    private void recyclerViewPopular() {
        recyclerViewPopularList = findViewById(R.id.recycleViewPopular);
        popularAdapter = new PopularAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewPopularList.setLayoutManager(gridLayoutManager);

        popularAdapter.setData(getListPopular());
        recyclerViewPopularList.setAdapter(popularAdapter);
    }

    private ArrayList<FoodDomain> getListPopular() {
        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("image_6", "Cheeseburger", "Wendy's Burger", 4.9, "bla bla bla bla bla bla bla bla bla", 8.24, 26));
        foodList.add(new FoodDomain("image_5", "Hamburger", "Veggie Burger", 4.8, "bla bla bla bla bla bla bla bla bla", 9.99, 14));
        foodList.add(new FoodDomain("image_4", "Hamburger", "Chicken Burger", 4.6, "bla bla bla bla bla bla bla bla bla", 12.48, 42));
        foodList.add(new FoodDomain("image_3", "Hamburger", "Fried Chicken Burger", 4.5, "bla bla bla bla bla bla bla bla bla", 26.99, 14));
        return foodList;
    }
    /*
    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularList = findViewById(R.id.recycleViewPopular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("image_6", "Cheeseburger", "Wendy's Burger", 4.9));
        foodList.add(new FoodDomain("image_5", "Hamburger", "Veggie Burger", 4.8));
        foodList.add(new FoodDomain("image_4", "Hamburger", "Chicken Burger", 4.6));
        foodList.add(new FoodDomain("image_3", "Hamburger", "Fried Chicken Burger", 4.5));

        adapter = new PopularAdapter(foodList);
        recyclerViewCategoryList.setAdapter(adapter);
    }*/
}