package com.example.bakingapp;

import com.example.bakingapp.Model.Recipe;
import com.example.bakingapp.Model.Step;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeService {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<Recipe>> getTheRecipe(@Query("fbclid") String id);

}
