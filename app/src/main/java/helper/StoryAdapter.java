package helper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jmaldonado.yourstory.PlanActivity;
import com.jmaldonado.yourstory.R;
import com.jmaldonado.yourstory.RecordActivity;
import com.jmaldonado.yourstory.StoryActivity;

import java.util.List;

import core.Story;

class StoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    public TextView title, relationship;
    public ImageView overflow, record, preview;
    private ItemClickListener itemClickListener;

    public StoryViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.story_title);
        relationship = (TextView) view.findViewById(R.id.relationship);
        overflow = (ImageView) view.findViewById(R.id.overflow);
        record = (ImageView) view.findViewById(R.id.record_view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
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

public class StoryAdapter extends RecyclerView.Adapter<StoryViewHolder> {

    private Context mContext;
    private List<Story> storyList;

    public StoryAdapter(Context mContext, List<Story> storyList) {
        this.mContext = mContext;
        this.storyList = storyList;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_stories_card, parent, false);
        return new StoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final StoryViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.title.setText(story.getTitle());
        holder.relationship.setText(story.getRelationship());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick) {
                    Toast.makeText(mContext, "LONG CLICK" + storyList.get(position).getTitle(), Toast.LENGTH_LONG).show();
                } else {
                    Intent myIntent = new Intent(mContext, PlanActivity.class);
                    mContext.startActivity(myIntent);
                }
            }
        });
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });
        holder.record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(mContext, RecordActivity.class);
                mContext.startActivity(myIntent);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_story, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_delete_story:
                    Toast.makeText(mContext, "Delete Story", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_share_story:
                    Toast.makeText(mContext, "Share Story", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }
}
