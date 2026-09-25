# QUIZ-APP
# QuizPro - Online Assessment Platform

A full-stack web application for automated quiz creation, 
examination, and instant result evaluation.

## Features

- **Admin Dashboard** - View question statistics and manage quizzes
- **Question Bank** - Browse questions by category (Java, Python)
- **Dynamic Quiz Generation** - Randomly selects questions from database
- **Secure Exam Interface** - Questions without answers sent to client
- **Auto-Scoring Engine** - Instant result calculation upon submission
- **Performance Analytics** - Correct/incorrect breakdown with percentage

## Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Java 17, Spring Boot 3, Spring MVC |
| Database | PostgreSQL, Spring Data JPA, Hibernate |
| API | RESTful APIs with JSON responses |
| Frontend | HTML5, CSS3, JavaScript (SPA) |
| Build | Maven |
| Testing | Postman |

## Architecture

Controller → Service → Repository → Database (3-Layer MVC)

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /question/allQuestions | Fetch all questions |
| GET | /question/category/{cat} | Filter by category |
| POST | /question/add | Add new question |
| POST | /quiz/create | Generate quiz |
| GET | /quiz/get/{id} | Get quiz (no answers) |
| POST | /quiz/submit/{id} | Submit & get score |

## Setup

1. Clone repository
2. Configure PostgreSQL in application.properties
3. Run: mvn spring-boot:run
4. Open: http://localhost:8080

## Screenshots

<img width="1901" height="897" alt="Screenshot 2026-09-25 132803" src="https://github.com/user-attachments/assets/c94371ed-5fe9-443a-96ca-30f9121e59e0" />

<img width="1742" height="887" alt="Screenshot 2026-09-25 132821" src="https://github.com/user-attachments/assets/dd2ea7ff-8b1d-43fe-bc3c-fcdbf4adee8e" />

<img width="1751" height="897" alt="Screenshot 2026-09-25 132833" src="https://github.com/user-attachments/assets/6cd09ccd-cdc5-4573-ae98-c41ec691757e" />

<img width="1771" height="890" alt="Screenshot 2026-09-25 132902" src="https://github.com/user-attachments/assets/5df22af5-9faf-4587-b082-a4ad7a247450" />

<img width="1763" height="902" alt="Screenshot 2026-09-25 132927" src="https://github.com/user-attachments/assets/fcaf948e-11b5-4618-be62-e79c819a7115" />





