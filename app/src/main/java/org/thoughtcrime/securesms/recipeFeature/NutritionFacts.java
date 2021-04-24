package org.thoughtcrime.securesms.recipeFeature;

public class NutritionFacts {
    private String calories;
    private String fat;
    private String satFat;
    private String carbs;
    private String fiber;
    private String sugar;
    private String protein;

    public NutritionFacts(String cal, String carb, String fat, String fiber, String satFat,  String sugar, String protein) {
        this.calories = cal;
        this.carbs = carb;
        this.fat = fat;
        this.fiber = fiber;
        this.satFat = satFat;
        this.sugar = sugar;
        this.protein = protein;
    }

    public String toString() {
        return "Nutrition Debug: " + this.calories + " " + this.fat;
    }
}
