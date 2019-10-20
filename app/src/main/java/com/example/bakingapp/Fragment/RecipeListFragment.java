package com.example.bakingapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.bakingapp.Adapter.RecipeAdapter;
import com.example.bakingapp.Model.Recipe;
import com.example.bakingapp.Model.Step;
import com.example.bakingapp.R;
import com.example.bakingapp.RecipeService;
import com.example.bakingapp.databinding.FragmentRecipeListBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeListFragment extends Fragment {
    FragmentRecipeListBinding mBinding;
    public static final String BASE_URL="https://d17h27t6h515a5.cloudfront.net/";
    public static final String ID="IwAR3NPKWgw8EHulPHt2ED9ahERuw6_fdwwz3v2ruOj6Pmlqbc_5ANXsNGTic";
    private static Retrofit retrofit = null;
    public RecipeListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding= DataBindingUtil.inflate(
                inflater, R.layout.fragment_recipe_list, container, false);
        View rootView = mBinding.getRoot();

        if (mBinding.tabletRecipeLayout!=null){
            mBinding.recipeList.setNumColumns(2);

            Log.d("aaa","tablet mode");
        }

        connectAndGetDataFromAPI();

        // Return the root view
        return rootView;
    }

    private void connectAndGetDataFromAPI() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        RecipeService recipeService = retrofit.create(RecipeService.class);
        Call<List<Recipe>> call = recipeService.getTheRecipe(ID);
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                final List<Recipe> recipeList =response.body();
                 //recipeList.get(0).

                mBinding.recipeList.setAdapter(
                        new RecipeAdapter(getContext(), R.layout.recipe_list_view_item_style,recipeList));

                mBinding.recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Gson gson = new Gson();
                        Type type = new TypeToken<List<Recipe>>() {}.getType();
                        String json = gson.toJson(recipeList.get(0), type);
                        Intent intent = new Intent(getContext(), DetailedRecipeStepFragment.class);
                        intent.putExtra("OBJ", json);
                    }
                });

            }


            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {

            }
        });

    }
}
