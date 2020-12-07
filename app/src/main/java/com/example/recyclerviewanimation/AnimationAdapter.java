package com.example.recyclerviewanimation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.ViewHolder> {


    private ArrayList<AnimationData> dataArray;

    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public void setDataArray(ArrayList<AnimationData> dataArray) {
        this.dataArray = dataArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final AnimationData data = dataArray.get(position);

        NewImageLoaderManager.getInstance(MyApplication.getInstance().getApplicationContext()).setPhotoUrl(data.getImageUrl(),holder.ivPhoto);
        holder.tvDesc.setText(data.getDescription());
        holder.itemArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(data.getImageUrl(),data.getDescription(),holder.ivPhoto,holder.tvDesc);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;

        private TextView tvDesc;

        private ConstraintLayout itemArea;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemArea = itemView.findViewById(R.id.item_area);
            ivPhoto = itemView.findViewById(R.id.photo);
            tvDesc = itemView.findViewById(R.id.description);

        }
    }

    public interface OnItemClickListener{
        void onClick(String url,String description,ImageView imageView,TextView textView);
    }
}
