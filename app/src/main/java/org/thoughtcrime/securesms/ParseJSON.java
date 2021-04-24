package org.thoughtcrime.securesms;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParseJSON {
    ArrayList<String> numberList = new ArrayList<>();

    // JSON Node names
    private static final String id = "id";
    private static final String name = "name";
    private static final String source = "source";
    private static final String prepTime = "preptime";
    private static final String waitTime = "waittime";
    private static final String cookTime = "cooktime";
    private static final String servings = "servings";
    private static final String comments = "comments";
    private static final String calories = "calories";
    private static final String fat = "fat";
    private static final String satFat = "satfat";
    private static final String carbs = "carbs";
    private static final String fiber = "fiber";
    private static final String sugar = "sugar";
    private static final String protein = "protein";
    private static final String instructions = "instructions";
    private static final String ingredients = "ingredients";
    private static final String tags = "tags";

    public static String get_json(Context context, String fileName) {
        String json;
        try
        {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read();
            is.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public void getRecipe() {
        return;
        // Storing each json item in variable
//                String name = c.getString(this.name);
//                String source = c.getString(this.source);
//                String prepTime = c.getString(this.prepTime);
//                String waitTime = c.getString(this.waitTime);
//                String cookTime = c.getString(this.cookTime);
//                String servings = c.getString(this.servings);
//                String comments = c.getString(this.comments);
//                String calories = c.getString(this.calories);
//                String fat = c.getString(this.fat);
//                String satFat = c.getString(this.satFat);
//                String carbs = c.getString(this.carbs);
//                String fiber = c.getString(this.fiber);
//                String sugar = c.getString(this.sugar);
//                String protein = c.getString(this.protein);
//                String instruction = c.getString(this.instructions);
//                String ingredients = c.getString(this.ingredients);
//                String tags = c.getString(this.tags);
//                Log.d("Recipee Name:", name);

    }
}
