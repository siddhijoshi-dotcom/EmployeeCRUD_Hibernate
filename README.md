# Developer

👑 Project Leader: Siddhi Joshi

🤝 Contributor: Jagruti Joshi

---

# Project:EmployeeCRUD-Hibernate JPA

This project is a console-based Java application that demonstrates CRUD
operations using Hibernate 7.0.5 Final and JPA. It supports management of
Employee, Country, and Region entities with PostgreSQL as the backend.The
project uses a layered architecture and is developed using Spring Tool Suite with
Maven support.

---

# Features

* Menu-driven Java console application.
* CRUD operations for Employee, Country, and Region entities.
* JPA and Hibernate 7.0.5 Final used for ORM.
* PostgreSQL used as the database.
* Modular project structure with service and entity layers.
* Maven build support.

---

# Technologies Used

* Java 17
* Maven
* JPA (Jakarta Persistence API)
* Hibernate 7.0.5 Final
* PostgreSQL
* Spring Tool Suite (STS)

---

# Maven Dependencies

<dependencies>
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>7.0.5.Final</version>
    </dependency>
    <dependency>
        <groupId>jakarta.persistence</groupId>
        <artifactId>jakarta.persistence-api</artifactId>
        <version>3.1.0</version>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.3</version>
    </dependency>
</dependencies>
---

# Prerequisites

* Java JDK 17+
* PostgreSQL installed and running
* Spring Tool Suite (STS) or Eclipse IDE with Maven support
* Maven configured properly

---

# Database Setup

1. Open pgAdmin.
2. Create a new database (e.g., employee_crud_db).
3. Run the following SQL script:

CREATE TABLE region (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE country (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    region_id INTEGER REFERENCES region(id)
);

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    designation VARCHAR(100),
    salary DOUBLE PRECISION,
    country_id INTEGER REFERENCES country(id)
);
Update your persistence.xml with the correct username, password, and database URL.

---

# Project Screenshot
<img width="254" height="218" alt="image" src="https://github.com/user-attachments/assets/eba18cb7-a63a-4b92-b0c1-d3531bbab0f4" />



---

# License

This project is for educational use only.

---

# Contact

📧 Email: siddhijoshi0512@gmail.com


🐙 GitHub: siddhijoshi-dotcom
