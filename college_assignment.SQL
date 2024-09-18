CREATE DATABASE IF NOT EXISTS COLLEGE;
USE COLLEGE;

CREATE TABLE EMPLOYEE (
    Eno CHAR(3) NOT NULL PRIMARY KEY,
    Ename VARCHAR(50) NOT NULL,
    Job_type VARCHAR(50) NOT NULL,
    Manager CHAR(3),
    Hire_date DATE NOT NULL,
    Dno INTEGER,
    Commission DECIMAL(10, 2),
    Salary DECIMAL(7, 2) NOT NULL,
    FOREIGN KEY (Manager) REFERENCES EMPLOYEE (Eno),
    FOREIGN KEY (Dno) REFERENCES DEPARTMENT (Dno)
);

DESC EMPLOYEE;

CREATE TABLE DEPARTMENT(
    Dno INTEGER NOT NULL PRIMARY KEY,
    Dname VARCHAR(50) NOT NULL,
    Location VARCHAR(50) DEFAULT 'NEW DELHI'
);


DESC DEPARTMENT;


INSERT INTO EMPLOYEE (Eno, Ename, Job_type, Manager, Hire_date, Dno, Commission, Salary) VALUES
('E01', 'Abinash', 'Manager', NULL, '2020-01-15', 1, 1000.00, 75000.00),
('E02', 'Abhisekh', 'Assistant', 'E01', '2021-03-22', 1, 500.00, 55000.00),
('E03', 'Rakesh', 'Developer', 'E01', '2021-05-18', 2, NULL, 60000.00),
('E04', 'Rahul', 'Analyst', 'E03', '2022-07-10', 3, NULL, 70000.00);

INSERT INTO DEPARTMENT (Dno, Dname, Location) VALUES
(1, 'HR', 'New Delhi'),
(2, 'IT', 'Bangalore'),
(3, 'Finance', 'Mumbai');

-- 1. Query to display Employee Name, Job, Hire Date, Employee Number; for each employee with Employee Number first.
SELECT Eno, Ename, Job_type, Hire_date FROM EMPLOYEE;

-- 2. Query to display unique Jobs from the Employee Table.
SELECT DISTINCT Job_type FROM EMPLOYEE;

-- 3. Query to display the Employee Name concatenated with Job separated by a comma.
SELECT CONCAT(Ename, ', ', Job_type) AS Ename_job FROM EMPLOYEE;

-- 4. Query to display all data from Employee Table separated by commas, naming the column THE_OUTPUT.
SELECT CONCAT(Eno, ',', Ename, ',', Job_type, ',', Hire_date, ',', Salary) AS THE_OUTPUT FROM EMPLOYEE;

-- 5. Query to display the Employee Name and Salary of all employees earning more than $2850.
SELECT Ename, Salary FROM EMPLOYEE WHERE Salary > 2850;

-- 6. Query to display Employee Name and Department Number for Employee No 'E03'.
SELECT EMPLOYEE.Ename, DEPARTMENT.Dno FROM EMPLOYEE JOIN DEPARTMENT ON EMPLOYEE.Dno = DEPARTMENT.Dno WHERE EMPLOYEE.Eno = 'E03';

-- 7. Query to display Employee Name and Salary for all employees whose salary is not between $1500 and $2850.
SELECT Ename, Salary FROM EMPLOYEE WHERE Salary NOT BETWEEN 1500 AND 2850;

-- 8. Query to display Employee Name and Department No. for employees in Dept 1 and 3 in alphabetical order by name.
SELECT Ename, Dno FROM EMPLOYEE WHERE Dno IN (1, 3) ORDER BY Ename;

-- 9. Query to display Name and Hire Date of every employee hired in 1981.
SELECT Ename, Hire_date FROM EMPLOYEE WHERE YEAR(Hire_date) = 1981;

-- 10. Query to display Name and Job of all employees who don’t have a current Manager.
SELECT Ename, Job_type FROM EMPLOYEE WHERE Manager IS NULL;

-- 11. Query to display Name, Salary, and Commission for employees who earn commission.
SELECT Ename, Salary, Commission FROM EMPLOYEE WHERE Commission IS NOT NULL;

-- 12. Query to sort the data in descending order of Salary and Commission.
SELECT Ename, Salary, Commission FROM EMPLOYEE ORDER BY Salary DESC, Commission DESC;

-- 13. Query to display the Name of all employees where the third letter of their name is 'A'.
SELECT Ename FROM EMPLOYEE WHERE SUBSTRING(Ename, 3, 1) = 'A';

-- 14. Query to display Name of employees who either have two 'R's or two 'A's in their name and are either in Dept 3 or have Manager with Employee No 'E01'.
SELECT Ename FROM EMPLOYEE WHERE (Ename LIKE '%R%R%' OR Ename LIKE '%A%A%') AND (Dno = 3 OR Manager = 'E01');

-- 15. Query to display Name, Salary, and Commission for employees whose Commission is 14 greater than their Salary increased by 5%.
SELECT Ename, Salary, Commission FROM EMPLOYEE WHERE Commission = (Salary * 1.05) + 14;

-- 16. Query to display the current date.
SELECT CURDATE() AS Current_Date;

-- 17. Query to display Name, Hire Date, and Salary Review Date, which is the 1st Monday after six months of employment.
SELECT Ename, Hire_date, DATE_ADD(Hire_date, INTERVAL 6 MONTH) + INTERVAL (9 - DAYOFWEEK(DATE_ADD(Hire_date, INTERVAL 6 MONTH))) DAY AS Salary_Review_Date FROM EMPLOYEE;

