package com.example.funs;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        GoogleMap mMap = googleMap;

        try {
            boolean success = mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.style));
            if (!success) {
                Log.e("MapsActivityRaw", "Parsiranje stila nije uspijelo.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapsActivityRaw", "Stil se ne može pronaći.", e);
        }
        mMap.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(43.5147,16.435) , 10.0f) );
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.507, 16.463)).title("Bowling"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.507, 16.435)).title("Diocletian's Cellars"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.509, 16.436)).title("Treasure hunt"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.514, 16.501)).title("Karting track"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.537, 16.521)).title("Paintball"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(43.501, 16.448)).title("Open air cinema"));

    }
}
