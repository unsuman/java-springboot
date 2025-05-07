# Spring Boot Book Management Application(College Assignment)

## Overview
This Spring Boot application is designed to manage information about Books and Authors. It implements Create, Read, and Update operations for these entities using Spring MVC, JPA, and JSP views.

## Implementation Details

### Repository Layer
- `AuthorRepository`: Extends JpaRepository for Author entity
- `BookRepository`: Extends JpaRepository for Book entity with a custom query method to fetch books with authors

### Service Layer
- `AuthorService`: Business logic for Author entity operations
- `BookService`: Business logic for Book entity operations

### Controller Layer
- `AuthorController`: Handles HTTP requests for Author entity
- `BookController`: Handles HTTP requests for Book entity

### View Layer
- JSP pages for listing, adding, and editing books and authors
- Views are styled with CSS to enhance user experience

## Operations

### Create Operation
- Forms in JSP pages to add new authors and books
- Controllers handle form submissions and save new entities
- Exception handling for data integrity violations

### Read Operation
- JSP views displaying lists of all authors and books
- Custom query to fetch books with author details using JPA join
- Controllers bind data from service layer to JSP views

### Update Operation
- Forms to edit existing authors and books
- Controllers handle update requests and save changes to the database

## Database Configuration
The application uses an H2 in-memory database with JPA/Hibernate for ORM operations. Database tables are automatically created based on entity definitions.

## Running the Application
1. Ensure you have Java and Maven installed
2. Clone the repository
3. Run `mvn spring-boot:run` to start the application
4. Access the application at `http://localhost:8080`

## Database Initialization
The application automatically populates the database with 10 sample authors and 10 sample books upon startup.