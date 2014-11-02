package me.eathub.android.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import me.eathub.android.R;
import me.eathub.android.presentation.model.RecipeModel;

public class RecipeGridAdapter extends Adapter<RecipeGridAdapter.ViewHolder> {

    private List<RecipeModel> recipes;
    private Picasso picasso;

    public RecipeGridAdapter(List<RecipeModel> recipes, Picasso picasso) {
        this.recipes = recipes;
        this.picasso = picasso;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_recipe, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override public void onBindViewHolder(ViewHolder viewHolder, int i) {
        RecipeModel item = getItem(i);
        viewHolder.title.setText(item.getTitle());
        picasso.load(item.getCoverUrl()).into(viewHolder.cover);
    }

    public RecipeModel getItem(int position) {
        return recipes.get(position);
    }

    @Override public int getItemCount() {
        return recipes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @InjectView(R.id.recipe_title) TextView title;
        @InjectView(R.id.recipe_cover) ImageView cover;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
