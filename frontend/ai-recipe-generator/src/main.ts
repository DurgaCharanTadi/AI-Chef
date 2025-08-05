import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient, withFetch, withInterceptors } from '@angular/common/http';
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RecipeGenerator } from "./app/components/recipe-generator/recipe-generator";
import { provideRouter, Routes } from '@angular/router';

// Define your app's routes (can be empty for now)
const routes: Routes = [
  // { path: '', component: HomeComponent },
];

bootstrapApplication(RecipeGenerator, {
  providers: [
    provideRouter(routes),
    importProvidersFrom(FormsModule),
    provideHttpClient(withFetch())
  ]
}).catch(err => console.error(err));
