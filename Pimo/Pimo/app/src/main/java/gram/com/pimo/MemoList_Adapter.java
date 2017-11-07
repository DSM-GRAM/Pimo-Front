package gram.com.pimo;

import java.util.List;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by dsm2017 on 2017-11-07.
 */


     public class MemoList_Adapter extends RycyclerView.Adapter<MemoList_Adapter.ViewHolder> {

    private List<MemoList_Adapter> memoList;
    private int itemLayout;

    public MemoList_Adapter(List<MemoList_Adapter> items, int itemLayout){
        this.memoList = items;
        this.itemLayout = itemLayout;
    }
}