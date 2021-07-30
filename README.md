Simply your attendance management system.

Steps to be followed to work on this project.

1.First clone the project from the repository.
2.In applications.properties file change username and password of MySQL database to your workbench one's. In my case it is root and Bhargav@143 respectively.
3.Now create a database named attendance_marking_system. (if not when you run the project it gives database not found exception.)
4.Now go to "WebApplication.java" file and run it as spring boot project.
5.After run the project go to MySQL workbench and paste the below code and run it.


use attendance_marking_system;
INSERT INTO attendance_marking_system.role ( id, role ) VALUES ( '1', 'ADMIN' ); INSERT INTO attendance_marking_system.role ( id, role ) VALUES ( '2', 'USER' ); INSERT INTO attendance_marking_system.admin ( id, email, firstname, lastname, password, age, contact, gender, security1, security2, status ) VALUES ( '100', 'dummy@gmail.com', 'dummy', 'dummy', '$10$igxd.9h/0bqG.2915jITSuUm3lvSE0gsP/d5xEJvFglFColMqJ2aa', '100', '7995852576', 'Male', 'hash', 'school', 'don't use' );

INSERT INTO attendance_marking_system.admin_roles ( admin_id, roles_id ) VALUES ( '100', '1' );

6.After that open "localhost:8080" in your browser.

Welcome to the home page................

7.Now register the superuser in admin registration with email to be "superuser@gmail.com" and other fields as per your requirment.

Yes, you successfully deployed the project in your local system.
