 Lesson 53 — REST API (Users, Resumes, Vacancies)

 Описание проекта

Данный проект представляет собой REST API для работы с пользователями, резюме и вакансиями.

Реализованы:
	•	CRUD операции
	•	валидация данных
	•	обработка ошибок
	•	работа с базой данных через JDBC
	•	логирование

⸻

 Используемые технологии
	•	Java 17+
	•	Spring Boot
	•	JdbcTemplate
	•	H2 Database
	•	Bean Validation (jakarta.validation)
	•	Lombok
	•	SLF4J (логирование)

⸻

 Архитектура проекта

Проект построен по слоям:
	•	Controller — обработка HTTP-запросов
	•	Service — бизнес-логика
	•	DAO — работа с базой данных
	•	Model — сущности
	•	Exception Handler — глобальная обработка ошибок

⸻

 REST API

 Users
	•	GET /users — получить список пользователей
	•	POST /users — создать пользователя
	•	PUT /users — обновить пользователя
	•	DELETE /users/{id} — удалить пользователя

⸻

 Resumes
	•	GET /resumes — получить все резюме
	•	POST /resumes — создать резюме
	•	PUT /resumes — обновить резюме
	•	DELETE /resumes/{id} — удалить резюме

⸻

 Vacancies
	•	GET /vacancies — получить все вакансии
	•	POST /vacancies — создать вакансию
	•	PUT /vacancies — обновить вакансию
	•	DELETE /vacancies/{id} — удалить вакансию

⸻

 Валидация

Используется Bean Validation:

Примеры:
	•	@NotBlank
	•	@Email
	•	@Size
	•	@Min / @Max
	•	@Pattern

Валидация работает через @Valid в контроллерах.

⸻

Обработка ошибок

Реализован глобальный обработчик:
	•	GlobalExceptionHandler

Поддерживаются:
	•	400 — Bad Request
	•	404 — Not Found
	•	500 — Server Error

Ошибки возвращаются в формате:
{
  "message": "Ошибка",
  "details": "Описание"
}
 База данных

Используется H2:

Таблицы:
	•	users
	•	resumes
	•	vacancies

Основные операции:
	•	CREATE
	•	INSERT
	•	SELECT
	•	UPDATE
	•	DELETE

Работа с БД осуществляется через JdbcTemplate.

⸻

 DAO слой

Каждая сущность имеет свой DAO:
	•	UserDao
	•	ResumeDa


# JobSearch REST API (Homework #50)

## Описание проекта
Данный проект является учебной реализацией REST API для системы поиска работы JobSearch.

Проект разработан на Spring Boot и реализует базовые REST-контроллеры для взаимодействия с системой:

- регистрация пользователей
- управление вакансиями
- управление резюме
- отклик на вакансии
- поиск пользователей
- загрузка аватара пользователя

Также в проект подключена документация API с использованием Swagger (OpenAPI).

---

## Используемые технологии

- Java
- Spring Boot
- REST API
- Swagger (OpenAPI)
- Maven

---

## Структура проекта

src/main/java/kg/attractor/lesson_49

controller  
- UserController  
- VacancyController  
- ResumeController  
- FileController  

service  
- UserService  
- VacancyService  
- ResumeService  

config  
- SwaggerConfig  

model  
dto  

---

## Запуск проекта

1. Клонировать репозиторий
2. Открыть проект в IDE
3. Запустить главный класс:

Lesson49Application

После запуска сервер будет доступен по адресу:

http://localhost:8080

---

## Swagger документация

Для просмотра и тестирования REST API используется Swagger.

Открыть в браузере:

http://localhost:8080/swagger-ui.html

Swagger автоматически покажет список всех доступных endpoints.

---

## Основные REST endpoints

### Пользователи

Создание пользователя

POST /users

Поиск работодателей

GET /users/employers

Поиск соискателей

GET /users/applicants

---

### Вакансии

Создание вакансии

POST /vacancies

Редактирование вакансии

PUT /vacancies/{id}

Удаление вакансии

DELETE /vacancies/{id}

Получение всех вакансий

GET /vacancies

Поиск вакансий по категории

GET /vacancies/category/{id}

Отклик на вакансию

POST /vacancies/{id}/respond

---

### Резюме

Создание резюме

POST /resumes

Редактирование резюме

PUT /resumes/{id}

Удаление резюме

DELETE /resumes/{id}

Получение всех резюме

GET /resumes

Поиск резюме по категории

GET /resumes/category/{id}

---

### Загрузка аватара

Загрузка изображения пользователя

POST /files/avatar

Тип запроса: multipart/form-data

Параметр:

file

---


## Примечание

Данный проект является учебной подготовкой к реализации полноценного backend-приложения JobSearch.

На следующих этапах будет добавлено:

- работа с базой данных
- полноценная бизнес-логика
- авторизация пользователей
- хранение файлов
- обработка откликов
