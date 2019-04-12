package com.bulbasaur.dat256.viewmodel;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.bulbasaur.dat256.R;
import com.bulbasaur.dat256.model.MeetUp;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    private MeetUp fakeMeetUp;
    private LatLng fakeMeetUpCoordinates;

    private static final int SHOW_EVENT_ON_MAP_CODE = 1;
    private static final int DEFAULT_MEET_UP_ZOOM_LEVEL = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Objects.requireNonNull(mapFragment).getMapAsync(this);

        fakeMeetUp = new MeetUp();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        fakeMeetUpCoordinates = new LatLng(fakeMeetUp.getLatitude(), fakeMeetUp.getLongitude());
        this.googleMap.addMarker(new MarkerOptions().position(fakeMeetUpCoordinates).title(fakeMeetUp.getName()));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(fakeMeetUpCoordinates));

        this.googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                onMeetUpMarkerClick();

                return true;
            }
        });
    }

    private void onMeetUpMarkerClick() {
        Intent meetUpIntent = new Intent(this, MeetUpActivity.class);
        meetUpIntent.putExtra("MeetUp", fakeMeetUp);
        startActivityForResult(meetUpIntent, SHOW_EVENT_ON_MAP_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SHOW_EVENT_ON_MAP_CODE) {
            if (resultCode == RESULT_OK) {
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fakeMeetUpCoordinates, DEFAULT_MEET_UP_ZOOM_LEVEL));
            }
        }
    }
}
