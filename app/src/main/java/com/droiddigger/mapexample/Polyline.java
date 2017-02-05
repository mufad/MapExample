package com.droiddigger.mapexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Polyline extends AppCompatActivity implements OnMapReadyCallback {
    boolean ready=false;
    GoogleMap myMap;
    LatLng uiul=new LatLng(23.744403 , 90.372720);
    LatLng uapl=new LatLng(23.754740 , 90.389226);
    LatLng bracul=new LatLng(23.779928, 90.407274);
    LatLng ewul=new LatLng(23.768458 , 90.425602);
    MarkerOptions bracu,ewu,uap,uiu;
    static final CameraPosition home = CameraPosition.builder().target(new LatLng(23.759936, 90.361341)).
            zoom(10).bearing(0).tilt(45).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polyline);
        bracu=new MarkerOptions().position(bracul).title("BRACU").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.forest));
        ewu=new MarkerOptions().position(ewul).title("EWU");
        uap=new MarkerOptions().position(uapl).title("UAP");
        uiu=new MarkerOptions().position(uiul).title("UIU").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.wetlands));
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ready=true;
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(home));

        googleMap.addPolyline(new PolylineOptions().geodesic(true).add(uiul).add(uapl).add(bracul).add(ewul));
        googleMap.addMarker(uiu);
        googleMap.addMarker(bracu);
        googleMap.addMarker(uap);
        googleMap.addMarker(ewu);
    }
}
