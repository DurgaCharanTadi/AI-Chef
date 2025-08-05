package com.dct.aws_recipe_ai.controller;

import com.dct.aws_recipe_ai.dto.ClaudeRequest;
import com.dct.aws_recipe_ai.service.ClaudeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeController {

    @Autowired
    private ClaudeService claudeService;

    @PostMapping("/api/recipe/generate")
    public ResponseEntity<?> generateRecipe(@RequestBody ClaudeRequest requestDto) {
        try {
            String output = claudeService.generateRecipe(requestDto);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

}
