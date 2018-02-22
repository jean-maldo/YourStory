package helper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jmaldonado.yourstory.ChapterQuestionsActivity;
import com.jmaldonado.yourstory.R;

import java.util.List;

import core.Chapter;

class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public TextView title, chapter;
    private ItemClickListener itemClickListener;

    public ChapterViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.chapter_title);
        chapter = (TextView) itemView.findViewById(R.id.chapter_subtitle);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(), true);
        return true;
    }
}

public class ChapterViewAdapter extends RecyclerView.Adapter<ChapterViewHolder> {
    private Context mContext;
    private final List<Chapter> chapterList;

    public ChapterViewAdapter(Context mContext, List<Chapter> chapterList) {
        this.mContext = mContext;
        this.chapterList = chapterList;
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_chapter_list, parent, false);

        return new ChapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
        Chapter chapter = chapterList.get(position);
        holder.title.setText(chapter.getTitle());
        holder.chapter.setText(chapter.getRelationship());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick) {
                    Toast.makeText(mContext, "LONG CLICK" + chapterList.get(position).getTitle(), Toast.LENGTH_LONG).show();
                } else {
                    Intent myIntent = new Intent(mContext, ChapterQuestionsActivity.class);
                    mContext.startActivity(myIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return chapterList.size();
    }
}
