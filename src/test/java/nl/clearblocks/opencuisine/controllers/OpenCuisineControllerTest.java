package nl.clearblocks.opencuisine.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.clearblocks.opencuisine.dto.OpenRecipeRequest;
import nl.clearblocks.opencuisine.services.OpenCuisineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@WebMvcTest(OpenCuisineController.class)
@ExtendWith(MockitoExtension.class)
public class OpenCuisineControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OpenCuisineService openCuisineService;

    @Test
    void testRequestOpenRecipe() throws Exception {
        OpenRecipeRequest request = new OpenRecipeRequest(new ArrayList<>(Arrays.asList("a", "b", "c")));

        // Perform the POST request to /open-recipe endpoint
        mockMvc.perform(post("/open-recipe")
                        .contentType("application/json")
                        .content((new ObjectMapper()).writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify that openCuisineService.requestOpenRecipe is called once with the provided OpenRecipeRequest
        verify(openCuisineService, times(1)).requestOpenRecipe(request);
    }
}
