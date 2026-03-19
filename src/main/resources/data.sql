INSERT INTO users (name, surname, age, email, password, phone_number, avatar, account_type)
VALUES
    ('Ali', 'Dev', 22, 'ali@mail.com', '123', '123', 'avatar1.png', 'APPLICANT'),
    ('Boss', 'HR', 35, 'boss@mail.com', '123', '999', 'avatar2.png', 'EMPLOYER');

INSERT INTO resumes (user_id, name, category)
VALUES
    (1, 'Java Dev', 'IT'),
    (1, 'Backend Dev', 'IT');

INSERT INTO vacancies (user_id, name, category)
VALUES
    (2, 'Java Junior', 'IT'),
    (2, 'Backend Intern', 'IT');

INSERT INTO responses (user_id, vacancy_id)
VALUES
    (1, 1);