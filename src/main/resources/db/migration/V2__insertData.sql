-- ROLE TABLE --
INSERT INTO public.role(name) VALUES ('ROLE_STUDENT');      -- ROLE_ID 1
INSERT INTO public.role(name) VALUES ('ROLE_SUPERVISOR');   -- ROLE_ID 2
INSERT INTO public.role(name) VALUES ('ROLE_ADMIN');        -- ROLE_ID 3

-- USERS TABLE --
INSERT INTO public.users(email, password, username) VALUES ('admin@admin.pl', '$2a$10$DgtQ/lChSYbtPfMxofKXxeCN6Bnrvz6ILXU2jtjTLBjj370DBYm4y', 'admin');           -- USERS_ID 1      -- PASSWORD = 'admin123'
INSERT INTO public.users(email, password, username) VALUES ('sawicki@supervisor.pl', '$2a$10$9c9iiVRn6gLaoi5rJFS6MezLeIpQjyyWsqsG6/OnPpnlL6rgSOvsa', 'sawicki');  -- USERS_ID 2      -- PASSWORD = 'sawicki'
INSERT INTO public.users(email, password, username) VALUES ('drabik@supervisor.pl', '$2a$10$zOutCPSe9TX0J6N5rpiO0e9Gg8PYvQzA4wv0UEENMFkbpkUVWLy5G', 'drabik');    -- USERS_ID 3      -- PASSWORD = 'drabik'
INSERT INTO public.users(email, password, username) VALUES ('szymon@admin.pl', '$2a$10$rEis8WZsMLzw6Vj8s7NJHu./Pgz03tMdaGX2F3.6cDYjaJSq3lVW.', 'szymon');         -- USERS_ID 4      -- PASSWORD = '12345678'
INSERT INTO public.users(email, password, username) VALUES ('marcel@admin.pl', '$2a$10$rEis8WZsMLzw6Vj8s7NJHu./Pgz03tMdaGX2F3.6cDYjaJSq3lVW.', 'marcel');         -- USERS_ID 5      -- PASSWORD = '12345678'
INSERT INTO public.users(email, password, username) VALUES ('seba@admin.pl', '$2a$10$rEis8WZsMLzw6Vj8s7NJHu./Pgz03tMdaGX2F3.6cDYjaJSq3lVW.', 'seba');             -- USERS_ID 6      -- PASSWORD = '12345678'

