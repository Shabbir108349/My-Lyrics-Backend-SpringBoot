# 🎵 My Lyrics — Backend (Spring Boot)

This is the backend service for **My Lyrics**, a lyrics-based web application.  
It is built using **Spring Boot** and **MongoDB**, providing REST APIs for songs, search, filtering, and admin operations.

---

## 🚀 Features

- 🔍 **Universal Search API**
  - Search by title, artist, genre, or language

- 🎵 **Song Management (Admin)**
  - Add new song
  - Edit song
  - Delete song
  - Get all songs / Manage all song

- 📂 **Category-Based Filtering**
  - Get songs by genre
  - Get popular songs
  - Home page limited results
  - Full list results

- 🎯 **Recommendation System**
  - Suggest songs based on genre (excluding current song)

- ▶️ **YouTube Integration**
  - Stores `videoId` for embedding videos in frontend

- 📄 **Lyrics Storage**
  - Supports multi-line lyrics
  - Stored as text in MongoDB

---

## 🛠️ Tech Stack

- Java 21+
- Spring Boot
- Spring Web
- Spring Data MongoDB
- MongoDB
- Lombok

---



## ⚙️ How to Run (Backend)

### ✅ Prerequisites

- Java 21+
- MongoDB installed and running

---

### ✅ Step 1: Clone Repository
```bash
git clone https://github.com/Shabbir108349/My-Lyrics-Backend-SpringBoot.git
```
```bash
cd My-Lyrics-Backend-SpringBoot
```


---

### ✅ Step 2: Configure MongoDB

Open `application.properties` and add these properties:
```bash
spring.data.mongodb.host = localhost
spring.data.mongodb.port = 27017
spring.data.mongodb.database = lyricsdb
```


👉 Make sure MongoDB is running locally

---

### ✅ Step 3: Run the Project

Maven Required for Run this server. Download Maven and 
Go to project directory Open Command prompt run the below command
```bash
mvn clean package
```
```bash
java -jar target/stream-0.0.1-SNAPSHOT.jar
```

### ✅ Step 4: Test API

Open browser or Postman:
```bash
http://localhost:8080/api/health
```
Expected: Ok
---

## 🔗 Frontend Repository

👉 Frontend Repo:  
https://github.com/Shabbir108349/My-Lyrics-Frontend-html-css-js

## 🔌 API Endpoints

| Feature                     | API Endpoint                                 |
|----------------------------|----------------------------------------------|
| 🔍 Universal Search        | GET /api/search?query=keyword                |
| 🎵 Get Song by ID          | GET /api/get-song-by-id/{songId}             |
| 🎵 Get Song by Genre       | GET /api/get-song-by-genre/{genre}           |
| 🎯 Get Recommended Songs   | GET /api/get-recommend-song/{genre}/{songId} |
| 🏠 Home Songs by Genre     | GET /api/v2/song/home/{genre}                |
| 🔥 Home Popular Songs      | GET /api/v2/song/home/popular                |
| 📃 List Songs by Genre     | GET /api/v2/song/list/{genre}                |
| 📃 List Popular Songs      | GET /api/v2/song/list/popular                |
| ➕ Add Song (Admin)        | POST /api/shabbir/add-song                   |
| 📥 Get All Songs (Admin)   | GET /api/shabbir/get-all-song                |
| ✏️ Update Song (Admin)     | PUT /api/shabbir/update-song-by-id/{songId}  |
| ❌ Delete Song (Admin)     | DELETE /api/shabbir/delete-song/{songId}     |
| ✅ Health Check            | GET /api/health                              |



---

## ⚠️ Important Notes

- CORS is enabled (`@CrossOrigin("*")`)
- Lyrics support multi-line format (`\n`)
- `videoId` must be valid YouTube ID
- MongoDB collection name: `songs`
- Also give some song for testing on frontend as a file name **song1.js and song2.js** 

---

## 🧠 Developer Notes

- Uses **regex-based search** for flexible matching
- Clean separation: Controller → Service → Repository
- Easy to extend with authentication (JWT)

---

## 📬 Contact

- GitHub: https://github.com/Shabbir108349
- Email: shabbirhassain24@gmail.com
- LinkedIn: https://linkedin.com/in/shabbir108349

---

## ⭐ Contribution

Feel free to fork and improve this project.

---

## 📜 License

This project is open-source and free to use.
