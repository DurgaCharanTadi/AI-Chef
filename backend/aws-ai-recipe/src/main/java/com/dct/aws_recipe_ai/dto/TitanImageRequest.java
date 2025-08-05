package com.dct.aws_recipe_ai.dto;

import lombok.Data;

@Data
public class TitanImageRequest {
    private String textPrompt;
    private int height = 512;
    private int width = 512;
    private int seed = 42;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public String getTextPrompt() {
        return textPrompt;
    }

    public void setTextPrompt(String textPrompt) {
        this.textPrompt = textPrompt;
    }
}
