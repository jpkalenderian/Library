# Library Management System

This project is a Java-based library management system designed to manage books, users, and librarians efficiently. It provides functionalities for searching, borrowing, returning, and reserving books.

## Overview

The Library Management System is a GUI application developed in Java. It offers separate interfaces for librarians and users, allowing them to perform various tasks related to library management.

## Problem Statement

The project involves creating a library application with the following classes and interfaces:

Book: Represents a book with attributes such as ISBN, title, author, genre, availability, and reservation status.<br>
User_Procedures: Interface defining user-related procedures.<br>
Librarian_Procedures: Interface defining librarian-related procedures.<br>
Person: Abstract class representing a person with attributes like name, age, and gender.<br>
Librarian: Subclass of Person implementing Librarian_Procedures.<br>
User: Subclass of Person implementing User_Procedures.<br>

## Classes and Interfaces

Book Class: Represents a book entity with various attributes and functionalities.<br>
User_Procedures Interface: Defines procedures for user interactions.<br>
Librarian_Procedures Interface: Defines procedures for librarian interactions.<br>
Person Class: Abstract class representing a person with basic attributes and methods.<br>
Librarian Class: Subclass of Person implementing librarian-specific functionalities.<br>
User Class: Subclass of Person implementing user-specific functionalities.<br>

## Tools Used
- Java for programming.<br>
- Swing for the user interface.<br>
- GitHub for version control and collaboration.<br>

## Features

- **Book Management**: Add, search, borrow, return, and reserve books.<br>
- **User Management**: Add and search users.<br>
- **Librarian Management**: Add librarians and perform book-related tasks.<br>
- **Exception Handling**: Handle exceptions for input validation.<br>
- **Persistence**: Store data in files for retrieval on application restart.<br>

## Getting Started

To run the application, follow these steps:

1. Clone the repository<br>
2. Compile the Java files<br>
3. Run the application<br>

## Usage

Upon running the application, you will be prompted to choose whether you are a librarian or a user. Based on your choice, you will be presented with a menu of available actions to perform.

## Screenshots

![Main Form](/Screenshots/Mainform.png)<br>
![User Entry Form](/Screenshots/UserLoginForm.png)<br>
![Librarian Entry Form](/Screenshots/LibrarianLoginForm.png)<br>
![User Options Form](/Screenshots/UserOptionsForm.png)<br>
![Librarian Options Form](/Screenshots/LibrarianOptionsForm.png)<br>

These screenshots showcase the user interface of the library management system, providing an overview of its functionalities and design.

## Contributors

- Jean-Paul Kalenderian (https://github.com/jpkalenderian): Librarian-side functionalities
- Jacob Sarian (https://github.com/JacobSarian): User-side functionalities

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
