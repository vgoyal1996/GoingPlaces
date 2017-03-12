package com.example.vipul.goingplaces;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SearchPlacesActivity extends FragmentActivity implements OnMapReadyCallback {
    public static final String SEARCH_PLACES = "places";
    private GoogleMap mMap;
    private ArrayList<String> searchPlaces;
    private AlertDialogManager alert = new AlertDialogManager();
    private LatLng ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_places);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        searchPlaces = (ArrayList<String>)getIntent().getExtras().get(SEARCH_PLACES);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        new DisplayPlacesTask().execute();
    }

    public class DisplayPlacesTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            HttpURLConnection connection;
            try{
                StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                sb.append("types=");
                for(String e : searchPlaces) {
                    sb.append(e);
                    if(!searchPlaces.get(searchPlaces.size()-1).equals(e))
                        sb.append("|");
                }
                sb.append("&location=");
                sb.append(ll.latitude).append(ll.longitude);
                sb.append("&radius=500");
                sb.append("&sensor=true");
                sb.append("&key=AIzaSyDH9nStmLFBOVztvafh-9aE2oUHL3alUok");
                URL url = new URL(sb.toString());
                connection = (HttpURLConnection)url.openConnection();
                GsonBuilder gBuilder = new GsonBuilder();
                Gson gson = gBuilder.create();

                if(connection.getResponseCode()!=200){
                    throw new IOException(connection.getResponseMessage());
                }
                InputStream stream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder buffer = new StringBuilder();

                String line="";
                while ((line = bufferedReader.readLine())!=null){
                    buffer.append(line);
                }
                JSONObject j = new JSONObject(buffer.toString());
                List<PlaceDetails.ResultsBean> response = new ArrayList<>();
                response.add(gson.fromJson(j.toString(), PlaceDetails.ResultsBean.class));
                PlaceDetails.makeInstance(response);
                connection.disconnect();
                bufferedReader.close();
                return null;
            }catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
            PlaceDetails obj = PlaceDetails.getInstance();
            List<PlaceDetails.ResultsBean> res = obj.getResults();
            StringBuilder ans = new StringBuilder();
            for(PlaceDetails.ResultsBean object : res){
                ans.append(object.getName()).append(" ");
            }
            Toast.makeText(SearchPlacesActivity.this, ans, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
        if(!cd.isConnectedToInternet()){
            alert.showAlertDialog(this,"No Internet Connection","Please connect to a working internet connection",false);
        }
        else{
            GPSTracker gps = new GPSTracker(this);
            if(gps.canGetLocation()){
                Log.v("your location","latitude = "+ gps.getLatitude()+" Longitude = "+ gps.getLongitude());
                ll = new LatLng(gps.getLatitude(), gps.getLongitude());
            }
            else{
                gps.showSettingsDialogAlert();
            }
        }
    }
}