-- USERS_ROLES TABLE --
-- INSERT INTO public.user_roles(role_id) VALUES (3); -- USERS_ROLES_ID 1
-- INSERT INTO public.user_roles(role_id) VALUES (2); -- USERS_ROLES_ID 2
-- INSERT INTO public.user_roles(role_id) VALUES (2); -- USERS_ROLES_ID 3
-- INSERT INTO public.user_roles(role_id) VALUES (1); -- USERS_ROLES_ID 4
-- INSERT INTO public.user_roles(role_id) VALUES (1); -- USERS_ROLES_ID 5
-- INSERT INTO public.user_roles(role_id) VALUES (1); -- USERS_ROLES_ID 6
INSERT INTO public.user_roles(user_id, role_id) VALUES (1, 3);
INSERT INTO public.user_roles(user_id, role_id) VALUES (2, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (3, 2);
INSERT INTO public.user_roles(user_id, role_id) VALUES (4, 1);
INSERT INTO public.user_roles(user_id, role_id) VALUES (5, 1);
INSERT INTO public.user_roles(user_id, role_id) VALUES (6, 1);
-- STUDENT TABLE --
INSERT INTO public.student(first_name, surname, user_id) VALUES ('Szymon', 'Palka', 4);         -- STUDENT_ID 1  	-- STUDENT INFORMATYKI 2023 SEM 2 			    -- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.student(first_name, surname, user_id) VALUES ('Marcel', 'Furs', 5); 	        -- STUDENT_ID 2	    -- STUDENT INFORMATYKI 2023 SEM 2 			    -- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.student(first_name, surname, user_id) VALUES ('Sebastian', 'Sołtysik', 6);   -- STUDENT_ID 3  	-- STUDENT Automatyka i Robotyka 2023 SEM 2 	-- TERM 10, 'Automatyka i Robotyka', 2, 2023

-- SUPERVISOR TABLE --
INSERT INTO public.supervisor(first_name, surname, user_id) VALUES ('Michał', 'Sawicki', 2); -- SUPERVISOR_ID 1
INSERT INTO public.supervisor(first_name, surname, user_id) VALUES ('Gabriel', 'Drabik', 3); -- SUPERVISOR_ID 2


-- TOPIC TABLE --
INSERT INTO public.topic(name, supervisor_id, description) VALUES ('Android app', 1, 'Aplikacja która ma być napisana na androida');            -- TOPIC_ID 1
INSERT INTO public.topic(name, supervisor_id, description) VALUES ('iOS app', 1, 'Aplikacja która ma być napisana na iOS');                     -- TOPIC_ID 2
INSERT INTO public.topic(name, supervisor_id, description) VALUES ('Android i iOS app', 1, 'Aplikajca która ma działać na androidzie i iOS');   -- TOPIC_ID 3
INSERT INTO public.topic(name, supervisor_id, description) VALUES ('Z80', 2, 'Obsługa przerwań w procesorze Z80');                              -- TOPIC_ID 4
INSERT INTO public.topic(name, supervisor_id, description) VALUES ('8051', 2, 'Obsługa przerwań w procesorze 8051');                            -- TOPIC_ID 5
INSERT INTO public.topic(name, supervisor_id, description) VALUES ('Liczniki i dzielnkiki', 2, 'Licznik mod7 oraz mod10');                      -- TOPIC_ID 6



-- TERM TABLE --
INSERT INTO public.term(major, term_number, year) VALUES ('Informatyka', 1, 2022);              -- TERM_ID 1
INSERT INTO public.term(major, term_number, year) VALUES ('Informatyka', 3, 2022);              -- TERM_ID 2
INSERT INTO public.term(major, term_number, year) VALUES ('Informatyka', 5, 2022);              -- TERM_ID 3
INSERT INTO public.term(major, term_number, year) VALUES ('Automatyka i Robotyka', 1, 2022);    -- TERM_ID 4
INSERT INTO public.term(major, term_number, year) VALUES ('Automatyka i Robotyka', 3, 2022);    -- TERM_ID 5
INSERT INTO public.term(major, term_number, year) VALUES ('Automatyka i Robotyka', 5, 2022);    -- TERM_ID 6
INSERT INTO public.term(major, term_number, year) VALUES ('Informatyka', 2, 2023);              -- TERM_ID 7
INSERT INTO public.term(major, term_number, year) VALUES ('Informatyka', 4, 2023);              -- TERM_ID 8
INSERT INTO public.term(major, term_number, year) VALUES ('Informatyka', 6, 2023);              -- TERM_ID 9
INSERT INTO public.term(major, term_number, year) VALUES ('Automatyka i Robotyka', 2, 2023);    -- TERM_ID 10
INSERT INTO public.term(major, term_number, year) VALUES ('Automatyka i Robotyka', 4, 2023);    -- TERM_ID 11
INSERT INTO public.term(major, term_number, year) VALUES ('Automatyka i Robotyka', 6, 2023);    -- TERM_ID 12

-- TEAM TABLE --
-- NEW -> ACTIVE -> CLOSED or CANCELED --
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (1, 'CLOSED', 1, 1);    -- TEAM_ID 1 		-- TERM 1, 'Informatyka', 1, 2022
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (1, 'CLOSED', 4, 4); 	-- TEAM_ID 2 	    -- TERM 4, 'Automatyka i Robotyka', 1, 2022
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (1, 'CLOSED', 1, 2); 	-- TEAM_ID 3 	    -- TERM 1, 'Informatyka', 1, 2022
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (1, 'CANCELED', 4, 5); 	-- TEAM_ID 4 	    -- TERM 4, 'Automatyka i Robotyka', 1, 2022
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (2, 'ACTIVE', 7, 1); 	-- TEAM_ID 5 	    -- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (1, 'ACTIVE', 10, 4); 	-- TEAM_ID 6 	    -- TERM 10, 'Automatyka i Robotyka', 2, 2023
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (5, 'NEW', 7, 3); 		-- TEAM_ID 7       -- TERM 7, 'Informatyka', 2, 2023
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (3, 'NEW', 8, 2); 		-- TEAM_ID 8        -- TERM 8, 'Informatyka', 4, 2023
INSERT INTO public.team(member_limit, status, term_id, topic_id) VALUES (4, 'NEW', 10, 6); 	    -- TEAM_ID 9       -- TERM 10, 'Automatyka i Robotyka', 2, 2023

-- STUDENT_TERM TABLE --
INSERT INTO public.student_term(student_id, term_id) VALUES (1, 1);     -- STUDENT_TERM_ID 1
INSERT INTO public.student_term(student_id, term_id) VALUES (2, 1);     -- STUDENT_TERM_ID 2
INSERT INTO public.student_term(student_id, term_id) VALUES (3, 4);     -- STUDENT_TERM_ID 3
INSERT INTO public.student_term(student_id, term_id) VALUES (1, 7);     -- STUDENT_TERM_ID 4
INSERT INTO public.student_term(student_id, term_id) VALUES (2, 7);     -- STUDENT_TERM_ID 5
INSERT INTO public.student_term(student_id, term_id) VALUES (3, 10);    -- STUDENT_TERM_ID 6

-- STUDENT_TEAM TABLE --
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (5, 1, 1);       -- STUDENT_TEAM_ID 1
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (4, 3, 2);       -- STUDENT_TEAM_ID 2
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (3, 2, 3);       -- STUDENT_TEAM_ID 3
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 3, 4);    -- STUDENT_TEAM_ID 4
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 1, 5);    -- STUDENT_TEAM_ID 5
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 2, 5);    -- STUDENT_TEAM_ID 6
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 3, 6);    -- STUDENT_TEAM_ID 7
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 1, 7);    -- STUDENT_TEAM_ID 8
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 2, 7);    -- STUDENT_TEAM_ID 9
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 1, 8);    -- STUDENT_TEAM_ID 10
INSERT INTO public.student_team(grade, student_id, team_id) VALUES (null, 3, 9);    -- STUDENT_TEAM_ID 11

