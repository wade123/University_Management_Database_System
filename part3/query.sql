# Three general query
# Get all courses wchich are reigistered by students whose professor is American
SELECT CourseID
FROM studyof
WHERE UIN IN (SELECT UIN
			  FROM student
			  WHERE ProfUIN IN(SELECT UIN
							   FROM professor
							   WHERE Nationality='America'));
# Get the club name which is registered by students who also register courses from CSCE department					
SELECT ClubName
FROM registerIn
WHERE StudentUIN IN (SELECT UIN 
										 FROM studyof
										 WHERE CourseID LIKE 'CSCE%');
# Get all courses which are registered by students from Mays Business School and also are	member of basketball club									 
SELECT CourseID
FROM studyof
WHERE UIN IN(SELECT StudentUIN
						 FROM registerIn
						 WHERE ClubName='BasketBall')
			AND CourseID LIKE 'MBS%';
			
# Aggregrating query
# Get the amount of member of each club
SELECT ClubName, count(ClubName) as Sum_Member 
FROM registerin 
GROUP BY ClubName;


/*Query the name and the UIN of the students, whose advisors are in ECEN department, and their corresponding professors' names.*/
SELECT student.Name, student.UIN, professor.Name
FROM student, professor
WHERE( student.ProfUIN in (select T1.UIN from professor as T1, facultyof WHERE T1.UIN = facultyof.Prof_UIN AND facultyof.Department = 'ECEN')
AND student.ProfUIN = professor.UIN);


/*Find out the students' names where the students' genders are 'F' and their names are ordered by birthyear. Find out the professors' names where their nationalities are 'China' and interests are 'Network'. The professors' name are ordered by their birthyears. Then combine these names together into an union.  */
(SELECT Name FROM student WHERE Gender = 'F' ORDER BY BirthYear LIMIT 10)
UNION
(SELECT Name FROM professor WHERE Nationality='China' AND Interest='Network' ORDER BY UIN LIMIT 10);

# output all the professor info in CSCE by salary in descending oder with Join operation
SELECT professor.UIN, professor.Name, professor.Title, facultyof.Department,facultyof.Salary
FROM professor JOIN facultyof
ON (professor.UIN = facultyof.Prof_UIN)
where Department = 'CSCE'
order by Salary desc;

# output all different courses students in ChE department take
select distinct e1.CourseID
from (
select student.Major, studyof.CourseID 
from student join studyof
on (student.UIN = studyof.UIN)
where Major = 'ChE'
) 
as e1;

#list the professors' name and times they working as Chairman in committeegroups in the increasing order of their UIN
select ChairUIN from (select  ChairUIN, count(*) as Times from committeegroup GROUP BY ChairUIN) T1;

#list each student's name and the total cited numbers of his/her papers 
select StudUIN, sum(Cited) from student, Paper where UIN=StudUIN GROUP BY StudUIN;
