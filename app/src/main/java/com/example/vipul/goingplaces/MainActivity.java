package com.example.vipul.goingplaces;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void locateOnMap(View v){
        startActivity(new Intent(this,LocationMapsActivity.class));
    }

    public void searchPlaces(View v){
        startActivity(new Intent(this,SearchOptionsActivity.class));
    }


}
