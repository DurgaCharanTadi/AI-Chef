package com.dct.aws_recipe_ai.service;

import com.dct.aws_recipe_ai.dto.ClaudeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;

import java.nio.charset.StandardCharsets;


@Service
public class ClaudeService {

    private final BedrockRuntimeClient bedrockClient;
    private final ObjectMapper objectMapper;

    public ClaudeService() {
        this.bedrockClient = BedrockRuntimeClient.builder()
                .region(Region.US_EAST_1)  // or your preferred region
                .build();
        this.objectMapper = new ObjectMapper();
    }

    public String generateRecipe(ClaudeRequest requestDto) throws Exception {
    String body = objectMapper.writeValueAsString(requestDto);

    InvokeModelRequest request = InvokeModelRequest.builder()
            .modelId("anthropic.claude-3-haiku-20240307-v1:0")
            .contentType("application/json")
            .accept("application/json")
            .body(SdkBytes.fromString(body, StandardCharsets.UTF_8))
            .build();

    InvokeModelResponse response = bedrockClient.invokeModel(request);
    return response.body().asUtf8String();
}

}
