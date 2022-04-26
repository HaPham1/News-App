package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StoryRecyclerViewAdapter.OnRowClickListener, NewRecyclerAdapter.OnRowClickListener {
    RecyclerView storyRecyclerView, newRecyclerView;
    StoryRecyclerViewAdapter storyRecyclerViewAdapter;
    NewRecyclerAdapter newRecyclerAdapter;
    LinearLayoutManager layoutManager1;
    GridLayoutManager layoutManager2;
    List<Stories> storiesList = new ArrayList<>();
    List<News> newsList = new ArrayList<>();
    int[] imageList = {R.drawable.temp_image, R.drawable.temp_image,R.drawable.temp_image,R.drawable.temp_image, R.drawable.temp_image, R.drawable.temp_image};
    String[] titleList = {"1NEW", "2NEW","3NEW","4NEW","5NEW","6NEW"};
    String[] desList = {"This is 1NEW LALABLALALBALALBAL", "This is 2NEW LALABLALALBALALBAL",
            "This is 3NEW LALABLALALBALALBAL", "This is 4NEW LALABLALALBALALBAL",
            "This is 5NEW LALABLALALBALALBAL", "This is 6NEW LALABLALALBALALBAL",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up top stories recycle view
        storyRecyclerView = findViewById(R.id.storiesRecyclerView);
        storyRecyclerViewAdapter = new StoryRecyclerViewAdapter(storiesList, this, this);
        storyRecyclerView.setAdapter(storyRecyclerViewAdapter);

        layoutManager1 = new LinearLayoutManager(this);
        storyRecyclerView.setLayoutManager(layoutManager1);
        layoutManager1.setOrientation(storyRecyclerView.HORIZONTAL);
        for(int i = 0; i < imageList.length; i++) {
            Stories stories = new Stories(imageList[i], i);
            storiesList.add(stories);
        }

        // Set up News recycle view
        newRecyclerView = findViewById(R.id.newRecyclerView);
        newRecyclerAdapter = new NewRecyclerAdapter(newsList, this, this);
        newRecyclerView.setAdapter(newRecyclerAdapter);

        layoutManager2 = new GridLayoutManager(this, 2);
        newRecyclerView.setLayoutManager(layoutManager2);
        layoutManager2.setOrientation(newRecyclerView.HORIZONTAL);
        for(int i = 0; i < imageList.length; i++) {
            News news = new News(imageList[i], i, titleList[i], desList[i]);
            newsList.add(news);
        }





    }
    /*public void NextButton (View view) {
        storyRecyclerView.getLayoutManager().scrollToPosition(layoutManager1.findLastVisibleItemPosition() + 1);
    }
    public void PrevButton (View view) {
        storyRecyclerView.getLayoutManager().scrollToPosition(layoutManager1.findFirstVisibleItemPosition() - 1);
    }*/

    @Override
    public void onItemClick(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new NEW1Fragment();
                sendDatatoFragment(position, fragment);
                break;
            case 1:
                fragment = new NEW1Fragment();
                sendDatatoFragment(position, fragment);
                break;
            case 2:
                fragment = new NEW1Fragment();
                sendDatatoFragment(position, fragment);
                break;
            case 3:
                fragment = new NEW1Fragment();
                sendDatatoFragment(position, fragment);
                break;
            case 4:
                fragment = new NEW1Fragment();
                sendDatatoFragment(position, fragment);
                break;
            case 5:
                fragment = new NEW1Fragment();
                sendDatatoFragment(position, fragment);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);

        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment, "reset")
        .addToBackStack("reset").commit();

    }

    public void sendDatatoFragment(int i, Fragment fragment) {
        //Send information
        Bundle bundle = new Bundle();
        bundle.putIntArray("imageList", imageList);
        bundle.putStringArray("titleList", titleList);
        bundle.putStringArray("desList", desList);
        bundle.putInt("position", i);


        fragment.setArguments(bundle);
    }
}