-- ATTENDANCE TABLE --
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-09-11', TRUE, 1);     -- ATTENDANCE_ID 1
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-09-09', TRUE, 2);     -- ATTENDANCE_ID 2
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-10-12', TRUE, 3);     -- ATTENDANCE_ID 3
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-10-11', TRUE, 4);     -- ATTENDANCE_ID 4
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-11-09', FALSE, 1);    -- ATTENDANCE_ID 5
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-11-11', FALSE, 4);    -- ATTENDANCE_ID 6
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-12-04', TRUE, 1);     -- ATTENDANCE_ID 7
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-12-05', TRUE, 2);     -- ATTENDANCE_ID 8
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2022-12-12', TRUE, 3);     -- ATTENDANCE_ID 9
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2023-04-04', TRUE, 5);     -- ATTENDANCE_ID 10
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2023-04-05', TRUE, 5);     -- ATTENDANCE_ID 11
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2023-04-06', TRUE, 6);     -- ATTENDANCE_ID 12
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2023-04-07', TRUE, 6);     -- ATTENDANCE_ID 13
INSERT INTO public.attendance(date, present, student_team_id) VALUES ('2023-04-12', TRUE, 7);     -- ATTENDANCE_ID 14


-- ATTACHMENT TABLE --
-- INSERT INTO public.attachment(content, filename, student_team_id) VALUES (?, ?, ?);  -- ATTACHMENT_ID 1


