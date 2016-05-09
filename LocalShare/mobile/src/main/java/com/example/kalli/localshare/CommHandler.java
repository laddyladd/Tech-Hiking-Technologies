package com.example.kalli.localshare;

import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.Wearable;

/**
 * Created by stephenwon on 4/30/16.
 */
public class CommHandler implements DataApi.DataListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{


    static android.os.Handler UIHandler = null;

    GoogleApiClient mGoogleApiClient;
    AvailableItems availableitemsActivity;

    public static String ITEM_ID = "item id";
    public static String ITEM_LIST = "item list";

    public CommHandler(AvailableItems aa){
        availableitemsActivity = aa;
        mGoogleApiClient = new GoogleApiClient.Builder(availableitemsActivity)
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

        for (DataEvent event : dataEventBuffer){
            if (event.getType() == DataEvent.TYPE_CHANGED){
                //DataItem changed
                DataItem item = event.getDataItem();
                if (item.getUri().getPath().compareTo("/"+ITEM_ID) == 0){
                    DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
                    int itemID = dataMap.getInt(ITEM_ID);
                    availableitemsActivity.moveToWatchClickedItem(itemID);
                    //availableItemsActivity calls
                }
            }
            else if (event.getType() == DataEvent.TYPE_DELETED){
                //DataItem deleted
            }
        }


    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }



}
