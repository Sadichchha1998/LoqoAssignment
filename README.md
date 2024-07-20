# LoqoAssignment
# Product API with Spring Boot and MongoDB

This project is a RESTful API built with Spring Boot that interacts with a MongoDB database to provide filtering and sorting functionality for product records.

## Features

- Filter products by category, price range, and stock availability
- Sort products by price, rating, or creation date
- RESTful API design
- MongoDB integration
- Sample data loader for testing

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- MongoDB 4.4 or higher

## Setup

The application will start on `http://localhost:8080`.

## API Endpoints

- `GET /products`: Fetch products with optional filtering and sorting

Query Parameters:
- `category`: Filter by product category
- `minPrice`: Filter by minimum price
- `maxPrice`: Filter by maximum price
- `inStock`: Filter by stock availability (true/false)
- `sortField`: Field to sort by (price, rating, or createdAt)
- `sortOrder`: Sort order (asc or desc, default is asc)

## Sample Requests

1. Get all products:
GET
 http://localhost:8080/products
2. Filter by category and price range, sort by price ascending:
 http://localhost:8080/products?category=electronics&minPrice=100&maxPrice=1000&sortField=price&sortOrder=asc
3. Filter in-stock items, sort by rating descending:
 http://localhost:8080/products?inStock=true&sortField=rating&sortOrder=desc
## Project Structure
src
├── main
│   ├── java
│   │   └── com
│   │       └── loqo
│   │           └── productapi
│   │               ├── config
│   │               │   └── DataLoader.java
│   │               ├── controller
│   │               │   └── ProductController.java
│   │               ├── model
│   │               │   └── Product.java
│   │               ├── repository
│   │               │   └── ProductRepository.java
│   │               ├── service
│   │               │   └── ProductService.java
│   │               └── ProductApiApplication.java
│   └── resources
│       └── application.properties

└── test
└── java
└── com
└── loqo
└── productapi
└── ProductApiApplicationTests.java

## Technologies Used

- Spring Boot 2.7.5
- Spring Data MongoDB
- Java 11
- Maven
- MongoDB
- Lombok
