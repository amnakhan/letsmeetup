package com.mbembac.letsmeetup;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.MenuInflater;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;


public class FriendMapActivty extends Activity {

    private MapFragment mMapFragment;
    private GoogleMap gMap;
    public final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_map_activty);

//        mMapFragment = MapFragment.newInstance();
//        FragmentTransaction fragmentTransaction =
//                getFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.gmap, mMapFragment);
//        fragmentTransaction.commit();

        setUpMapIfNeeded();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setUpMapIfNeeded() {

        if (gMap == null) {
            gMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.gmap)).getMap();

            if (gMap != null) {
                setupMap();
            }else{
                Toast.makeText(this, "Google Maps not available",
                        Toast.LENGTH_LONG).show();
            }
        }

    }

    private void setupMap() {
//        gMap.addMarker(new MarkerOptions(new LatLng(0.0,0.0)).title("marker"));
        gMap.setMyLocationEnabled(true);

    }
}

