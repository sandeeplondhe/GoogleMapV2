package com.example.googlemapv2;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

	private double latititude = 18.9750;
	private double longitude = 72.8258;

	// Google Map
	private GoogleMap googleMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// For Showing Particular latititude and longitutde

		try {
			// Loading map
			initilizeMap();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// For Enabling the current location

		googleMap.setMyLocationEnabled(true);

		// For Zooming Functionality

		googleMap.getUiSettings().setZoomControlsEnabled(true);

		// For Setting Map Type
		// There are four type of Maps:

		googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		// googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
		// googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID)
		// googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN)
		// googleMap.setMapType(GoogleMap.MAP_TYPE_NONE)

		// Set Compass Functinality

		googleMap.getUiSettings().setCompassEnabled(true);

		// Map Rotate Gesture

		googleMap.getUiSettings().setRotateGesturesEnabled(true);
		// Create a Marker

		MarkerOptions marker = new MarkerOptions().position(
				new LatLng(latititude, longitude)).title(
				"Ye Hai Mumbai Meri Jaan");

		// Changing the marker color

		marker.icon(BitmapDescriptorFactory
				.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

		// Can set : HUE_ROSE, HUE_BLUE and So on

		// adding marker

		googleMap.addMarker(marker);
	}

	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	private void initilizeMap() {

		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

}