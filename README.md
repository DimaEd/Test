Задача №1:
Скрипт для инициализации таблицы прикрепил.

Задача - вывести для каждой уникальной зарплаты первые три имени по алфавиту, которые её получают. Результат ожидается следующий:

SELECT salary, firstName
FROM
(SELECT distinct salary, firstName,
rank() OVER (PARTITION BY salary) AS pos
FROM users
) AS ss
WHERE pos < 4 order by salary, firstname;

Задача #2:
Выставить API, которое позволит реализовать аналог Google Forms.
Необходимый минимум по API:
1. Возможность через GET получить список вопросов и страниц формы (например, сначала юзер заполняет первую страницу со своими ФИО, почтой и прочим, нажимает "Далее" и попадает на вторую страницу, где уже следующие вопросы);
2. Возможность через POST отправить результаты заполненной формы

Всё это должно быть динамическим. То есть, формы подтягиваются из базы, в неё же сохраняются и результаты.
Фронт для этого не нужен - с головой достаточно рабочую БД и API, которое сможет с ней корректно работать.
Инициализация БД должна быть через Flyway.
Для сборки используй Gradle.

Из зависимостей советую не выходить за рамки: Spring Boot (Web, Data), Flyway, Postgres, Lombok.

