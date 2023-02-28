package com.example.jobcombat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jobcombat.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("", "Bangla" , "https://cdn2.iconfinder.com/data/icons/ad-network-icon-line-fill-set-1/100/bangla-512.png"));
        categories.add(new CategoryModel("", "English" , "https://cdn-icons-png.flaticon.com/128/5388/5388630.png"));
        categories.add(new CategoryModel("", "Mathmatics" , "https://cdn-icons-png.flaticon.com/128/1739/1739515.png"));
        categories.add(new CategoryModel("", "Science" , "https://cdn-icons-png.flaticon.com/128/2941/2941552.png"));
        categories.add(new CategoryModel("", "Mental Ability" , "https://cdn-icons-png.flaticon.com/128/1783/1783447.png"));
        categories.add(new CategoryModel("", "General Knowledge" , "https://cdn-icons-png.flaticon.com/128/8132/8132334.png"));
        categories.add(new CategoryModel("", "Computer" , "https://cdn-icons-png.flaticon.com/128/2933/2933245.png"));
        categories.add(new CategoryModel("", "Geography" , "https://cdn-icons-png.flaticon.com/128/7282/7282816.png"));
        categories.add(new CategoryModel("", "Bangladeh" , "https://cdn-icons-png.flaticon.com/128/5399/5399812.png"));
        categories.add(new CategoryModel("", "Ethics and good governance" , "https://cdn-icons-png.flaticon.com/128/6203/6203283.png"));

        CategoryAdapter adapter = new CategoryAdapter(this, categories);
        binding.categoryList.setLayoutManager(new GridLayoutManager(this, 2));
        binding.categoryList.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.wallet){
            Toast.makeText(this, "Wallet is clicked.", Toast.LENGTH_SHORT ).show();
        }
        return super.onOptionsItemSelected(item);
    }
}