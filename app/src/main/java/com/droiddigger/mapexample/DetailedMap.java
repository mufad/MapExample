package com.droiddigger.mapexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class DetailedMap extends AppCompatActivity implements OnMapReadyCallback{

    boolean mapReady=false;
    GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_map);
        MapFragment mapFragment= (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void normal(View view) {
        if (mapReady)
            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    public void satellite(View view) {

        if (mapReady)
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void hybrid(View view) {

        if (mapReady)
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady=true;
        this.googleMap=googleMap;
        LatLng dhaka=new LatLng(23.7, 90.3);
        CameraPosition target=CameraPosition.builder().target(dhaka).zoom(14).build();
        this.googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
