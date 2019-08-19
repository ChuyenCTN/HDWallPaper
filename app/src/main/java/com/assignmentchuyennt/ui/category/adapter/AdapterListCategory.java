package com.assignmentchuyennt.ui.category.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignmentchuyennt.R;
import com.assignmentchuyennt.ui.category.model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterListCategory extends RecyclerView.Adapter<AdapterListCategory.ViewHolder> {

    List<Category> categoryList;
    int[] imageList = {R.drawable.image3d, R.drawable.asia, R.drawable.cambodia, R.drawable.car, R.drawable.china, R.drawable.galaxy, R.drawable.girl, R.drawable.japan, R.drawable.landscape, R.drawable.laos, R.drawable.moto_bike, R.drawable.planet, R.drawable.sea, R.drawable.truck, R.drawable.vietnam};

    Context context;

    public AdapterListCategory(List<Category> categoryList) {
        this.categoryList = categoryList;
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
        Category category = categoryList.get(i);
        viewHolder.tvLikedLatest.setText(category.getName());
        Picasso.get().load(imageList[i]).into(viewHolder.imgItemListLatest);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgItemListLatest;
        private TextView tvWatchedLatest;
        private TextView tvLikedLatest;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItemListLatest = (ImageView) itemView.findViewById(R.id.img_item_listLatest);
            tvWatchedLatest = (TextView) itemView.findViewById(R.id.tv_watched_latest);
            tvLikedLatest = (TextView) itemView.findViewById(R.id.tv_liked_latest);

        }
    }

    public void clearList() {
        this.categoryList.clear();
        notifyDataSetChanged();
    }

    public void updateList(List<Category> categoryList) {
        Log.d("sizeList", categoryList.size() + "");
        this.categoryList.addAll(categoryList);
        notifyDataSetChanged();
    }
}
