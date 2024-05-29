package nl.clearblocks.opencuisine.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public record OpenRecipeRequest(ArrayList<String> ingredients) {}
