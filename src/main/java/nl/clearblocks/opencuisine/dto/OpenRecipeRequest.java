package nl.clearblocks.opencuisine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class OpenRecipeRequest implements Serializable {
    @JsonProperty
    private ArrayList<String> ingredients;

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
}
