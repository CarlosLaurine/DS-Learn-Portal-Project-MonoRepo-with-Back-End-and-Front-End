INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Black', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);

INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_Uri, img_Gray_Uri) VALUES ('Java Bootcamp', 'https://www.tutorialspoint.com/videotutorials/assets/videos/courses/896/images/course_896_image.png', 'https://i.pcmag.com/imagery/articles/00aKX2mKSN9x94d96DSqolA-1..1596625018.jpg');

INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.0.0', TIMESTAMP WITH TIME ZONE '2020-10-15T17:30:00Z', TIMESTAMP WITH TIME ZONE '2021-12-15T12:30:00Z', 1);
INSERT INTO tb_offer (edition, start_Moment, end_Moment, course_id) VALUES ('1.5.0', TIMESTAMP WITH TIME ZONE '2020-12-15T17:30:00Z', TIMESTAMP WITH TIME ZONE '2022-02-15T12:30:00Z', 1);

INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id ) VALUES ('Spring Task', 'Core Task of the Course', 1, 'https://img.icons8.com/color/452/spring-logo.png', 1, 1 );
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id ) VALUES ('Forum', 'Q&A with Students and Mentors', 2, 'https://img.icons8.com/color/452/spring-logo.png', 2, 1 );
INSERT INTO tb_resource (title, description, position, img_Uri, type, offer_id ) VALUES ('Bonus Live Classes', 'Real Time Scheduled Mentorship Events', 3, 'https://img.icons8.com/color/452/spring-logo.png', 0, 1 );

INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Chapter 1', 'Lets Start our Learning Path!', 1, 'https://img.icons8.com/color/452/spring-logo.png', 1, null);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Chapter 2', 'Lets Continue our Learning Path!', 2, 'https://img.icons8.com/color/452/spring-logo.png', 1, 1);
INSERT INTO tb_section (title, description, position, img_Uri, resource_id, prerequisite_id) VALUES ('Chapter 3', 'Lets Finish our Learning Path!', 3, 'https://img.icons8.com/color/452/spring-logo.png', 1, 2);

INSERT INTO tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, update_Only) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2020-10-15T17:30:00Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_Moment, refund_Moment, available, update_Only) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2020-10-15T17:30:00Z', null, true, false);


INSERT INTO tb_lesson (title, position, section_id) VALUES ('Chapter 1 Class 1', 1, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (1, 'Support Material: Google Docs Link', 'https://www.youtube.com/watch?v=sqbqoR-lMf8'); 

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Chapter 1 Class 2', 2, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (2, 'Support Material: Google Docs Link', 'https://www.youtube.com/watch?v=sqbqoR-lMf8'); 

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Chapter 1 Class 3', 3, 1);
INSERT INTO tb_content (id, text_Content, video_Uri) VALUES (3, 'Support Material: Google Docs Link', 'https://www.youtube.com/watch?v=sqbqoR-lMf8'); 

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Chapter 1 Task', 4, 1);
INSERT INTO tb_task (id, description, question_Count, approval_Count, weight, due_Date) VALUES (4, 'Implement Security Validations at the Source Code with OAuth', 10, 6, 1.0, TIMESTAMP WITH TIME ZONE '2020-11-25T13:00:00Z');

INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1);