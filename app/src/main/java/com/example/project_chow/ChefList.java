package com.example.project_chow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.project_chow.Interface.ItemClickListener;
import com.example.project_chow.Model.Chef;
import com.example.project_chow.ViewHolder.ChefViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class ChefList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference chefList;

    String categoryId="";

    FirebaseRecyclerAdapter<Chef, ChefViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_list);

        //Firebase
        database = FirebaseDatabase.getInstance();
        chefList = database.getReference("Chef");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_chef);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if(!categoryId.isEmpty() && categoryId != null )
        {
            loadListChef(categoryId);
        }
    }

    private void loadListChef(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Chef, ChefViewHolder>(Chef.class,
                R.layout.chef_item,
                ChefViewHolder.class,
                chefList.orderByChild("MenuId").equalTo(categoryId)
        ) {
            @Override
            protected void populateViewHolder(ChefViewHolder viewHolder, Chef model, int position) {
                viewHolder.chef_name.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.chef_image);

                final Chef local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        //Start new activity
                        Intent foodList = new Intent (ChefList.this, FoodList.class);
                        foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                        startActivity(foodList);

                    }
                });
            }
        };

        recyclerView.setAdapter(adapter);
    }
}
