package gram.com.pimo.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.android.gms.maps.MapFragment;

import gram.com.pimo.R;
import gram.com.pimo.Util.BaseActivity;

/**
 * Created by dsm2017 on 2017-11-14.
 */

public class MemocompleteActivity extends BaseActivity{
    private MapFragment mMapFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memocomplete);

        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.map, mMapFragment);
        fragmentTransaction.commit();
    }
}
