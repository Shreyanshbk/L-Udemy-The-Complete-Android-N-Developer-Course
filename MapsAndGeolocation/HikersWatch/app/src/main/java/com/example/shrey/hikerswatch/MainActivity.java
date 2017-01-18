package com.example.shrey.hikerswatch;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    LocationManager locationManager;
    LocationListener locationListener;
    TextView textView;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 1){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
                }
            }
        }
    }

    public void updateView(Location location){
        Log.i("Location :::", location.toString());
        String s ="";
        s += "Latitude : " + location.getLatitude() + "\n\n" +
                "Longitude : " + location.getLongitude() + "\n\n" +
                "Altitude : " + location.getAltitude() + "\n\n" +
                "Accuracy : " + location.getAccuracy() + "\n\n" +
                "Address : \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t";
        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        try {
            List<Address> l = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

            if(l!=null && l.size()>0) {
                if (l.get(0).getSubThoroughfare() != null) {
                    s += l.get(0).getSubThoroughfare().toString() + "\n\t\t\t\t\t\t\t\t\t\t\t\t";
                }
                if (l.get(0).getThoroughfare() != null) {
                    s += l.get(0).getThoroughfare().toString() + "\n\t\t\t\t\t\t\t\t\t\t\t\t";
                }
                if (l.get(0).getLocality() != null) {
                    s += l.get(0).getLocality().toString() + "\n\t\t\t\t\t\t\t\t\t\t\t\t";
                }
                if (l.get(0).getCountryName() != null) {
                    s += l.get(0).getCountryName().toString() + "\n\t\t\t\t\t\t\t\t\t\t\t\t";
                }
                if (l.get(0).getPostalCode() != null) {
                    s += l.get(0).getPostalCode().toString() + "\n\t\t\t\t\t\t\t\t";
                }

                Log.i("Address : ", l.get(0).toString());
            }

            textView.setText(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                updateView(location);

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
        };
        if (Build.VERSION.SDK_INT < 23) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        else{
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            else{
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0, locationListener);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null){
                    updateView(location);
                }
            }
        }

    }
}
