# Residential Dining Management System

## Project Overview

The Residential Dining Management System is a software solution designed to manage and streamline meal scheduling and dining logistics for residents. As a **Full Stack Developer**, I developed both the backend and frontend components to ensure a seamless user experience. The backend is powered by **Spring Boot (Java)**, while the frontend employs simple **HTML** for ease of use and accessibility.

---

## Features

### 1. User Management
- Add, edit, and remove user accounts.
- Manage user roles and permissions.

### 2. Menu Management
- Create and manage meal menus.
- Update menu items for different meal sessions (breakfast, lunch, dinner).

### 3. Meal Booking
- Schedule meal bookings for residents.
- Modify or cancel meal reservations.
- Display meal booking history for users.

### 4. Notifications
- Send automated email reminders for meal schedules.
- Notify users about booking updates or cancellations.

### 5. Simple Frontend Interface
- A clean and straightforward interface using HTML.
- User-friendly layout for accessing key features quickly.

---

## Tech Stack

### Backend
- **Spring Boot**: Core framework for RESTful APIs.
- **Spring Data JPA**: For database interaction.
- **Spring Security**: For secure user authentication and authorization.
- **Java Mail API**: For email notifications.

### Frontend
- **HTML**: For creating a simple and responsive interface.
- **CSS** (optional): Basic styling for layout and readability.

### Database
- **MySQL**: Used to store all user, menu, and booking data.

### Tools and Libraries
- **Maven**: For dependency management and build automation.
- **Lombok**: To reduce boilerplate code.
- **Swagger**: For API documentation and testing.

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/minhlong1802/QLyAnNoiTru.git
   ```

2. Navigate to the project directory:
   ```bash
   cd QLyAnNoiTru
   ```

3. Configure the database:
   - Update `application.properties` with your database connection details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/dining_management
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     ```

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   java -jar target/QLyAnNoiTru-0.0.1-SNAPSHOT.jar
   ```

6. Access the application:
   - Backend API: `http://localhost:8080/api`
   - Frontend: Open `index.html` in a web browser.

---

## API Endpoints

### User Management
- `POST /api/users` - Add a new user.
- `GET /api/users` - Retrieve all users.
- `PUT /api/users/{id}` - Update user details.
- `DELETE /api/users/{id}` - Remove a user.

### Menu Management
- `POST /api/menus` - Add a new menu.
- `GET /api/menus` - Retrieve all menus.
- `PUT /api/menus/{id}` - Update menu details.
- `DELETE /api/menus/{id}` - Remove a menu.

### Meal Booking
- `POST /api/bookings` - Create a new meal booking.
- `GET /api/bookings` - Retrieve all bookings.
- `PUT /api/bookings/{id}` - Modify a booking.
- `DELETE /api/bookings/{id}` - Cancel a booking.

---

## Contribution

If you want to contribute to this project:
1. Fork the repository.
2. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes and push to your branch:
   ```bash
   git commit -m "Add your message here"
   git push origin feature/your-feature-name
   ```
4. Create a pull request.

---

## Contact

If you have any questions or suggestions, feel free to contact me:
- **Email**: minhlong1802@example.com
- **GitHub**: [minhlong1802](https://github.com/minhlong1802)

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

