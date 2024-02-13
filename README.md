# MovieArchivesWebsiteProject

This project is a web-based movie archive website developed in Java using the Spring Boot framework. PostgreSQL database is utilized, and MVC design pattern is implemented.

## Features

- The website offers 3 different login methods:
  - User login
  - Admin login
  - Guest login

- The login page includes a "Register" button for user registration.

### Guest Login
- It is the lowest level of login type.
- Guests can search for movies and view the archive.

### User Login
- Users can search for movies and view the archive.
- Users can add movies to the archive, update, and delete movie information.

### Admin Login
- Admins can search for movies and view the archive.
- They have the authority to update and delete all movies.
- Admins can view the information of registered users.
- There is only one admin in the system, and their username and password are directly stored in the database. If another admin needs to be added, it should be done within the system itself.

### Other Features
- Another admin-user type exists, accessible through the admin login section. Admins can assign or revoke permissions to users using this system.

## Getting Started

1. Clone the project folder:
2. Install PostgreSQL database and configure the connection settings in the `application.properties` file.
3. Open the project files in an IDE and run the application.
