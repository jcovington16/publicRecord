# Political Accountability App

## 📌 Overview
The Political Accountability App is designed to **track and store data** about politicians, their voting history, proposed bills, news articles, and media coverage. The goal is to **provide transparency** by aggregating data from various sources and presenting it in a structured manner.

## 🏗️ Architecture
This application is built using a **microservices approach**, leveraging multiple technologies to store and process data efficiently.

### **Backend Stack**
- **Java/Kotlin (No Spring Boot)** –  Core backend services using Dropwizard for the API Gateway
- **Gradle (Kotlin DSL)** – Build tool
- **PostgreSQL** – Structured data storage (politicians, voting records, bills)
- **Elasticsearch** – Full-text search for news articles and social media content.
- **MinIO (S3-Compatible)** – Media storage for videos, audio, and images.
- **Kafka** – Event-driven architecture for data ingestion and processing
- **Redis** – Caching frequently accessed data

### **Microservices Structure**
| Module | Purpose |
|--------|---------|
| `api-gateway` | Exposes REST endpoints using Dropwizard; routes client requests. |
| `ingestion-service` | Scrapes data from news sources, government APIs, and social media |
| `processing-service` | Analyzes data, applies NLP for fact-checking, and enriches records |
| `storage-service` | Handles data storage (PostgreSQL/managed via Supabase), search (Elasticsearch), and media storage (MinIO). Also manages backend services via Dropwizard Managed objects. |
| `event-streaming` | Processes Kafka events for real-time updates. |
| `common` | Contains shared models, utilities, and configuration classes. |

## 🔹 Database Schema
### **Politicians Table**
```sql
CREATE TABLE politicians (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    full_name VARCHAR(255) NOT NULL,
    party VARCHAR(50),
    state VARCHAR(50),
    office VARCHAR(100),
    start_date DATE,
    end_date DATE NULL,
    profile_image_url TEXT,
    created_at TIMESTAMP DEFAULT NOW()
);
```

### **Voting Records Table**
```sql
CREATE TABLE voting_records (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    politician_id UUID REFERENCES politicians(id) ON DELETE CASCADE,
    bill_id UUID REFERENCES bills(id),
    vote_type VARCHAR(20) CHECK (vote_type IN ('YEA', 'NAY', 'ABSTAIN')),
    vote_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);
```

### **News Articles Table**
```sql
CREATE TABLE news_articles (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    politician_id UUID REFERENCES politicians(id) ON DELETE SET NULL,
    title TEXT NOT NULL,
    source VARCHAR(255) NOT NULL,
    published_date TIMESTAMP,
    url TEXT UNIQUE NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT NOW()
);
```

## 🚀 Running the Application
### **1️⃣ Set Up PostgreSQL**
```sh
docker run --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=secret -p 5432:5432 -d postgres
```

### **2️⃣ Set Up MinIO for Media Storage**
```sh
docker run -p 9000:9000 -p 9001:9001 \
  -e "MINIO_ROOT_USER=admin" -e "MINIO_ROOT_PASSWORD=secretpass" \
  quay.io/minio/minio server /data --console-address ":9001"
```

### **3️⃣ Run Kafka for Event Streaming**
```sh
docker-compose up -d kafka zookeeper
```

### **4️⃣ Build and Run Services**
```sh
./gradlew clean build
./gradlew :api-gateway:run
```

## 📡 API Endpoints
### **Get Politician Details**
```http
GET /api/politicians/{id}
```
Response:
```json
{
  "id": "1234-5678",
  "full_name": "John Doe",
  "party": "Independent",
  "state": "NY",
  "office": "Senator",
  "start_date": "2018-01-01",
  "end_date": null
}
```

### **Search News Articles**
```http
GET /api/news?query=tax+reform
```

## 👥 Contributors
- **Joshua Covington** – Lead Developer

## 📜 License
This project is licensed under the **MIT License**.

