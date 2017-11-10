package gram.com.pimo.ForAS;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import gram.com.pimo.Model.TempModel;
import gram.com.pimo.R;

/**
 * Created by root1 on 2017. 11. 10..
 */

public class MemoListAdapter extends RecyclerView.Adapter<MemoListViewHolder> {

    @Override
    public MemoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memolist_item, null);
        return new MemoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MemoListViewHolder holder, int position) {
        holder.titleText.setText(data.get(position).getTitle());
        holder.contentText.setText(data.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void getData(ArrayList<TempModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    private ArrayList<TempModel> data = new ArrayList<>();

}

class MemoListViewHolder extends RecyclerView.ViewHolder {

    TextView titleText, contentText, locText;

    public MemoListViewHolder(View itemView) {
        super(itemView);
        titleText = (TextView)itemView.findViewById(R.id.textView1);

    }

}
