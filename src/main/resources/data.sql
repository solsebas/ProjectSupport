-- ROLE TABLE --
INSERT INTO public.role(id, name) VALUES (1, 'ROLE_USER');
INSERT INTO public.role(id, name) VALUES (2, 'ROLE_SUPERVISOR');
INSERT INTO public.role(id, name) VALUES (3, 'ROLE_ADMIN');

-- USERS TABLE --
INSERT INTO public.users(id, email, password, username) VALUES (1, 'admin@admin.pl', '$2a$10$DgtQ/lChSYbtPfMxofKXxeCN6Bnrvz6ILXU2jtjTLBjj370DBYm4y', 'admin'); -- PASSWORD = 'admin123'
INSERT INTO public.users(id, email, password, username) VALUES (2, 'sawicki@supervisor.pl', '$2a$10$9c9iiVRn6gLaoi5rJFS6MezLeIpQjyyWsqsG6/OnPpnlL6rgSOvsa', 'sawicki'); -- PASSWORD = 'sawicki'
INSERT INTO public.users(id, email, password, username) VALUES (3, 'drabik@supervisor.pl', '$2a$10$zOutCPSe9TX0J6N5rpiO0e9Gg8PYvQzA4wv0UEENMFkbpkUVWLy5G', 'drabik'); -- PASSWORD = 'drabik'
INSERT INTO public.users(id, email, password, username) VALUES (4, 'szymon@admin.pl', '$2a$10$rEis8WZsMLzw6Vj8s7NJHu./Pgz03tMdaGX2F3.6cDYjaJSq3lVW.', 'szymon'); -- PASSWORD = '12345678'
INSERT INTO public.users(id, email, password, username) VALUES (5, 'marcel@admin.pl', '$2a$10$rEis8WZsMLzw6Vj8s7NJHu./Pgz03tMdaGX2F3.6cDYjaJSq3lVW.', 'marcel'); -- PASSWORD = '12345678'
INSERT INTO public.users(id, email, password, username) VALUES (6, 'seba@admin.pl', '$2a$10$rEis8WZsMLzw6Vj8s7NJHu./Pgz03tMdaGX2F3.6cDYjaJSq3lVW.', 'seba'); -- PASSWORD = '12345678'

