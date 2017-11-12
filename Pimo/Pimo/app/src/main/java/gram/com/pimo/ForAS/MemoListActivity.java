package gram.com.pimo.ForAS;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import gram.com.pimo.Model.MemoListModel;
import gram.com.pimo.R;
import gram.com.pimo.Util.BaseActivity;

/**
 * Created by root1 on 2017. 11. 10..
 */

public class MemoListActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memo_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.memo_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        MemoListAdapter adapter = new MemoListAdapter();
        recyclerView.setAdapter(adapter);
        ArrayList<MemoListModel> data = new ArrayList<>();

        data.add(new MemoListModel("대덕소프트웨어 ", "대전시 유성구", "늦으면 벌점"));



        adapter.getData(data);
    }
}
