package com.example.gmail.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gmail.Activity.MainActivity;
import com.example.gmail.R;
import com.example.gmail.modes.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHoler> {
    public static List<Item> itemsAll = new ArrayList<>();
    List<Item> itemsDisplay = new ArrayList<>();
    public ListAdapter(List<Item> items) {

        this.itemsDisplay = items;

    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemView = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHoler holder, final int position) {
        holder.txtCicrle.setText(itemsDisplay.get(position).cicrle);
        holder.txtTen.setText(itemsDisplay.get(position).name);
        holder.txtSubject.setText(itemsDisplay.get(position).subject);

        Item item = itemsDisplay.get(position);
        if (item.isFavourite == true) {
            holder.imgFavorite.setImageResource(R.drawable.ic_star_black_24dp);
        } else {
            holder.imgFavorite.setImageResource(R.drawable.ic_star_border);
        }

    }



    public void showFavourite() {
        itemsAll.clear();
        for (Item i : itemsDisplay) {
            if (i.isFavourite == true)
                itemsAll.add(i);
        }

    }

    @Override
    public int getItemCount() {
        return itemsDisplay.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_cicrle)
        TextView txtCicrle;
        @BindView(R.id.txt_ten)
        TextView txtTen;
        @BindView(R.id.txt_subject)
        TextView txtSubject;
        @BindView(R.id.img_favorite)
        ImageView imgFavorite;

        public ViewHoler(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            imgFavorite.setOnClickListener(new View.OnClickListener() {//click vao dau sao
                @Override
                public void onClick(View v) {
                    itemsDisplay.get(getAdapterPosition()).isFavourite = true;//doi trang thai cho imag
                    notifyDataSetChanged();
                }
            });
        }

    }


}
