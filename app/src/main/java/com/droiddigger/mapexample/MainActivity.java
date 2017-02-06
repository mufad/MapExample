package com.droiddigger.mapexample;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    boolean ready=false;
    GoogleMap myMap;
    MarkerOptions bracu, nsu,ewu,uap,uiu;

    static final CameraPosition home = CameraPosition.builder().target(new LatLng(23.759936, 90.361341)).
            zoom(10).bearing(0).tilt(45).build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bracu=new MarkerOptions().position(new LatLng(23.779928, 90.407274)).title("BRACU").
                icon(BitmapDescriptorFactory.fromResource(R.drawable.forest));
        nsu=new MarkerOptions().position(new LatLng(23.814795 , 90.424983)).title("NSU");
        ewu=new MarkerOptions().position(new LatLng(23.768458 , 90.425602)).title("EWU");
        uap=new MarkerOptions().position(new LatLng(23.754740 , 90.389226)).title("UAP");
        uiu=new MarkerOptions().position(new LatLng(23.744403 , 90.372720)).title("UIU").
        icon(BitmapDescriptorFactory.fromResource(R.drawable.wetlands));
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.v2){
            startActivity(new Intent(MainActivity.this, DetailedMap.class));
        }else if(id==R.id.v3){
            startActivity(new Intent(MainActivity.this, Polyline.class));
        }else if(id==R.id.v4){
            startActivity(new Intent(MainActivity.this, Run.class));
        }
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        ready=true;
        myMap=googleMap;
        myMap.addMarker(bracu);
        myMap.addMarker(nsu);
        myMap.addMarker(uiu);
        myMap.addMarker(uap);
        myMap.addMarker(ewu);
        myMap.moveCamera(CameraUpdateFactory.newCameraPosition(home));
    }
}
