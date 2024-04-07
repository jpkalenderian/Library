# Library Management System

This project is a Java-based library management system designed to manage books, users, and librarians efficiently. It provides functionalities for searching, borrowing, returning, and reserving books.

## Overview

The Library Management System is a command-line application developed in Java. It offers separate interfaces for librarians and users, allowing them to perform various tasks related to library management.

## Problem Statement

The project involves creating a library application with the following classes and interfaces:

Book: Represents a book with attributes such as ISBN, title, author, genre, availability, and reservation status.
User_Procedures: Interface defining user-related procedures.
Librarian_Procedures: Interface defining librarian-related procedures.
Person: Abstract class representing a person with attributes like name, age, and gender.
Librarian: Subclass of Person implementing Librarian_Procedures.
User: Subclass of Person implementing User_Procedures.

## Classes and Interfaces

Book Class: Represents a book entity with various attributes and functionalities.
User_Procedures Interface: Defines procedures for user interactions.
Librarian_Procedures Interface: Defines procedures for librarian interactions.
Person Class: Abstract class representing a person with basic attributes and methods.
Librarian Class: Subclass of Person implementing librarian-specific functionalities.
User Class: Subclass of Person implementing user-specific functionalities.

## Tools Used
Java for programming.
Swing for the user interface.
Github for version control and collaboration.

## Features

- **Book Management**: Add, search, borrow, return, and reserve books.
- **User Management**: Add and search users.
- **Librarian Management**: Add librarians and perform book-related tasks.
- **Exception Handling**: Handle exceptions for input validation.
- **Persistence**: Store data in files for retrieval on application restart.

## Getting Started

To run the application, follow these steps:

1. Clone the repository
2. Compile the Java files
3. Run the application

## Usage

Upon running the application, you will be prompted to choose whether you are a librarian or a user. Based on your choice, you will be presented with a menu of available actions to perform.

## Contributors

- Jean Paul Kalenderian (https://github.com/jpkalenderian): Librarian-side functionalities
- Jacob Sarian (https://github.com/JacobSarian): User-side functionalities

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
