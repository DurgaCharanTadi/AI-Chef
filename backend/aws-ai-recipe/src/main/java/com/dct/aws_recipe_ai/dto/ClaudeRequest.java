package com.dct.aws_recipe_ai.dto;

import java.util.List;

public class ClaudeRequest{
    private String anthropic_version = "bedrock-2023-05-31";  // Required!
    private List<Message> messages;
    private Integer max_tokens;
    private Double temperature;
    private Double top_p;
    private Integer top_k;
    private List<String> stop_sequences;

    // Getters and setters...

    public static class Message {
        private String role;
        private String content;

        // Getters and setters...
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }

    // Getters and setters for ClaudeMessageRequest...

    public String getAnthropic_version() { return anthropic_version; }
    public void setAnthropic_version(String anthropic_version) { this.anthropic_version = anthropic_version; }

    public List<Message> getMessages() { return messages; }
    public void setMessages(List<Message> messages) { this.messages = messages; }

    public Integer getMax_tokens() { return max_tokens; }
    public void setMax_tokens(Integer max_tokens) { this.max_tokens = max_tokens; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getTop_p() { return top_p; }
    public void setTop_p(Double top_p) { this.top_p = top_p; }

    public Integer getTop_k() { return top_k; }
    public void setTop_k(Integer top_k) { this.top_k = top_k; }

    public List<String> getStop_sequences() { return stop_sequences; }
    public void setStop_sequences(List<String> stop_sequences) { this.stop_sequences = stop_sequences; }

}
