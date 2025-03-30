# 🗺️ Processing Map Data with Metadata

📍 Spring Boot application that processes and analyzes map locations with metadata using a database.

## 📖 Project Overview
This application allows users to:  
✅ **Add Location Data** (Single/Multiple)  
✅ **Add Metadata** (Single/Multiple)  
✅ **Get Evaluation Data** (Merged data, insights, and statistics)

## 🛠 Technologies Used
- **Spring Boot**
- **Spring Data JPA**
- **H2/MySQL Database**
- **Maven**
- **Postman**

## 🚀 How to Run the Project

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/premlalwani09/MapMetadata.git
cd MapMetadata
```

## 2️⃣ Configure Database (H2 or MySQL)
🔹 H2 (Default - In-Memory)
No setup needed.

🔹 MySQL (Optional) - Update application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/map_metadata
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
Replace yourpassword with your MySQL password.

## 3️⃣ Run the Application
- Using Maven:
```
mvn spring-boot:run
```
- Or using Java:
```
java -jar target/MapMetadata-0.0.1-SNAPSHOT.jar
```
The application starts on http://localhost:8080

## 🌍 API Endpoints
### 📌 1. Add Locations
- URL: POST /api/mapdata/location
- Request Body (Single Entry)
```
[
    { "id": "loc_01", "latitude": 37.7749, "longitude": -122.4194 }
]
```
- Request Body (Multiple Entries)
```
[
  { "id": "loc_01", "latitude": 37.7749, "longitude": -122.4194 },
  { "id": "loc_02", "latitude": 34.0522, "longitude": -118.2437 }
]
```
- Response:
```
{ "message": "Locations added successfully!" }
```

### 📌 2. Add Metadata
- URL: POST /api/mapdata/metadata
- Request Body (Single Entry)
```
[
    { "id": "loc_01", "type": "restaurant", "rating": 4.5, "reviews": 120 }
]
```
- Request Body (Multiple Entries)
```
[
  { "id": "loc_01", "type": "restaurant", "rating": 4.5, "reviews": 120 },
  { "id": "loc_02", "type": "hotel", "rating": 4.2, "reviews": 200 }
]
```
- Response:
```
{ "message": "Metadata added successfully!" }
```

### 📌 3. Get Evaluation Data
- URL: GET /api/mapdata/evaluation
- Response Example:
```
{
  "validPointsPerType": {
    "restaurant": 3,
    "hotel": 3,
    "cafe": 2
  },
  "averageRatingPerType": {
    "restaurant": 4.1,
    "hotel": 3.4,
    "cafe": 4.6
  },
  "highestReviewedLocation": {
    "id": "loc_06",
    "type": "hotel",
    "rating": 4.0,
    "reviews": 700
  },
  "incompleteData": [
    { "id": "loc_07", "type": "hotel", "rating": 2.0 }
  ]
}
```

## 🔥 Bonus Features
✅ **Merging locations & metadata**  
✅ **Counting valid points per category**     
✅ **Calculating average ratings per category**  
✅ **Finding highest reviewed location**     
✅ **Identifying incomplete data**   


