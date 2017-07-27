package com.mirrordust.telecomlocate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mirrordust.telecomlocate.R;
import com.mirrordust.telecomlocate.activity.SampleDetailActivity;

public class MapFragment extends Fragment {

    private static final String TAG = "MapFragment";
    private static final String ARG_SAMPLE_ID = "sample_id";
    private double longitude = 121.2095634;
    private double latitude = 31.28441738;
    private MapView mMapView;

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_map, container, false);
        mMapView = (MapView) frameLayout.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        final SampleDetailActivity parentActivity = (SampleDetailActivity) getActivity();
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                Log.e("地图view","onMapReady");
                showPoints(mapboxMap, parentActivity.getSampleId());
            }
        });
        return frameLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void showPoints(MapboxMap mapboxMap, String id) {
        LatLng latLng = new LatLng(latitude, longitude);
        CameraPosition position = new CameraPosition.Builder()
                .target(latLng)
                .build();
        mapboxMap.setCameraPosition(position);
        mapboxMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(longitude+", "+latitude));
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }
}
