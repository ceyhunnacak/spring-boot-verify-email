# LoginJWT - JWT-Based Authentication System

This project is a JWT (JSON Web Token) based authentication system developed using Spring Boot. It includes user registration, login, email verification, and secure API access features.

## 🚀 Features

- **User Registration**: New users can register to the system
- **JWT-Based Authentication**: Secure token-based session management
- **Email Verification**: Email verification system after registration
- **Verification Code Resend**: Ability to resend verification codes
- **PostgreSQL Database**: Reliable data storage
- **Spring Security**: Security layer
- **Lombok**: Code reduction

## 🛠️ Technologies

- **Java 24**
- **Spring Boot 3.5.4**
- **Spring Security**
- **Spring Data JPA**
- **PostgreSQL**
- **JWT (JSON Web Token)**
- **Spring Mail**
- **Lombok**
- **Maven**

## 📋 Requirements

- Java 24 or higher
- Maven 3.6+
- PostgreSQL database
- Gmail SMTP account (for email sending)

## ⚙️ Installation

### 1. Clone the Project

```bash
git clone https://github.com/ceyhunnacak/spring-boot-verify-email.git
cd spring-boot-verify-email
```

### 2. Prepare the Database

Create a new database in PostgreSQL:

```sql
CREATE DATABASE spring_boot_verify_email;
```

### 3. Configure Environment Variables

Create a `.env` file in the project root directory:

```properties
# Database Settings
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/spring_boot_verify_email
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password

# JWT Settings
JWT_SECRET_KEY=your_jwt_secret_key_here_make_it_long_and_secure

# Email Settings
SUPPORT_EMAIL=your_email@gmail.com
APP_PASSWORD=your_gmail_app_password
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

The application will run on `http://localhost:8080` by default.

## 📚 API Endpoints

### Authentication Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/signup` | New user registration |
| POST | `/auth/login` | User login |
| POST | `/auth/verify` | Email verification |
| POST | `/auth/resend` | Resend verification code |

### User Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users/me` | Current user profile (authentication required) |
| GET | `/users/` | Get all users (authentication required) |

## 🔧 Usage Examples

### User Registration

```bash
curl -X POST http://localhost:8080/auth/signup \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "email": "test@example.com",
    "password": "password123"
  }'
```

### User Login

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "testuser",
    "password": "password123"
  }'
```

### Email Verification

```bash
curl -X POST http://localhost:8080/auth/verify \
  -H "Content-Type: application/json" \
  -d '{
    "email": "test@example.com",
    "verificationCode": "123456"
  }'
```

### Resend Verification Code

```bash
curl -X POST "http://localhost:8080/auth/resend?email=test@example.com"
```

## 🔐 Security

- **JWT Token**: Secure token-based authentication
- **Password Hashing**: Secure password storage with Spring Security
- **Email Verification**: Email verification for account activation
- **CORS**: Cross-Origin Resource Sharing configuration

## 📁 Project Structure

```
src/main/java/com/ceyhunnacak/loginjwt/
├── config/          # Configuration classes
├── controller/      # REST API controllers
├── dto/            # Data Transfer Objects
├── model/          # Database models
├── repository/     # Data access layer
├── responses/      # API response models
├── service/        # Business logic layer
└── LoginJwtApplication.java
```

## 🧪 Testing

To test the application:

```bash
mvn test
```

## 📝 License

This project is licensed under the MIT License.

## 👨‍💻 Developer

**Ceyhun Nacak**

## 🤝 Contributing

1. Fork this repository
2. Create a new branch (`git checkout -b feature/new-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/new-feature`)
5. Create a Pull Request

## 📞 Contact

For questions: ceyhunnacak6@gmail.com

---

**Note**: This project is developed for educational purposes. Please review security settings before using in production environment. 