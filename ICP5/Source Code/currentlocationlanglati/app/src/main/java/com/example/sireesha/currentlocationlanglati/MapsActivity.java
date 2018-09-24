package com.example.sireesha.currentlocationlanglati;


import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.Manifest;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Marker;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;
    public double lat;
    public double lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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


        geocoder = new Geocoder(this);
        LocationManager loc = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        // Add a marker in Sydney and move the camera
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "enable location", Toast.LENGTH_LONG).show();
            return;
        }
        Location l = loc.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        LatLng location = new LatLng(l.getLatitude(),l.getLongitude());
        lat = l.getLatitude();
        lang =l.getLongitude();
        mMap.addMarker(new MarkerOptions().position(location).title("Latitude  " + Double.toString(lat)+ "    Longitude  " + Double.toString(lang)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
       /* Toast.makeText(getApplicationContext(), "Lat"+ location.latitude, Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), "Long"+ location.longitude, Toast.LENGTH_LONG).show();*/

    }
}
