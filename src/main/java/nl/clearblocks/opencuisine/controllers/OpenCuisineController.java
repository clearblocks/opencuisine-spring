package nl.clearblocks.opencuisine.controllers;

import nl.clearblocks.opencuisine.dto.OpenRecipeRequest;
import nl.clearblocks.opencuisine.services.OpenCuisineService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenCuisineController {

    private final OpenCuisineService openCuisineService;

    public OpenCuisineController(OpenCuisineService openCuisineService) {
        this.openCuisineService = openCuisineService;
    }

    @PostMapping("/open-recipe")
    public HttpEntity<String> requestOpenRecipe(@RequestBody final OpenRecipeRequest openRecipeRequest) {
        openCuisineService.requestOpenRecipe(openRecipeRequest);
        return ResponseEntity.ok().build();
    }
}
