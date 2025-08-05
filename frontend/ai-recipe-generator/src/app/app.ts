import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RecipeGenerator } from "./components/recipe-generator/recipe-generator";

@Component({
  selector: 'app-root',
  imports: [RecipeGenerator],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ai-recipe-generator');
}
