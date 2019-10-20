package com.example.bakingapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.Model.Recipe;
import com.example.bakingapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeAdapter extends ArrayAdapter<Recipe>{

    private Context context;
    private int resource;
    List<Recipe> objects;

    public RecipeAdapter(@NonNull Context context, int resource, @NonNull List<Recipe> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RecipeViewHolder recipeViewHolderObject;
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(resource, null);
            recipeViewHolderObject = new RecipeViewHolder();
            recipeViewHolderObject.recipeImage = convertView.findViewById(R.id.recipe_image);
            recipeViewHolderObject.recipeName = convertView.findViewById(R.id.recipe_name);
            convertView.setTag(recipeViewHolderObject);
        } else {
            recipeViewHolderObject = (RecipeViewHolder) convertView.getTag();

        }
        Recipe recipeObject = objects.get(position);
        if (!recipeObject.getImage().equals("")) {
            Picasso.get().load(recipeObject.getImage())
                    .placeholder(R.drawable.baking_sample).error(R.drawable.baking_sample)
                    .into(recipeViewHolderObject.recipeImage);
        }
        if (recipeObject.getName() != null) {
            recipeViewHolderObject.recipeName.setText(recipeObject.getName());
        }

        return convertView;
    }
}

class RecipeViewHolder  {
    ImageView recipeImage;
    TextView recipeName;

}