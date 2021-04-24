package org.thoughtcrime.securesms.recipeFeature;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.thoughtcrime.securesms.R;

import static androidx.core.content.ContextCompat.getSystemService;

public class Recipe {
    private String id;
    private String name;
    private String source;
    private String prepTime;
    private String waitTime;
    private String cookTime;
    private String servings;
    private String comments;
    private String instructions;
    private String ingredients;
    private String tags;
    private NutritionFacts nutritionFacts;

    public Recipe(){}
    public Recipe(String id, String name, String source, String prepTime,
                   String waitTime, String cookTime, String servings,
                   String comments, String instructions, String ingredients,
                   String tags, String cal, String carb, String fat,
                   String fiber, String satFat,  String sugar, String protein) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.prepTime = prepTime;
        this.waitTime = waitTime;
        this.cookTime = cookTime;
        this.servings = servings;
        this.comments = comments;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.tags = tags;
        this.nutritionFacts = new NutritionFacts(cal, carb, fat, fiber, satFat,  sugar, protein);
    }

    public String getComments() {
        return comments;
    }

    public String getCookTime() {
        return cookTime;
    }

    public String getId(){
        return  this.id;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public String getServings() {
        return servings;
    }

    public String getSource() {
        return source;
    }

    public String getWaitTime() {
        return waitTime;
    }

    public String getTags() {
        return tags;
    }

    public  String toString () {
        return "Recipe debug " + this.name;
    }
}