-- 18. Query to display Name and number of months between today and the hire date for each employee.
SELECT Ename, TIMESTAMPDIFF(MONTH, Hire_date, CURDATE()) AS Months_Worked FROM EMPLOYEE;

-- 19. Query to display each employee’s "<E-Name> earns < Salary> monthly but wants <3*Current Salary>", label the column as Dream Salary.
SELECT CONCAT(Ename, ' earns ', Salary, ' monthly but wants ', 3*Salary) AS Dream_Salary FROM EMPLOYEE;

-- 20. Query to display Name with the 1st letter capitalized and the rest lowercase, and the length of the name for employees whose name starts with 'J', 'A', or 'M'.
SELECT CONCAT(UPPER(LEFT(Ename, 1)), LOWER(SUBSTRING(Ename, 2))) AS Name_Capitalized, LENGTH(Ename) AS Name_Length FROM EMPLOYEE WHERE Ename LIKE 'J%' OR Ename LIKE 'A%' OR Ename LIKE 'M%';

-- 21. Query to display Name, Hire Date, and the day of the week on which the employee started.
SELECT Ename, Hire_date, DAYNAME(Hire_date) AS Start_Day FROM EMPLOYEE;

-- 22. Query to display Name, Department Name, and Department No for all employees.
SELECT Ename, DEPARTMENT.Dname, DEPARTMENT.Dno FROM EMPLOYEE JOIN DEPARTMENT ON EMPLOYEE.Dno = DEPARTMENT.Dno;

-- 23. Query to display a unique listing of all jobs in Department #3.
SELECT DISTINCT Job_type FROM EMPLOYEE WHERE Dno = 3;

-- 24. Query to display Name and Department Name for all employees who have an 'A' in their name.
SELECT Ename, Dname FROM EMPLOYEE JOIN DEPARTMENT ON EMPLOYEE.Dno = DEPARTMENT.Dno WHERE Ename LIKE '%A%';

-- 25. Query to display Name, Job, Department No, and Department Name for all employees working at the 'New Delhi' location.
SELECT Ename, Job_type, DEPARTMENT.Dno, DEPARTMENT.Dname FROM EMPLOYEE JOIN DEPARTMENT ON EMPLOYEE.Dno = DEPARTMENT.Dno WHERE DEPARTMENT.Location = 'New Delhi';

-- 26. Query to display Employee No and Name along with their Manager's Name and Manager's Employee No; and for employees without a Manager.
SELECT e1.Eno, e1.Ename, e2.Eno AS Manager_No, e2.Ename AS Manager_Name FROM EMPLOYEE e1 LEFT JOIN EMPLOYEE e2 ON e1.Manager = e2.Eno;

-- 27. Query to display Name, Department No, and Salary for any employee whose department number and salary match those of an employee earning commission.
SELECT Ename, Dno, Salary FROM EMPLOYEE WHERE (Dno, Salary) IN (SELECT Dno, Salary FROM EMPLOYEE WHERE Commission IS NOT NULL);

-- 28. Query to display Name and Salaries represented by asterisks where each asterisk (*) signifies $100.
SELECT Ename, REPEAT('*', Salary/100) AS Salary_Stars FROM EMPLOYEE;

-- 29. Query to display the Highest, Lowest, Sum, and Average Salaries of all employees.
SELECT MAX(Salary) AS Highest_Salary, MIN(Salary) AS Lowest_Salary, SUM(Salary) AS Total_Salary, AVG(Salary) AS Average_Salary FROM EMPLOYEE;

-- 30. Query to display the number of employees performing the same Job type functions.
SELECT Job_type, COUNT(*) AS Num_Employees FROM EMPLOYEE GROUP BY Job_type;

-- 31. Query to display the number of managers without listing their names.
SELECT COUNT(*) AS Num_Managers FROM EMPLOYEE WHERE Manager IS NULL;

-- 32. Query to display the Department name, Location, number of employees, and the average salary for all employees in that department.
SELECT DEPARTMENT.Dname, DEPARTMENT.Location, COUNT(EMPLOYEE.Eno) AS Num_Employees, AVG(EMPLOYEE.Salary) AS Avg_Salary FROM DEPARTMENT JOIN EMPLOYEE ON DEPARTMENT.Dno = EMPLOYEE.Dno GROUP BY DEPARTMENT.Dno;

-- 33. Query to display name and hire date for all employees in the same department as 'John Doe' (Eno = 'E01').
SELECT Ename, Hire_date FROM EMPLOYEE WHERE Dno = (SELECT Dno FROM EMPLOYEE WHERE Ename = 'John Doe');

-- 34. Query to display employee number and name for employees earning more than the average salary.
SELECT Eno, Ename FROM EMPLOYEE WHERE Salary > (SELECT AVG(Salary) FROM EMPLOYEE);

-- 35. Query to display employee number and name for employees who work in the same department as any employee whose name contains a 'T'.
SELECT Eno, Ename FROM EMPLOYEE WHERE Dno IN (SELECT Dno FROM EMPLOYEE WHERE Ename LIKE '%T%');

-- 36. Query to display name and salary of employees who report to 'John Doe' (Eno = 'E01').
SELECT Ename, Salary FROM EMPLOYEE WHERE Manager = 'E01';

-- 37. Query to display department number, name, and job for all employees in the 'Sales' department.
SELECT DEPARTMENT.Dno, DEPARTMENT.Dname, EMPLOYEE.Job_type FROM EMPLOYEE JOIN DEPARTMENT ON EMPLOYEE.Dno = DEPARTMENT.Dno WHERE DEPARTMENT.Dname = 'Sales';
