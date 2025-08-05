package com.dct.aws_recipe_ai.service;

import com.dct.aws_recipe_ai.dto.TitanImageRequest;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class TitanImageService {

    private final BedrockRuntimeClient bedrockClient;
    private final ObjectMapper objectMapper;

    public TitanImageService() {
        this.bedrockClient = BedrockRuntimeClient.builder()
                .region(Region.US_EAST_1)  // Required for Bedrock
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public String generateImage(TitanImageRequest request) throws Exception {
        Map<String, Object> payload = new HashMap<>();
        payload.put("taskType", "TEXT_IMAGE");
        payload.put("textToImageParams", Map.of("text", request.getTextPrompt()));
        payload.put("imageGenerationConfig", Map.of(
                "numberOfImages", 1,
                "height", request.getHeight(),
                "width", request.getWidth(),
                "seed", request.getSeed()
        ));

        String body = objectMapper.writeValueAsString(payload);

        InvokeModelRequest modelRequest = InvokeModelRequest.builder()
                .modelId("amazon.titan-image-generator-v1")
                .contentType("application/json")
                .accept("application/json")
                .body(SdkBytes.fromString(body, StandardCharsets.UTF_8))
                .build();

        InvokeModelResponse response = bedrockClient.invokeModel(modelRequest);
        return response.body().asUtf8String(); // Contains base64-encoded image
    }
}
