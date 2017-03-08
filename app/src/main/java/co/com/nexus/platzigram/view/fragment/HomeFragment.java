package co.com.nexus.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.nexus.platzigram.R;
import co.com.nexus.platzigram.adapter.PictureAdapterRecyclerView;
import co.com.nexus.platzigram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home), false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buidPictures() {
        ArrayList<Picture> pictures = new ArrayList<Picture>();
        pictures.add(new Picture("https://cdn.pixabay.com/photo/2015/12/08/00/49/snowy-mountains-1082085_960_720.jpg", "Martin Martinez", "4 días", "3"));
        pictures.add(new Picture("https://cdn.pixabay.com/photo/2015/10/16/23/53/gunsmith-992036_960_720.jpg", "Rodrigo Rodirguez", "4 días", "3"));
        pictures.add(new Picture("https://cdn.pixabay.com/photo/2013/10/27/19/25/mountain-201525_960_720.jpg", "Luis Lopez", "4 días", "3"));
        pictures.add(new Picture("https://cdn.pixabay.com/photo/2012/10/24/04/48/sky-62732_960_720.jpg", "Rosa Rosales", "4 días", "3"));

        return pictures;
    }

    public void showToolbar(String title, boolean upButton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
