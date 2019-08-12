package com.assignmentchuyennt.ui.imagelatest.adapter;

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
import com.assignmentchuyennt.ui.imagelatest.model.ListImageLatets;
import com.assignmentchuyennt.ui.latest.apdater.ItemClick;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterImageLatest extends RecyclerView.Adapter<AdapterImageLatest.ViewHolder> {

    List<ListImageLatets> imageLatetsList;
    Context context;
    int TYPE = -1;
    int TYPE_FAVORITES = 0;
    int TYPE_IMAGELATEST = 1;

    private ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public AdapterImageLatest(List<ListImageLatets> imageLatetsList, int TYPE) {
        this.imageLatetsList = imageLatetsList;
        this.TYPE = TYPE;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_latest, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (TYPE == TYPE_FAVORITES) {
            viewHolder.layoutInteractiveItemLatest.setVisibility(View.VISIBLE);
        } else {
            viewHolder.layoutInteractiveItemLatest.setVisibility(View.GONE);
        }
        ListImageLatets imageLatets = imageLatetsList.get(i);
        Picasso.get().load(imageLatets.getSourceUrl()).fit().centerCrop().into(viewHolder.imgItemListLatest);
        viewHolder.imgItemListLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageLatetsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItemListLatest;
        private TextView tvWatchedLatest;
        private TextView tvLikedLatest;
        private LinearLayout layoutInteractiveItemLatest;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutInteractiveItemLatest = (LinearLayout) itemView.findViewById(R.id.layout_interactive_item_latest);
            imgItemListLatest = (ImageView) itemView.findViewById(R.id.img_item_listLatest);
            tvWatchedLatest = (TextView) itemView.findViewById(R.id.tv_watched_latest);
            tvLikedLatest = (TextView) itemView.findViewById(R.id.tv_liked_latest);
        }
    }

    public void clearList() {
        this.imageLatetsList.clear();
        notifyDataSetChanged();
    }

    public void updateData(List<ListImageLatets> imageLatets) {
        this.imageLatetsList.addAll(imageLatets);
        notifyDataSetChanged();
    }
}
