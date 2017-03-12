package com.example.vipul.goingplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;

public class SearchOptionsActivity extends AppCompatActivity {

    private String types[] = {"Airport","Amusement park","ATM","Bakery","Bank","Beauty Salon","Cafe","Clothing Store","Doctor"
                                ,"Fire Station","Gas Station","Gym","Temple","Hospital","Library","Meal Delivery","Meal Takeaway","Mosque"
                                ,"Movie Theater","Museum","Night Club","Pharmacy","Police","Post Office","Restaurant","School","Shopping Mall"
                                ,"Spa","Train Station"};
    public static String searchTypes[] = {"airport","amusement_park","atm","bakery","bank","beauty_salon","cafe","clothing_store","doctor"
                                    ,"fire_station","gas_station","gym","temple","hospital","library","meal_delivery","meal_takeaway","mosque"
                                    ,"movie_theater","museum","night_club","pharmacy","police","post_office","restaurant","school","shopping_mall"
                                    ,"spa","train_station"};
    private int images[] = {R.drawable.airport,R.drawable.amusement_park,R.drawable.atm,R.drawable.bakery,R.drawable.bank
                            ,R.drawable.beauty_salon,R.drawable.cafe,R.drawable.clothing_store,R.drawable.doctor,R.drawable.fire_station
                            ,R.drawable.gas_station,R.drawable.gym,R.drawable.temple,R.drawable.hospital,R.drawable.library,R.drawable.meal_delivery
                            ,R.drawable.meal_takeaway,R.drawable.mosque,R.drawable.movie_theater,R.drawable.museum,R.drawable.night_club
                            ,R.drawable.pharmacy,R.drawable.police,R.drawable.post_office,R.drawable.restaurant,R.drawable.school
                            ,R.drawable.shopping_mall,R.drawable.spa,R.drawable.train_station};
    public static ArrayList<String> searchPlaces = new ArrayList<>();
    private GridView searchGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_options);
        searchGrid = (GridView)findViewById(R.id.search_options_grid_view);
        searchGrid.setVerticalSpacing(5);
        ArrayList<String> list = new ArrayList<>();
        searchGrid.setVerticalSpacing(GridView.AUTO_FIT);
        Collections.addAll(list, types);
        ArrayList<Integer> imageList = new ArrayList<>();
        for (int image : images) imageList.add(image);
        GridAdapter adapter = new GridAdapter(SearchOptionsActivity.this,R.layout.grid_view_layout,list,imageList);
        searchGrid.setAdapter(adapter);

        searchGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkbox);
                if(!checkBox.isChecked()){
                    checkBox.setChecked(true);
                    searchPlaces.add(searchTypes[position]);
                }
                else{
                    checkBox.setChecked(false);
                    searchPlaces.remove(searchPlaces.indexOf(searchTypes[position]));
                }
            }
        });
    }

    public void startSearch(View v){
        Intent i = new Intent(this,SearchPlacesActivity.class);
        i.putExtra(SearchPlacesActivity.SEARCH_PLACES,searchPlaces);
        startActivity(i);
    }
}
