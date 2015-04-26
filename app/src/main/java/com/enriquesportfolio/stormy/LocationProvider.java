package com.enriquesportfolio.stormy;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Enrique on 4/20/15.
 */
public class LocationProvider implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    public static final String TAG = LocationProvider.class.getSimpleName();

    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;
    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private boolean mRequestingLocationUpdates = false;
    private LocationRequest mLocationRequest;
    private double mLongitude;
    private double mLatitude;

    protected synchronized void buildGoogleApiClient(Context context) {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);

        Log.d(TAG, "mLastLocation: " + String.valueOf(mLastLocation));

        if (mLastLocation != null) {
            setLatitude(mLastLocation.getLatitude());
            mLongitude = mLastLocation.getLongitude();
        } else {
            Log.d(TAG, "(Couldn't get the location. Make sure location is enabled on the device)");
        }

    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    public double getLongitude() {
        return mLongitude;
    }

//    public void setLongitude(double longitude) {
//        mLongitude = longitude;
//    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }
}
