# 🍳 AI Chef

**AI Chef** is an AI-powered web application that generates delicious recipe suggestions and accompanying food images based on a list of ingredients provided by the user. Whether you're looking to whip up a quick meal with what's in your pantry or explore creative combinations, AI Chef has you covered.

---

## 🔗 Live Demo

🌐 [https://www.durgacharantadi.com/ai-recipegenerator/](https://www.durgacharantadi.com/ai-recipegenerator/)

---

## 🧠 Features

- ✅ **Smart Recipe Generation**  
  Enter a list of ingredients and receive a complete, well-structured recipe including cooking instructions.

- 🖼️ **AI-Generated Food Image**  
  Visualize the final dish with an AI-generated image that brings the recipe to life.

- 📱 **Responsive UI**  
  Enjoy a clean and user-friendly interface across all device types.

---

## 🛠 Tech Stack

| Layer        | Technology                         |
|--------------|-------------------------------------|
| Frontend     | Angular                             |
| Backend      | Spring Boot                         |
| AI Services  | Claude 3 (via Amazon Bedrock)       |
| Image Gen    | Titan Image Generator (via Bedrock) |
| Hosting      | AWS S3 + CloudFront                 |
| Serverless   | AWS Lambda                          |

---

## ⚙️ How It Works

1. **User Input**: Type in a list of ingredients (comma-separated).
2. **Recipe Generation**:  
   The app sends the input to **Claude 3 (Bedrock)** to generate a recipe with steps, preparation time, and more.
3. **Image Generation**:  
   The recipe is passed to **Amazon Titan Image Generator** to produce a realistic food image.
4. **Results Displayed**:  
   Both the recipe and the image are displayed side-by-side in the browser.

---

## 📁 Project Structure

This repository contains both the frontend and backend code:

- `/frontend` — Angular application
- `/backend` — Spring Boot backend with Bedrock integration

---

## 🧠 Powered By

- [Amazon Bedrock](https://aws.amazon.com/bedrock/)
  - **Claude 3** by Anthropic for recipe generation
  - **Titan Image Generator** for visual representation

---

## 📌 Notes

- Future enhancements will include advanced filtering, nutritional insights, and user accounts.
- Screenshots and demo video will be added soon.

---

## 📄 License

This project uses AWS AI services and is intended for educational and portfolio purposes only.

---


