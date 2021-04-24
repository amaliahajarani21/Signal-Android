package org.thoughtcrime.securesms.recipeFeature;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.signal.core.util.logging.Log;
import org.thoughtcrime.securesms.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static androidx.core.content.ContextCompat.getSystemService;

public class RecipeParser {
    private ArrayList<Recipe> recipeData;

    public RecipeParser(){
        recipeData = new ArrayList<Recipe>();
    }

    public void getRecipes(FragmentActivity activity) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open("db-recipes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray recipeList = obj.getJSONArray("recipe");

            for (int i = 1; i < recipeList.length(); i++) {
                JSONObject recipeItem = recipeList.getJSONObject(i);

                //String recipeId = recipeItem.getString(String.valueOf(i));
                JSONObject recipeId = recipeItem.getJSONObject(String.valueOf(i));
                String id = recipeId.getString("id");
                String name = recipeId.getString("name");
                String source = recipeId.getString("source");
                String prepTime = recipeId.getString("preptime");
                String waitTime = recipeId.getString("waittime");
                String cookTime = recipeId.getString("cooktime");
                String servings = recipeId.getString("servings");
                String comments = recipeId.getString("comments");
                String instructions = recipeId.getString("instructions");
                String ingredients = recipeId.getString("ingredients");
                String tags = recipeId.getString("tags");
                String cal = recipeId.getString("calories");
                String carb = recipeId.getString("carbs");
                String fat = recipeId.getString("fat");
                String fiber = recipeId.getString("fiber");
                String satFat = recipeId.getString("satfat");
                String sugar = recipeId.getString("sugar");
                String protein = recipeId.getString("protein");

                Recipe temp = new Recipe(id, name, source, prepTime, waitTime, cookTime, servings,
                        comments, instructions, ingredients, tags, cal, carb, fat,
                        fiber, satFat,  sugar, protein);

                this.recipeData.add(temp);
                Log.i("This is ", temp.toString());
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showRecipe(Fragment context, View view) {
        Recipe randomRecipe = this.recipeData.get(4);
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(context.getContext(), LayoutInflater.class);
        View popupView = inflater.inflate(org.thoughtcrime.securesms.R.layout.recipe_layout, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        TextView nameView = popupView.findViewById(R.id.recipe_name);
        TextView sourceView = popupView.findViewById(R.id.recipe_source);
        nameView.setText(randomRecipe.getName());
        sourceView.setText(randomRecipe.getSource());
    }
}
