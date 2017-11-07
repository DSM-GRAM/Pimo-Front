package gram.com.pimo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

     public class MemoList_Adapter extends RecyclerView.Adapter<MemoList_Adapter.ViewHolder> {

    private List<MemoList_Adapter> memoList;
         private int itemLayout;

         public MemoList_Adapter(List<MemoList_Adapter> items, int itemLayout) {
             this.memoList = items;
             this.itemLayout = itemLayout;
         }


         @Override
         public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.memolist_item, parent,false);
             return new ViewHolder(view);
         }

         @Override
         public void onBindViewHolder(ViewHolder holder, int position) {
             holder.textView.setText("ddd");
         }

         @Override
         public int getItemCount() {
             return memoList.size();
         }

         class ViewHolder extends RecyclerView.ViewHolder {
             //TextView textView 뷰 객체를 선언을 해준다.
             TextView textView;
             public ViewHolder(View itemView) {
                 super(itemView);
                 //textView=itemView.findbyid() 아이디를 찾아준다.
             }
    }
}