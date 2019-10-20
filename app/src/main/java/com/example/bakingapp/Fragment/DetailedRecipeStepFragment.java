package com.example.bakingapp.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.bakingapp.Model.Recipe;
import com.example.bakingapp.R;
import com.example.bakingapp.databinding.FragmentDetailedRecipeStepFragmentBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class DetailedRecipeStepFragment extends Fragment {


    FragmentDetailedRecipeStepFragmentBinding mBinding;

    public DetailedRecipeStepFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_detailed_recipe_step_fragment, container, false);
        View rootView = mBinding.getRoot();

        Gson gson = new Gson();
        String stringLocation = getActivity().getIntent().getStringExtra("OBJ");
        if (stringLocation != null) {
            Type type = new TypeToken<List<Recipe>>() {
            }.getType();
            List<Recipe> objectLocations = gson.fromJson(stringLocation, type);
            Log.d("Location Count", Integer.toString(objectLocations.size()));
        } else {
            Log.d("Location Count", "failed");
        }
        // Return the root view
        return rootView;
    }

}
