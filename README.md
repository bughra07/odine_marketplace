# Odine Marketplace

## 📋 About the Project

`Odine Marketplace` is a demo application built with Spring Boot. It provides a basic RESTful service for interacting with job postings and freelancer profiles.

---

## 🛠️ Technology Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL 15**
- **Maven 3.8+**
- **Docker & Docker Compose**

---

## 🔑 Prerequisites

- **JDK 17** or higher
- **Maven 3.8+**
- **Docker & Docker Compose** (for the database container)
- **Git**
- **IntelliJ IDEA** (or your preferred IDE)

---

## 🚀 Quick Start

1. **Clone the repository**
   ```bash
   git clone https://github.com/<USERNAME>/odine-marketplace.git
   cd odine-marketplace
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Start the database**
   ```bash
   docker-compose up -d
   ```
   This will:
    - Launch PostgreSQL on `localhost:5432`
    - Create a database named `odine_db`
    - Create a user `odine` with password `secret`

4. **Open in IntelliJ**
    1. In IntelliJ: **File > Open…**, select the project folder.
    2. When prompted, **Import Maven Projects** and enable auto‑import.
    3. Set **Project SDK** to JDK 17.

5. **Run the application**
    - **In IntelliJ**: Right‑click `OdineMarketplaceApplication.java` → **Run 'OdineMarketplaceApplication'**
    - **From the terminal**:
      ```bash
      mvn spring-boot:run
      ```

6. **Health check**
   Open your browser and visit:
   ```
   http://localhost:8080/actuator/health
   ```
   You should see:
   ```json
   {"status":"UP"}
   ```

---

## ⚙️ Configuration

Edit `src/main/resources/application.properties` as needed:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/odine_db
spring.datasource.username=odine
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

If you run the database via Docker Compose, environment variables prefixed with `SPRING_DATASOURCE_*` will override these settings automatically.

To activate a Spring profile, add to your run configuration or environment:
```
-Dspring.profiles.active=dev
```

---

## 📡 API Endpoints

### Job Postings

| Method | URL              | Description                |
| ------ | ---------------- | -------------------------- |
| GET    | `/api/jobs`      | Retrieve all job postings  |
| POST   | `/api/jobs`      | Create a new job posting   |
| GET    | `/api/jobs/{id}` | Retrieve a specific job    |
| PUT    | `/api/jobs/{id}` | Update a job posting       |
| DELETE | `/api/jobs/{id}` | Delete a job posting       |

### Freelancer Profiles

| Method | URL                    | Description                       |
| ------ | ---------------------- | --------------------------------- |
| GET    | `/api/freelancers`     | Retrieve all freelancer profiles  |
| POST   | `/api/freelancers`     | Create a new freelancer profile   |
| GET    | `/api/freelancers/{id}`| Retrieve a specific profile       |
| PUT    | `/api/freelancers/{id}`| Update a freelancer profile       |
| DELETE | `/api/freelancers/{id}`| Delete a freelancer profile       |

### Comments

| Method | URL                   | Description             |
| ------ | --------------------- | ----------------------- |
| GET    | `/api/comments`       | Retrieve all comments   |
| POST   | `/api/comments`       | Create a new comment    |
| GET    | `/api/comments/{id}`  | Retrieve a specific comment |
| PUT    | `/api/comments/{id}`  | Update a comment        |
| DELETE | `/api/comments/{id}`  | Delete a comment        |

---

## 📁 Project Structure

```
odine-marketplace/
├── src/
│   ├── main/
│   │   ├── java/com/odine/marketplace/odine_marketplace
│   │   │   ├── controller/       # REST API controllers
│   │   │   ├── model/            # Entity and data model classes
│   │   │   ├── repository/       # Spring Data JPA repositories
│   │   │   └── service/          # Business logic layer
│   │   └── resources/
│   │       └── application.properties
│   └── test/                    # Unit and integration tests
├── pom.xml                      # Maven build configuration
├── docker-compose.yml           # PostgreSQL container settings
└── README.md                    # Project documentation
```

---

## ✅ Running Tests

Run all tests with:
```bash
mvn test
```

---

## 📞 Contact

**Muhammed Buğrahan Terlik**  
Email: muhammedbugrahan.terlik@std.yeditepe.edu.tr  
Phone: +90 532 363 3607
