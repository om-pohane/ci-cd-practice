# Student CRUD API (Spring Boot practice)

A simple REST API for students with **soft delete**.
Soft delete means the student is not removed from the database. We only set `deleted = true`,
so the student can be restored later.

## How to run

1. Fill in the MySQL details in `src/main/resources/application.properties`
   (`spring.datasource.url`, `username`, `password`).
2. Run `./mvnw spring-boot:run`.
3. The API runs at `http://localhost:8080`. The `students` table is created automatically.

## Files

| File | What it does |
|------|--------------|
| `entity/Student.java` | The Student class, mapped to the `students` table |
| `repository/StudentRepository.java` | Talks to the database (JPA) |
| `service/StudentService.java` | The logic: create, update, soft delete, restore |
| `controller/StudentController.java` | The REST URLs |

Flow of a request: **Controller -> Service -> Repository -> Database**

## APIs

| Method | URL | What it does |
|--------|-----|--------------|
| POST   | `/api/students` | Create a student |
| GET    | `/api/students` | Get all active students |
| GET    | `/api/students/{id}` | Get one student by id |
| GET    | `/api/students/search?course=BSc` | Get students of a course |
| PUT    | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Soft delete a student |
| GET    | `/api/students/deleted` | Get all deleted students |
| PUT    | `/api/students/{id}/restore` | Restore a deleted student |

Example JSON body for POST and PUT:

```json
{
  "name": "Riya",
  "email": "riya@mail.com",
  "age": 20,
  "course": "BSc"
}
```

If a student is not found you get **404** with a message like `"Student not found with id 5"`.

## Try it with curl (or use Postman)

```bash
curl -X POST http://localhost:8080/api/students -H "Content-Type: application/json" -d '{"name":"Riya","email":"riya@mail.com","age":20,"course":"BSc"}'

curl http://localhost:8080/api/students
curl http://localhost:8080/api/students/1
curl "http://localhost:8080/api/students/search?course=BSc"

curl -X PUT http://localhost:8080/api/students/1 -H "Content-Type: application/json" -d '{"name":"Riya Shah","email":"riya@mail.com","age":21,"course":"BSc"}'

curl -X DELETE http://localhost:8080/api/students/1
curl http://localhost:8080/api/students/deleted
curl -X PUT http://localhost:8080/api/students/1/restore
```
