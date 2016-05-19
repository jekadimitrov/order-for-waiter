package com.example.evgen.myrest;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.util.Date;

/**
 * Created by EVGEN on 27.04.2016.
 */
/*public class MapTaxi extends Activity {


    public double latitude;
    public double longitude;
    private LocationManager LM;
    GoogleMap googleMap;

    String provider;
    LocationManager locationManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stomap);
        createMapView();

        MapView mapView = (MapView) findViewById(R.id.mapView);

        LM = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    private void createMapView() {

        try {
            if (null == googleMap) {
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView)).getMap();


                if (null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception) {
            Log.e("mapApp", exception.toString());
        }
    }


    private void setUpMap() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        if ((provider != null) && !provider.equals("")) {
            Location location = locationManager.getLastKnownLocation(provider);
            locationManager.requestLocationUpdates(provider, 20000, 1, this);
            if (location != null) {
                GeoPoint myLication = new GeoPoint((int) latitude, (int) longitude);
                mc.animateTo(myLication);

                Drawable makerDefault = getResources().getDrawable(R.drawable.pushpin);

                MirItemizedOverlay itemizedOverlay = new MirItemizedOverlay(makerDefault);
                itemizedOverlay.addOverlayItem((int) latitude, (int) longitude, "My Location");
                mapView.getOverlays().add(itemizedOverlay);
                mc.setCenter(new GeoPoint((int) latitude, (int) longitude));
            } else {
                Toast.makeText(getBaseContext(), "Location can't be retrieved", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getBaseContext(), "No Provider Found", Toast.LENGTH_SHORT).show();
        }
    }
}
*/