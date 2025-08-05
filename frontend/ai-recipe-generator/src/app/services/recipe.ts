import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Recipe {
  constructor(private http: HttpClient) {}

  generateRecipe(prompt: string) {
    return this.http.post<any>('https://m0lqevzm2g.execute-api.us-east-1.amazonaws.com/dev/api/recipe/generate', {
      anthropic_version: "bedrock-2023-05-31",
      messages: [
        {
          role: "user",
          content: `\n\nHuman: You are a culinary assistant. Generate a recipe using ${prompt}. Include title, ingredients, steps, and calories.\n\nAssistant:`
        }
      ],
      max_tokens: 1024,
      temperature: 0.7,
      top_k: 250,
      top_p: 0.9,
      stop_sequences: ["\n\nHuman:"]
    });
  }
}
