package com.dct.aws_recipe_ai.controller;

import com.dct.aws_recipe_ai.dto.TitanImageRequest;
import com.dct.aws_recipe_ai.service.TitanImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/image")
public class TitanImageController {

    private final TitanImageService titanImageService;

    public TitanImageController(TitanImageService titanImageService) {
        this.titanImageService = titanImageService;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateImage(@RequestBody TitanImageRequest request) {
        try {
            String result = titanImageService.generateImage(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
