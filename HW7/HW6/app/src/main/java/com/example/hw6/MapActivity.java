package com.example.hw6;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.List;

// Refer from in class code
// Refer form: https://www.youtube.com/watch?v=qS1E-Vrk60E

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationManager locationManager;
    private FusedLocationProviderClient aLocationClient;
    private boolean mLocationPermissionGranted;
    private final static String TAG = "googleMap";


    @Override
    protected void onStart() {
        super.onStart ();

        // Check for permission to access Course Location and fine location.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.googlemaps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager ()
                .findFragmentById (R.id.map);
        mapFragment.getMapAsync (this);
        locationManager = (LocationManager) getSystemService (LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        if (locationManager.isProviderEnabled (LocationManager.NETWORK_PROVIDER)){
            locationManager.requestLocationUpdates (LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener () {
                @Override
                //show the of the ueser current location
                public void onLocationChanged(Location location) {
                    double lat = location.getLatitude ();
                    double lng = location.getLongitude ();
                    LatLng latLng = new LatLng (lat,lng);
                    Geocoder geocoder = new Geocoder (getApplicationContext ());
                    try {
                        List<Address> addressList = geocoder.getFromLocation (lat,lng,1);
                        String str = addressList.get(0).getLocality ()+ ",";
                        str += addressList.get(0).getCountryName ();

                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera (CameraUpdateFactory.newLatLngZoom (latLng,10.2f));



                    } catch (IOException e) {
                        e.printStackTrace ();
                    }

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });

        }
        else if (locationManager.isProviderEnabled (LocationManager.GPS_PROVIDER)){
            locationManager.requestLocationUpdates (LocationManager.GPS_PROVIDER,0,0, new LocationListener () {
                @Override
                //show the of the ueser current location
                public void onLocationChanged(Location location) {
                    double lat = location.getLatitude ();
                    double lng = location.getLongitude ();
                    LatLng latLng = new LatLng (lat,lng);
                    Geocoder geocoder = new Geocoder (getApplicationContext ());
                    try {
                        List<Address> addressList = geocoder.getFromLocation (lat,lng,1);
                        String str = addressList.get(0).getLocality ()+ ",";
                        str += addressList.get(0).getCountryName ();

                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                        mMap.moveCamera (CameraUpdateFactory.newLatLngZoom (latLng,10.2f));



                    } catch (IOException e) {
                        e.printStackTrace ();
                    }

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        if(mLocationPermissionGranted) {
            Task location = aLocationClient.getLastLocation();

            location.addOnCompleteListener(new OnCompleteListener<Location> () {

                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location actualLocation = task.getResult();
                    if (actualLocation != null) {
                        String latLong = String.format("Lat: %f, Long: %f ",
                                actualLocation.getLatitude(),
                                actualLocation.getLongitude());


                        LatLng latlng = new LatLng (actualLocation.getLatitude (),actualLocation.getLongitude ());
                        mMap.addMarker (new MarkerOptions ().position (latlng).title("User Location"));
                        mMap.moveCamera (CameraUpdateFactory.zoomTo (8));
                        mMap.animateCamera (CameraUpdateFactory.zoomTo (8));



                    } else {
                        Log.e(TAG, "No Location");

                    }
                }
            });
            location.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
            });

        }

    }


    public void getLocationPermission() {

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                    getLocation();
                }
        }

    }



   //show the camera location
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        String[] cameraDetail = intent.getStringArrayExtra(MainActivity.RESULT);

        // Get the camera description
        Log.e(TAG, cameraDetail[2]);

        //Get lat and long for coordination
        Double lat,lng;
        LatLng cameraCoordination = new LatLng (Double.parseDouble(cameraDetail[0]),Double.parseDouble(cameraDetail[1]));
        Toast.makeText(MapActivity.this,
                "Latitude is: "+Double.parseDouble(cameraDetail[0])+", Longtitude is: " + Double.parseDouble(cameraDetail[1]),
                Toast.LENGTH_LONG).show();
        mMap.addMarker(new MarkerOptions().position(cameraCoordination).title(cameraDetail[2]));
        mMap.moveCamera (CameraUpdateFactory.newLatLngZoom (cameraCoordination,10.2f));

        getLocationPermission ();
        getLocation ();



    }

    //@Override
    //protected void onStop() {
        //super.onStop();
    //   locationManager.removeUpdates(locationListener);
    //}
}
