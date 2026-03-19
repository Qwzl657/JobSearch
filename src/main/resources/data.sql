INSERT INTO users (name, email, phone, role) VALUES
                                                 ('Ali', 'ali@mail.com', '123', 'APPLICANT'),
                                                 ('Boss', 'boss@mail.com', '999', 'EMPLOYER');

INSERT INTO resumes (user_id, title, category) VALUES
                                                   (1, 'Java Dev', 'IT'),
                                                   (1, 'Backend Dev', 'IT');

INSERT INTO vacancies (user_id, title, category) VALUES
                                                     (2, 'Java Junior', 'IT'),
                                                     (2, 'Backend Intern', 'IT');

INSERT INTO responses (user_id, vacancy_id) VALUES
    (1, 1);