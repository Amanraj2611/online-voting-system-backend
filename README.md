# Online Voting System - Backend

A comprehensive full-stack voting platform backend built with **Spring Boot**, **JWT Authentication**, **MySQL**, and **REST APIs**. This system provides secure authentication, real-time vote processing, and robust data management for conducting fair and transparent online elections.

## 🎯 Features

- **Secure User Authentication**: JWT-based authentication with role-based access control
- **Real-time Vote Processing**: Efficient vote counting and result management
- **Voter Management**: Comprehensive voter registration and validation
- **Candidate Management**: Easy candidate setup and management
- **Election Management**: Create, manage, and monitor elections
- **Data Integrity**: PostgreSQL database with referential integrity constraints
- **RESTful APIs**: Well-documented REST API endpoints for frontend integration
- **Error Handling**: Comprehensive error handling and validation
- **Security**: CSRF protection, SQL injection prevention, and secure password handling

## 🛠 Tech Stack

### Backend
- **Framework**: Spring Boot 2.7.x
- **Security**: Spring Security + JWT (JSON Web Tokens)
- **Database**: PostgreSQL / MySQL with Hibernate ORM
- **Database Tools**: JDBC, HibernateJPA
- **Build Tool**: Maven
- **API Documentation**: Swagger/SpringFox
- **Testing**: JUnit 5, Mockito

## 📋 Prerequisites

- Java 11 or higher
- Maven 3.6+
- PostgreSQL 12+ or MySQL 5.7+
- Git

## 🚀 Getting Started

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/Amanraj2611/online-voting-system-backend.git
   cd online-voting-system-backend
   ```

2. **Configure Database**
   - Create a database for the voting system
   - Update `application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/voting_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   The server will start on `http://localhost:8080`

## 📁 Project Structure

```
src/main/java/
├── com/voting/
│   ├── config/          # Configuration classes
│   ├── controller/       # REST API endpoints
│   ├── service/          # Business logic
│   ├── repository/       # Database access layer
│   ├── model/            # Entity classes
│   ├── dto/              # Data Transfer Objects
│   ├── security/         # JWT and security configs
│   └── exception/        # Custom exceptions
```

## 🔐 API Endpoints

### Authentication
- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - User login
- `POST /api/auth/logout` - User logout

### Elections
- `GET /api/elections` - Get all elections
- `POST /api/elections` - Create new election (Admin only)
- `GET /api/elections/{id}` - Get election details
- `PUT /api/elections/{id}` - Update election
- `DELETE /api/elections/{id}` - Delete election

### Voting
- `POST /api/votes/cast` - Cast a vote
- `GET /api/votes/results/{electionId}` - Get election results
- `GET /api/votes/count/{candidateId}` - Get candidate vote count

## 🔄 Frontend Integration

This backend is designed to work seamlessly with the [Online Voting System Frontend](https://github.com/Amanraj2611/online-voting-system-frontend)

## 🧪 Testing

Run tests using Maven:
```bash
mvn test
```

## 📊 Database Schema

Key entities include:
- **Users**: Voter information and credentials
- **Elections**: Election details and metadata
- **Candidates**: Candidate information
- **Votes**: Vote records with timestamps
- **Roles**: User role definitions

## 🔒 Security Considerations

- JWT tokens expire after 24 hours
- Passwords are hashed using BCrypt
- CORS is configured for frontend domain
- Input validation on all endpoints
- SQL injection protection through parameterized queries

## 📝 Configuration

Key application properties in `application.properties`:
```properties
jwt.secret=your-secret-key
jwt.expiration=86400000
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit issues and pull requests.

## 📄 License

This project is open source and available under the MIT License.

## 👨‍💻 Author

**Aman Raj**
- GitHub: [@Amanraj2611](https://github.com/Amanraj2611)
- LinkedIn: [Aman Raj](https://linkedin.com/in/amanraj2611/)
- Email: rajaman2611@gmail.com

## 🙏 Acknowledgments

- Spring Boot community for excellent documentation
- MySQL and PostgreSQL for reliable database solutions
- JWT for secure authentication

---

**Last Updated**: April 2026
**Status**: Active Development
