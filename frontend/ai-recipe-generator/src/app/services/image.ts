import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Image {
  constructor(private http: HttpClient) {}

  generateImage(prompt: string) {
    console.log('Image Prompt Payload:', { textPrompt: prompt });

    // ✅ Updated payload format to match backend expectations
    return this.http.post<any>('https://m0lqevzm2g.execute-api.us-east-1.amazonaws.com/dev/api/image/generate', {
      textPrompt: prompt
    });
  }
}