package com.assignmentchuyennt.ui.latest.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.ui.latest.model.Latest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterListLatest extends RecyclerView.Adapter<AdapterListLatest.ViewHolder> {

    List<Latest> latestList;
    private ItemClick itemClick;
    Context context;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public AdapterListLatest(List<Latest> latestList) {
        this.latestList = new ArrayList<>();
        if (this.latestList != null) {
            this.latestList.clear();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_latest, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Latest latest = latestList.get(i);

        viewHolder.tvTitleLatest.setText(latest.getTitle().getRendered() + "");
        if (i % 3 != 0) {
            viewHolder.tvTitleLatest.setTextColor(context.getResources().getColor(R.color.blue));
        }
        Picasso.get().load(latest.getEmbedded().getWpFeaturedmedia().get(0).getSourceUrl()).fit().placeholder(R.drawable.ic_category).centerCrop().into(viewHolder.imgItemListLatest);
        viewHolder.imgItemListLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return latestList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItemListLatest;
        private TextView tvWatchedLatest;
        private TextView tvLikedLatest;
        private LinearLayout layoutInteractiveItemLatest;
        private TextView tvTitleLatest;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutInteractiveItemLatest = (LinearLayout) itemView.findViewById(R.id.layout_interactive_item_latest);
            imgItemListLatest = (ImageView) itemView.findViewById(R.id.img_item_listLatest);
            tvWatchedLatest = (TextView) itemView.findViewById(R.id.tv_watched_latest);
            tvLikedLatest = (TextView) itemView.findViewById(R.id.tv_liked_latest);
            tvTitleLatest = (TextView) itemView.findViewById(R.id.tv_title_latest);
        }
    }

    public void clearList() {
        this.latestList.clear();
        notifyDataSetChanged();
    }

    public void updateList(List<Latest> latestList) {
        this.latestList.addAll(latestList);
        notifyDataSetChanged();
    }
}
