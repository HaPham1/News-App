package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NEW1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NEW1Fragment extends Fragment implements RelatedRecyclerAdapter.OnRowClickListener {
    List<News> newsList = new ArrayList<>();
    RecyclerView relateRecyclerView;
    RelatedRecyclerAdapter relatedRecyclerAdapter;
    LinearLayoutManager layoutManager2;
    ImageView imageView;
    TextView titleView, desView;
    int position;
    int[] imageList;
    String[] titleList;
    String[] desList ;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NEW1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NEW1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NEW1Fragment newInstance(String param1, String param2) {
        NEW1Fragment fragment = new NEW1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_n_e_w1, container, false);

        imageView = view.findViewById(R.id.imageView);

        titleView = view.findViewById(R.id.titleView);
        desView = view.findViewById(R.id.desView);

        //Get information
        Bundle bundle = this.getArguments();
        imageList = bundle.getIntArray("imageList");
        titleList = bundle.getStringArray("titleList");
        desList = bundle.getStringArray("desList");
        position = bundle.getInt("position");

        //Set main
        imageView.setImageResource(imageList[position]);
        titleView.setText(titleList[position]);
        desView.setText(desList[position]);



        //RecyclerView for related
        relateRecyclerView = view.findViewById(R.id.verRecyclerView);
        relatedRecyclerAdapter = new RelatedRecyclerAdapter(newsList, view.getContext(), this);
        relateRecyclerView.setAdapter(relatedRecyclerAdapter);

        layoutManager2 = new LinearLayoutManager(view.getContext());
        relateRecyclerView.setLayoutManager(layoutManager2);
        layoutManager2.setOrientation(relateRecyclerView.VERTICAL);
        for(int i = 0; i < imageList.length; i++) {
            if (i != position) {
                News news = new News(imageList[i], i, titleList[i], desList[i]);
                newsList.add(news);
            }
        }



        return view;
    }

    //Change between related news, optional but okay
    @Override
    public void onItemClick(int position) {
        Fragment fragment = new DefaultFragment();
        News news = newsList.get(position);
        imageView.setImageResource(news.getImage());
        titleView.setText(news.getTitle());
        desView.setText(news.getDescription());
        for(int i = 0; i < imageList.length - 1; i++) {
            newsList.remove(0);
        }
        position = news.getId();
        for(int i = 0; i < imageList.length; i++) {
            if (i != position) {
                News news2 = new News(imageList[i], i, titleList[i], desList[i]);
                newsList.add(news2);
            }
        }
        relateRecyclerView.setAdapter(relatedRecyclerAdapter);
    }


}