package gram.com.pimo.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import gram.com.pimo.R;
import gram.com.pimo.Util.BaseActivity;

/**
 * Created by dsm2017 on 2017-11-14.
 */

public class MemocompleteActivity extends BaseActivity implements OnMapReadyCallback{
    private MapFragment mMapFragment;
    private double lat, lng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memocomplete);

        lat = 0.0d;
        lng = 0.0d;

        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mMapFragment);
        fragmentTransaction.commit();

        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng loc = new LatLng(lat, lng);

        map.addMarker(new MarkerOptions()
                .position(loc)
                .title("Here!"));
        map.moveCamera(CameraUpdateFactory.newLatLng(loc));
    }
}
