# Spring Boot CSRF Protection Demo

This is a sample Spring Boot application demonstrating **CSRF protection** using **Spring Security**.

## 🔐 Features

- CSRF protection using Spring Security (enabled by default)
- Simple login page with in-memory authentication
- Form submission with CSRF token
- Thymeleaf integration for CSRF token injection

## 🚀 How to Run

```bash
./mvnw spring-boot:run
```

Then access:  
🔗 `http://localhost:8080/login`

Use credentials:
```
Username: user
Password: password
```

Then go to:  
🔗 `http://localhost:8080/form`

## 📦 Dependencies

- Spring Boot 3.3.1
- Spring Security
- Thymeleaf
- Java 17+

## 🔐 How CSRF Works Here

- Spring Security automatically generates a CSRF token.
- Thymeleaf injects the token via:
  ```html
  <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
  ```
- Any POST request without the token is rejected with HTTP 403.

## License

MIT