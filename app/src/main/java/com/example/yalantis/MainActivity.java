package com.example.yalantis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
//[Comment] Wrong top padding
public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RVAdapter mRVAdapter;
    private String[] mImagesUrl = new String[]{
            "http://cs631918.vk.me/v631918154/209f5/BYy_UV61w1Y.jpg",
            "http://cs631918.vk.me/v631918154/209fd/W4aSGtYMzY0.jpg",
            "http://cs631918.vk.me/v631918154/20a05/IPWdyY46MMg.jpg"
    }; //[Comment] It should be constant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRVAdapter = new RVAdapter(this, mImagesUrl);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mRVAdapter);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(MainActivity.this, getResources().getResourceEntryName(item.getItemId()),
                    Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void toastShow(View view) {
        Toast.makeText(MainActivity.this, getResources().getResourceEntryName(view.getId()),
                Toast.LENGTH_SHORT).show();
    }
}

