package com.example.bakingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipe {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("ingredients")
    private List<Ingrediants> ingrediants;
    @SerializedName("steps")
    private List<Step> steps;
    @SerializedName("servings")
    private int servings;
    @SerializedName("image")
    private String image;

    public Recipe(int id, String name, List<Ingrediants> ingrediants, List<Step> steps, int servings, String image) {
        this.id = id;
        this.name = name;
        this.ingrediants = ingrediants;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingrediants> getIngrediants() {
        return ingrediants;
    }

    public void setIngrediants(List<Ingrediants> ingrediants) {
        this.ingrediants = ingrediants;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
