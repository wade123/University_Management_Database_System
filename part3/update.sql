/*Set the student's name to 'Jim', birthyear to 1991 where the student's UIN is 8999. */
UPDATE student
SET Name='Jim',BirthYear=1991
WHERE UIN=8001;


/*Delete the rows from table student where the students were born after 1991 and genders are not 'F'.*/
DELETE FROM student
WHERE BirthYear>1991 AND not(Gender = 'F');

# delete modification in table professor
DELETE FROM professor
WHERE Interest = 'Network' and Title = 'Assistant Prof';

# insert modification in table professor
INSERT INTO professor 
VALUES(990, 'Kahatri', 'Associate Professor', 'America', 'Network', 9790015236, 'www.timkahatri.tamu.edu');


#find the professor who hasn't been the Chairman in any students' committeegroups, and then make he and the Professor with UIN 903 as the Chair and the Cochair respectively, for the student with UIN 8099
INSERT INTO committeegroup VALUES(8099, select min(UIN) from professor where UIN NOT IN (select ChairUIN from ((select ChairUIN, count(*) as Times from committeegroup GROUP BY ChairUIN) as T1)), 903,'2014-08-26','N');

#check the committeegroup whether the Chair and Cochair are the same professor. If there are duplication, change the tuple with smallest CochairUIN to 904
UPDATE committeegroup SET CochairUIN =904 WHERE ChairUIN= (select min(ChairUIN) from (select * from committeegroup Where ChairUIN=CochairUIN) as T1) AND CochairUIN = (select min(CochairUIN) from (select * from committeegroup Where ChairUIN=CochairUIN) as T2);
