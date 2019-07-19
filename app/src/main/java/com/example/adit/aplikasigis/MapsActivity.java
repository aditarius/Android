package com.example.adit.aplikasigis;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonArrayRequest;
//import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String[] nama, alamat, harga, jam, call, id,
            gambar, rating;
    int numData;
    LatLng latLng[];
    Boolean markerD[];
    private Double[] latitude, longitude;

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
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

// Getting LocationManager object from System Service LOCATION_SERVICE
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Creating a criteria object to retrieve provider
        Criteria criteria = new Criteria();

        // Getting the name of the best provider
        String provider = locationManager.getBestProvider(criteria, true);

        // Getting Current Location
//        Location location = locationManager.getLastKnownLocation(provider);
//
//
//        mMap.setMyLocationEnabled(true);


        // Add a marker in Sydney and move the camera
//        double longitude = location.getLongitude();
//        double latitude = location.getLatitude();

        LatLng sydney = new LatLng(-7.2781828,112.7921264);
//        LatLng saya = new LatLng(latitude,longitude);
//        mMap.addMarker(new MarkerOptions().position(saya));
        mMap.addMarker(new MarkerOptions().position(sydney).title("Jurusan sistem informasi ITS").snippet("Jl. ITS Raya, Keputih, Sukolilo, Kota SBY, Jawa Timur 60111"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);

    }


//    private void getLokasi() {
//        String url = "https://piscoek.000webhostapp.com/api/adit/GetLapangan.php";
//        JsonArrayRequest request = new JsonArrayRequest
//                (Request.Method.GET, url, new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        numData = response.length();
//                        Log.d("DEBUG_", "Parse JSON");
//                        latLng = new LatLng[numData];
//                        markerD = new Boolean[numData];
//                        nama = new String[numData];
//                        alamat = new String[numData];
//                        harga = new String[numData];
//                        jam = new String[numData];
//                        call = new String[numData];
//                        rating = new String[numData];
//                        id = new String[numData];
//                        gambar = new String[numData];
//                        latitude = new Double[numData];
//                        longitude = new Double[numData];
//
//                        for (int i = 0; i < numData; i++) {
//                            try {
//                                JSONObject data = response.getJSONObject(i);
//                                id[i] = data.getString("id");
//                                latLng[i] = new LatLng(data.getDouble("latitude"),
//                                        data.getDouble("longitude"));
//                                nama[i] = data.getString("nama");
//                                alamat[i] = data.getString("alamat");
//                                harga[i] = data.getString("harga");
//                                jam[i] = data.getString("jam");
//                                call[i] = data.getString("call");
//                                rating[i] = data.getString("ratingtempat");
//                                gambar[i] = data.getString("gambar");
//                                latitude[i] = data.getDouble("latitude");
//                                longitude[i] = data.getDouble("longitude");
//
//                                markerD[i] = false;
//                                mMap.addMarker(new MarkerOptions()
//                                        .position(latLng[i])
//                                        .title(nama[i])
//                                        .snippet(alamat[i])
//                                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.markerlapangan)));
//                            } catch (JSONException je) {
//                            }
//                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng[i], 15.5f));
//                        }
//                    }
//
//                } , new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
//                        builder.setTitle("Error!");
//                        builder.setMessage("No Internet Connection");
//                        builder.setIcon(android.R.drawable.ic_dialog_alert);
//                        builder.setPositiveButton("Refresh", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                getLokasi();
//                            }
//                        });
//                        AlertDialog alert = builder.create();
//                        alert.show();
//                    }
//                });
//        Volley.newRequestQueue(this).add(request);
//    }
}
