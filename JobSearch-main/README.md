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
