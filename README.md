# URL Shortener

A simple URL shortener built with Java and Spring Boot.

## Table of Contents
-----------------

* [About](#about)
* [Features](#features)
* [Getting Started](#getting-started)
* [Endpoints](#endpoints)
* [Database](#database)
* [Security](#security)
* [Technology Stack](#technology-stack)
* [License](#license)
* [Contributing](#contributing)
* [Acknowledgments](#acknowledgments)

## About
--------

This project is a simple URL shortener that allows users to shorten long URLs and redirect to the original URL when the shortened URL is accessed. The project is built using Java and Spring Boot.

## Features
---------

* Shorten long URLs
* Redirect to the original URL when the shortened URL is accessed
* Basic statistics for each shortened URL (e.g. number of clicks, creation date)
* Support for custom short codes
* Support for URL validation and sanitization

## Getting Started
---------------

### Building the project

To build the project, run the following command:

mvn clean package


### Running the application

To run the application, you can use the following command:

mvn spring-boot:run


The application will be accessible at `http://localhost:8080`.

### Configuration

You can configure the application by modifying the `application.properties` file. For example, you can change the database connection settings or the short code length.

## Endpoints
---------

### Shorten a URL

* **POST /shorten**
	+ Request Body: `{"url": "https://example.com/long-url"}`
	+ Response: `{"shortCode": "abc123"}`

### Redirect to the original URL

* **GET /{shortCode}**
	+ Redirects to the original URL

### Get statistics for a shortened URL

* **GET /stats/{shortCode}**
	+ Response: `{"clicks": 10, "created_at": "2022-01-01T12:00:00Z"}`

### Get all shortened URLs

* **GET /urls**
	+ Response: `[{"shortCode": "abc123", "url": "https://example.com/long-url"},...]`

## Database
---------

The application uses a relational database to store the shortened URLs and their corresponding statistics. The database schema is defined in the `src/main/resources/db.sql` file.

## Security
---------

The application uses HTTPS to encrypt the communication between the client and the server. You can configure the SSL/TLS settings in the `application.properties` file.

## Technology Stack
-----------------

* Java 21
* Spring Boot 3.3.1
* Maven 3.9.6
* Apache Tomcat 10.1.26
* PostgreSQL 16.3
* Railway

## License
-------

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Contributing
------------

Contributions are welcome! If you'd like to contribute to the project, please fork the repository and submit a pull request.

## Acknowledgments
---------------

This project was inspired by the following resources:

* [Spring Boot documentation](https://spring.io/docs)
* [Java documentation](https://docs.oracle.com/en/java/)
