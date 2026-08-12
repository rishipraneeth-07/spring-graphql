# Spring GraphQL Student Management API

A backend application built with **Spring Boot and Spring for GraphQL** to explore and implement GraphQL concepts through a practical Student and Department Management API.

The project focuses on understanding how GraphQL works with Spring Boot, JPA, DTOs, validation, exception handling, pagination, sorting, and entity relationships.

---

##  Overview

This project is a learning-focused GraphQL backend that provides APIs for managing:

- Students
- Departments
- Student–Department relationships

Unlike traditional REST APIs where clients typically consume predefined endpoints and response structures, GraphQL allows clients to request exactly the fields they need through a strongly typed schema.

The project demonstrates how to build and structure a GraphQL API using Spring Boot and Spring Data JPA.

---

##  Features

### Student Management

- Create a student
- Get a student by ID
- Get all students
- Update student details
- Delete a student
- Assign a student to a department
- Change a student's department
- Prevent duplicate student emails

### Department Management

- Create a department
- Get a department by ID
- Get all departments
- Update department details
- Delete a department
- Prevent duplicate department names

### GraphQL Features

- Schema-first GraphQL development
- GraphQL Queries
- GraphQL Mutations
- GraphQL Input Types
- GraphQL Enums
- GraphQL Variables
- GraphQL Aliases
- GraphQL Fragments
- Pagination
- Sorting
- Nested object types
- Student–Department relationship

### Spring Boot Features

- Layered architecture
- DTO-based API design
- Service layer
- Repository layer
- Manual entity-to-DTO mapping
- Bean Validation
- Custom exceptions
- Global GraphQL exception handling
- Spring Data JPA
- MySQL persistence

---

## Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring for GraphQL | GraphQL API |
| Spring Data JPA | Data Access Layer |
| Hibernate | ORM |
| MySQL | Relational Database |
| Maven | Dependency Management |
| Lombok | Boilerplate Reduction |
| GraphiQL | GraphQL API Testing |
| Git & GitHub | Version Control |

---

## Future Learning

- @SchemaMapping
- N+1 query problem
- DataLoader
- GraphQL subscriptions
- Advanced filtering
- GraphQL directives
- Authentication and authorization
- GraphQL testing


##  Project Architecture

The project follows a layered backend architecture:

```text
                    GraphQL Client
                         │
                         ▼
                ┌─────────────────┐
                │ GraphQL Schema  │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │   Controller    │
                │ Query / Mutation│
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │     Service     │
                │ Business Logic  │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │   Repository    │
                │  Spring Data JPA│
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │      MySQL      │
                └─────────────────┘



