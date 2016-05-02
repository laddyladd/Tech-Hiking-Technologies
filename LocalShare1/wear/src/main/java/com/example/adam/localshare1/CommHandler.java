package com.example.adam.localshare1;

import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

import java.util.ArrayList;

/**
 * Created by stephenwon on 4/30/16.
 */
public class CommHandler implements DataApi.DataListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{


    static android.os.Handler UIHandler = null;

    GoogleApiClient mGoogleApiClient;
    MainActivity mainActivity;

    public static String ITEM_ID = "item id";
    public static String ITEM_LIST = "item list";

    public CommHandler(MainActivity ma){
        mainActivity = ma;
        mGoogleApiClient = new GoogleApiClient.Builder(mainActivity)
                .addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        if (!mGoogleApiClient.isConnected()){
            mGoogleApiClient.connect();
        }

    }

    @Override
    public void onConnected(Bundle bundle) {
        Wearable.DataApi.addListener(mGoogleApiClient, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {


    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void sendClickedItemID(int itemID){
        PutDataMapRequest putDataMapReq = PutDataMapRequest.create("/" + ITEM_ID);
        putDataMapReq.getDataMap().putInt(ITEM_ID, itemID);
        PutDataRequest putDataReq = putDataMapReq.asPutDataRequest();
        PendingResult<DataApi.DataItemResult> pendingResult =
                Wearable.DataApi.putDataItem(mGoogleApiClient, putDataReq);
    }
}
