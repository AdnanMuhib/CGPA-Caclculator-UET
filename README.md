# CGPA-Calculator-UET
A Student Subjects Registration System and CGPA Calculator with facility of seeing registered Subjects and<br/> Detailed DMC View. Made on Java and Swing Library of Java for UI.
## Documentation
To know about the functionality of each member function use [Documentation](https://adnanmuhib.github.io/CGPA-Caclculator-UET/).

## Problem Statement (Assignment)
Write a Java program in which you are required to implement the following design:<br />
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/class%20diagram.PNG)
<br />Constraints for each attribute are given below. <br />
*  **StudentName** //should be alphabetic, special characters and numbers are not
allowed.
*  **RegistrationNumber** //Format should be like this: 2015-CS-888, any other format
should be handled in setter function.
* **Degree** //it should be MS, BS or BE.
* **CourseID** // Format should be valid according to your course codes given in your
LMS. For instance, software engineering lab has course ID of CS381L. Length of
course code should be from 2 to 8 characters.
* **CourseTitle** // should be alphabetic. Length of course code should be from 10 to
35 characters.
* **CreditHours** // values from 1 to 3 are allowed.
* **Marks** // values from 0 to 100 are allowed.
* **Semester** // valid range is from 1 to 8.
1. Your Program should define three constructors for class of **CourseResult**:
* a constructor with **no parameter**
* a constructor with **parameters**
* **copy** constructor
2. UetGradeBook will have only one constructor without parameter.
3. Define getter setter for each data member in classes.
4. Apart from getter, setter and constructor, define the following functions in
respective classes according to class diagram: <br />
i. getGrade() – it should calculate grade based on marks using the following
criteria:
* a. IF marks are less than 40 – Grade is F
* b. IF marks are between 40 and 50(exclusive) - Grade is D
* c. IF marks are between 50 and 55(exclusive) - Grade is C
* d. IF marks are between 55 and 60(exclusive) - Grade is C+
* e. IF marks are between 60 and 65(exclusive) - Grade is B
* f. IF marks are between 65 and 70(exclusive) - Grade is B+
* g. IF marks are between 70 and 80(exclusive) - Grade is A
* h. IF marks are above 80 - Grade is A <br />
ii. **getGradePoints()** – function should return grade points using the following
criteria: <br />
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/Grades.PNG)

iii. **getSemesters()** – it should return number of semesters based on course list. <br />

iv. **getSemesterGPA(semester: int)** – calculate semester GPA according to
following formula : <br />
**semesterGPA = Sumof(SemesterCourseGradePoints) / SemesterCreditHours**

v. **getSemesterCGPA(semester: int):** calculate CGPA using the following
formula :<br />
**CGPA = Sumof(CourseGradePoints) / TotalCreditHours** <br />
vi. **getTotalCreditHours()** – it should return number of credit hours based on
course list. <br />
vii. **getSemesterCreditHours(semester: int)** – it should return number of
credit hours for a given semester based on course list.<br />
viii. **getSession()** – extract session from RegistrationNumber. <br />
ix. **getDiscipline()**: extract session from RegistrationNumber. <br />
x. **toString()** – Purpose of this function is to write all attributes of a class in
desired format and return as a string. <br />
5. Further, you must make a new class named Driver in which you have to define
main function.
6. Declare a new object of UetGradeBook in main function.
## OUTPUT
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/Output/1-MainScreen.PNG) <br />
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/Output/2-%20Basic%20Information.PNG) <br />
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/Output/3-%20Course%20Adding.PNG) <br />
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/Output/4-%20Courses.PNG) <br />
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/Output/5-%20CGPA%20View.PNG) <br />
![alt text](https://github.com/AdnanMuhib/CGPA-Caclculator-UET/blob/master/Output/6-%20DMC.png) <br />