-- USERS_ROLES TABLE --
INSERT INTO public.user_roles(user_id, role_id) VALUES (1, 3);
INSERT INTO public.user_roles(user_id, role_id) VALUES (2, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (3, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (4, 1);
INSERT INTO public.user_roles(user_id, role_id) VALUES (5, 1);
INSERT INTO public.user_roles(user_id, role_id) VALUES (6, 1);

-- STUDENT TABLE --
INSERT INTO public.student(student_id, first_name, surname, user_id) VALUES (1, 'Szymon', 'Palka', 4); 		-- STUDENT INFORMATYKI 2023 SEM 2 			-- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.student(student_id, first_name, surname, user_id) VALUES (2, 'Marcel', 'Furs', 5); 		-- STUDENT INFORMATYKI 2023 SEM 2 			-- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.student(student_id, first_name, surname, user_id) VALUES (3, 'Sebastian', 'Sołtysik', 6); 	-- STUDENT Automatyka i Robotyka 2023 SEM 2 	-- TERM 10, 'Automatyka i Robotyka', 2, 2023

-- SUPERVISOR TABLE --
INSERT INTO public.supervisor(supervisor_id, first_name, surname, user_id) VALUES (1, 'Michał', 'Sawicki', 2);
INSERT INTO public.supervisor(supervisor_id, first_name, surname, user_id) VALUES (2, 'Gabriel', 'Drabik', 3);


-- TOPIC TABLE --
INSERT INTO public.topic(topic_id, name, supervisor_id, description) VALUES (1, 'Android app', 1, 'Aplikacja która ma być napisana na androida');
INSERT INTO public.topic(topic_id, name, supervisor_id, description) VALUES (2, 'iOS app', 1, 'Aplikacja która ma być napisana na iOS');
INSERT INTO public.topic(topic_id, name, supervisor_id, description) VALUES (3, 'Android i iOS app', 1, 'Aplikajca która ma działać na androidzie i iOS');
INSERT INTO public.topic(topic_id, name, supervisor_id, description) VALUES (4, 'Z80', 2, 'Obsługa przerwań w procesorze Z80');
INSERT INTO public.topic(topic_id, name, supervisor_id, description) VALUES (5, '8051', 2, 'Obsługa przerwań w procesorze 8051');
INSERT INTO public.topic(topic_id, name, supervisor_id, description) VALUES (6, 'Liczniki i dzielnkiki', 2, 'Licznik mod7 oraz mod10');

-- TERM TABLE --
INSERT INTO public.term(term_id, major, term_number, year) VALUES (1, 'Informatyka', 1, 2022);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (2, 'Informatyka', 3, 2022);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (3, 'Informatyka', 5, 2022);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (4, 'Automatyka i Robotyka', 1, 2022);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (5, 'Automatyka i Robotyka', 3, 2022);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (6, 'Automatyka i Robotyka', 5, 2022);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (7, 'Informatyka', 2, 2023);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (8, 'Informatyka', 4, 2023);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (9, 'Informatyka', 6, 2023);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (10, 'Automatyka i Robotyka', 2, 2023);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (11, 'Automatyka i Robotyka', 4, 2023);
INSERT INTO public.term(term_id, major, term_number, year) VALUES (12, 'Automatyka i Robotyka', 6, 2023);

-- TEAM TABLE --
-- REGISTRATION -> OPEN -> CLOSE or CANCEL --
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (1, 1, 'CLOSE', 1, 1); 			-- TERM 1, 'Informatyka', 1, 2022
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (2, 1, 'CLOSE', 4, 4); 			-- TERM 4, 'Automatyka i Robotyka', 1, 2022
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (3, 1, 'CLOSE', 1, 2); 			-- TERM 1, 'Informatyka', 1, 2022
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (4, 1, 'CANCEL', 4, 5); 			-- TERM 4, 'Automatyka i Robotyka', 1, 2022
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (5, 2, 'OPEN', 7, 1); 			-- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (6, 1, 'OPEN', 10, 4); 			-- TERM 10, 'Automatyka i Robotyka', 2, 2023
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (7, 5, 'REGISTRATION', 7, 3); 		-- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (8, 3, 'REGISTRATION', 8, 2); 		-- TERM 8, 'Informatyka', 4, 2023
INSERT INTO public.team(team_id, member_limit, status, term_id, topic_id) VALUES (9, 4, 'REGISTRATION', 10, 6); 	-- TERM 10, 'Automatyka i Robotyka', 2, 2023

-- STUDENT_TERM TABLE --
INSERT INTO public.student_term(student_term_id, student_id, term_id) VALUES (1, 1, 1);
INSERT INTO public.student_term(student_term_id, student_id, term_id) VALUES (2, 2, 1);
INSERT INTO public.student_term(student_term_id, student_id, term_id) VALUES (3, 3, 4);
INSERT INTO public.student_term(student_term_id, student_id, term_id) VALUES (4, 1, 7);
INSERT INTO public.student_term(student_term_id, student_id, term_id) VALUES (5, 2, 7);
INSERT INTO public.student_term(student_term_id, student_id, term_id) VALUES (6, 3, 10);

-- STUDENT_TEAM TABLE --
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (1, 5, 1, 1);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (2, 4, 3, 2);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (3, 3, 2, 3);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (4, null, 3, 4);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (5, null, 1, 5);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (6, null, 2, 5);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (7, null, 3, 6);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (8, null, 1, 7);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (9, null, 2, 7);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (10, null, 1, 8);
INSERT INTO public.student_team(student_team_id, grade, student_id, team_id) VALUES (11, null, 3, 9);

-- ATTENDANCE TABLE --
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (1, '2022-09-11', TRUE, 1);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (2, '2022-09-09', TRUE, 2);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (3, '2022-10-12', TRUE, 3);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (4, '2022-10-11', TRUE, 4);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (5, '2022-11-09', FALSE, 1);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (6, '2022-11-11', FALSE, 4);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (7, '2022-12-04', TRUE, 1);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (8, '2022-12-05', TRUE, 2);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (9, '2022-12-12', TRUE, 3);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (10, '2023-04-04', TRUE, 5);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (11, '2023-04-05', TRUE, 5);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (12, '2023-04-06', TRUE, 6);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (13, '2023-04-07', TRUE, 6);
INSERT INTO public.attendance(attendance_id, date, present, student_team_id) VALUES (14, '2023-04-12', TRUE, 7);


-- ATTACHMENT TABLE --
-- INSERT INTO public.attachment(attachment_id, content, filename, student_team_id) VALUES (?, ?, ?, ?); - 


