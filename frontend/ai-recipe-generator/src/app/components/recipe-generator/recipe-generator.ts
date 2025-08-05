import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Recipe } from '../../services/recipe';
import { Image } from '../../services/image';
import { Navbar } from '../navbar/navbar';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatButtonModule} from '@angular/material/button';


@Component({
  selector: 'app-recipe-generator',
  standalone: true,
  imports: [CommonModule, FormsModule, Navbar, MatProgressSpinnerModule, MatButtonModule], 
  templateUrl: './recipe-generator.html',
  styleUrl: './recipe-generator.css'
})
export class RecipeGenerator {
  ingredients = '';
  recipe = '';
  imageBase64 = '';
  loading = false;

  constructor(
    private recipeService: Recipe,
    private imageService: Image
  ) {}

  generate() {
  this.loading = true;
  this.recipe = "";
  this.imageBase64 = "";
  this.recipeService.generateRecipe(this.ingredients).subscribe({
    next: (response) => {
      const contentArray = response.content;
      const recipeText = contentArray?.[0]?.text || 'No recipe found';
      this.recipe = recipeText;

      let title = 'Recipe';
      const match = recipeText.match(/Title:\s*(.+)/i);
      if (match) {
        title = match[1].split('\n')[0].trim();  // Only runs if match is not null
      } else {
        title = recipeText.split('\n')[0].trim();  // fallback for no "Title:" line
      }

      const cleanedTitle = title.includes(':') && title.split(':')[1]
        ? title.split(':')[1].trim()
        : title;

      const imagePrompt = `An artistic photo of ${cleanedTitle}, plated beautifully on a wooden table.`;
      console.log('Image prompt title:', cleanedTitle);

      this.imageService.generateImage(imagePrompt).subscribe({
        next: (imgResp) => {
          this.imageBase64 = imgResp.images?.[0] || '';
          this.loading = false;
        },
        error: () => {
          this.loading = false;
        }
      });
    },
    error: () => {
      this.loading = false;
    }
  });
}
}