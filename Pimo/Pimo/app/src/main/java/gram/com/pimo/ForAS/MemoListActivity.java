package gram.com.pimo.ForAS;

import android.os.Bundle;
import android.support.annotation.Nullable;

import gram.com.pimo.Model.MemoModel;
import gram.com.pimo.R;
import gram.com.pimo.Util.BaseActivity;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by root1 on 2017. 11. 10..
 */

public class MemoListActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_main);
    }

    private RealmResults<MemoModel> bind(){
        Realm realm = getRealm();
        RealmResults<MemoModel> data = realm.where(MemoModel.class).findAll();
        return data;
    }

}
