Test 1: Create and successfully Login to Teacher Account with Data Persistence
Steps
1: User launches application and selects 'Ok' text button
2: User selects 'Sign up' text button
3: User selects 'Teacher' text button
4: User inputs preferred username via keyboard and selects 'OK' text button; Ex: kabhyankar
5: User inputs preferred password via keyboard and selects 'OK' text button; Ex: CS180
6: User receives teacher sign up successful window
7: User ends and relaunches application
8: User selects 'Sign in' text button
9: User selects 'Teacher' text button
10: User inputs preferred username via keyboard and selects 'OK' text button; Ex: kabhyankar
11: User inputs preferred password via keyboard and selects 'OK' text button; Ex: CS180
12: User receives teacher sign in successful window
Expected result: Application creates, stores, and verifies the teacher's username and password
Test Status: Passed


Test 2: Create and successfully Login to Student Account with Data Persistence
Steps
1: User launches application and selects 'Ok' text button
2: User selects 'Sign up' text button
3: User selects 'Student' text button
4: User inputs preferred username via keyboard and selects 'OK' text button; Ex: waclippard
5: User inputs preferred password via keyboard and selects 'OK' text button; Ex: Baseball44
6: User receives student sign up successful window
7: User ends and relaunches application 
8: User selects 'Sign in' text button
9: User selects 'Student' text button
10: User inputs preferred username via keyboard and selects 'OK' text button; Ex: waclippard
11: User inputs preferred password via keyboard and selects 'OK' text button; Ex: Baseball44
12: User receives student sign in successful window
Expected result: Application creates, stores, and verifies the student's username and password
Test Status: Passed


Test 3: Edit and successfully Sign into Teacher Account with Data Persistence
Steps
1: User launches application and selects 'Ok' text button
2: User selects 'Edit account' text button
3: User selects 'Teacher' text button
4: User inputs old username via keyboard and selects 'OK' text button; Ex: kabhyankar
5: User inputs old password via keyboard and selects 'OK' text button; Ex: CS180
6: User inputs new preferred password via keyboard and selects 'OK' text button; Ex: GUIMaster
7: User receives teacher edit account successful window
8: User ends and relaunches application
9: User selects 'Sign in' text button
10: User selects 'Teacher' text button
11: User inputs preferred username via keyboard and selects 'OK' text button; Ex: kabhyankar
12: User inputs preferred password via keyboard and selects 'OK' text button; Ex: GUIMaster
13: User receives teacher sign in successful window
Expected result: Application edits, stores, and verifies the teacher's new password
Test Status: Passed


Test 4: Edit and successfully Sign into Student Account with Data Persistence
Steps
1: User launches application and selects 'Ok' text button
2: User selects 'Edit account' text button
3: User selects 'Student' text button
4: User inputs old username via keyboard and selects 'OK' text button; Ex: waclippard
5: User inputs old password via keyboard and selects 'OK' text button; Ex: Baseball44
6: User inputs new preferred password via keyboard and selects 'OK' text button; Ex: Basketball22
7: User receives student edit account successful window
7: User ends and relaunches application
8: User selects 'Sign in' text button
9: User selects 'Student' text button
10: User inputs preferred username via keyboard and selects 'OK' text button; Ex: waclippard
11: User inputs preferred password via keyboard and selects 'OK' text button; Ex: Basketball22
12: User receives student sign in successful window
Expected result: Application edits, stores, and verifies the students's new password
Test Status: Passed


Test 5: Teacher add Course and Quiz successfully
Steps
1: User launches application and successfully signs into teacher account
2: User selects 'add course' text button
3: User inputs preferred course name via keyboard and selects 'OK' text button; Ex: Computer Science
4: User receives course added successfully window
5: User selects 'add quiz' text button
6: User inputs old course name via keyboard and selects 'OK' text button; Ex: Computer Science
7: User inputs preferred quiz name via keyboard and selects 'OK' text button; Ex: GUI
8: User receives course quiz added successfully window
Expected result: Application creates, verifies, and stores new course and quiz from teacher
Test Status: Passed


Test 6: Teacher edit Quiz and add question successfully with Data Persitence
Steps
1: User launches application and successfully signs into teacher account
2: User selects 'edit quiz' text button
3: User inputs old course name via keyboard and selects 'OK' text button; Ex: Computer Science
4: User inputs old course quiz name via keyboard and selects 'OK' text button; Ex: GUI
5: User inputs preferred number of questions via keyboard and selects 'OK' text button; Ex: 2
6: User inputs preferred first question via keyboard and selects 'OK' text button; Ex: 1 What is a Simple GUI?
7: User input preferred second question via keyboard and selects 'OK' text button; Ex: 2 What is a Complex GUI?
8: User receives quiz edited successfully window
Expected result: Application verifies, edits, and stores new course quiz and questions from teacher
Test Status: Passed


Test 7: Student takes course quiz successfully
Steps
1: User launches application and successfully signs into student account
2: User selects 'take quiz' text button
3: User inputs old course name via keyboard and selects 'OK' text button; Ex: Computer Science
4: User inputs old course quiz name via keyboard and selects 'OK' text button; Ex: GUI
5: User receives successfully question 1 window; Ex: 1 What is a Simple GUI?
6: User inputs preferred question 1 answer via keyboard and selects 'OK' text button; Ex: Basic user interface window
7: User receives successfully question 2 window; Ex: 2 What is a Complex GUI?
8: User inputs preferred question 2 answer via keyboard and selects 'OK' text button; Ex: Complex user interface window
9: User receives quiz completed successfully window
Expected result: Application verifies course and quiz and stores quiz submission from student
Test Status: Passed


Test 8: Teacher views Student Quiz submission with Data Persistence
Steps
1: User launches application and successfully signs into teacher account
2: User selects 'view submission' text button
3: User inputs old course name via keyboard and selects 'OK' text button; Ex: Computer Science
4: User inputs old course quiz name via keyboard and selects 'OK' text button; Ex: GUI
5: User successfully receives question 1 window; Ex: 1 What is a Simple GUI?
6: User successfully receives student question 1 answer window; Ex: Basic user inferface window
7: User successfully receives question 2 window; Ex: 2 What is a Complex GUI?
8: User successfully receives student question 2 answer window; Ex: Complex user interface window
Expected result: Application verifies course and quiz and allows student submission to be viewable from teacher
Test Status: Passed

Test 9: Teacher inputs new course quiz from existing text file questions
Steps
1: User creates and specifically names a new quiz text file; Ex: Scanner
2: User inputs numbered questions into each line of text file; Ex: 1 What is a Scanner?, 2 List a functionality of a Scanner?, 3 How do you call a Scanner?
3: User launches application and successfully signs into teacher account
4: User selects 'add quiz by importing file' text button
5: User inputs old course name via keyboard and selects 'OK' text button; Ex: Computer Science
6: User inputs old quiz text file name via keyboard and selects 'OK' text button; Ex: Scanner
7: User receives quiz imported successfully window
Expected result: Application reads, imports, and stores created quiz text file from teacher
Test Status: Passed


Test 10: Student inputs new quiz submission from existing text file answers
Steps
1: User creates and specifically names a new quiz submission text file; Ex: Scanner-answer
2: User inputs question answers into each line of text file; Ex: Class for obtaining the input of data types, Reads and stores user input, Scanner scan = new Scanner(System.in);
3: User launches application and successfully signs into student account
4: User selects 'take quiz by importing answer file' text button
5: User inputs old course name via keyboard and selects 'OK' text button; Ex: Computer Science
6: User inputs old course quiz name via keyboard and selects 'OK' text button; Ex: Scanner
7: User inputs old quiz answer submission text file name via keyboard and selects 'OK' text button; Ex: Scanner-answer
8: User receives student quiz answer submission imported successfully window
Expected result: Application reads, imports, and stores answer submission text file from student
Test Status: Passed


Test 11: Delete and unsuccessfully Log in to Teacher Account with Data Persistence
Steps:
1: User launches application and selects 'Ok' text button
2: User selects 'Delete account' text button
3: User selects 'Teacher' text button
4: User inputs old username via keyboard and selects 'OK' text button; Ex: kabhyankar
5: User inputs old password via keyboard and selects 'OK' text button; Ex: GUIMaster
6: User receives teacher delete account successful window
7: User ends and relaunches application
8: User selects 'Sign in' text button
9: User selects 'Teacher' text button
10: User inputs preferred username via keyboard and selects 'OK' text button; Ex: kabhyankar
11: User inputs preferred password via keyboard and selects 'OK' text button; Ex: GUIMaster
12: User receives teacher login error window
Expected result: Application deletes and erases data from selected teacher account
Test Status: Passed


Test 12: Delete and unsuccessfully Log in to Student Account with Data Persistence
Steps:
1: User launches application and selects 'Ok' text button
2: User selects 'Delete account' text button
3: User selects 'Student' text button
4: User inputs old username via keyboard and selects 'OK' text button; Ex: waclippard
5: User inputs old password via keyboard and selects 'OK' text button; Ex: Basketball22
6: User receives student delete account successful window
7: User ends and relaunches application
8: User selects 'Sign in' text button
9: User selects 'Student' text button
10: User inputs preferred username via keyboard and selects 'OK' text button; Ex: waclippard
11: User inputs preferred password via keyboard and selects 'OK' text button; Ex: Basketball22
12: User receives student login error window
Expected result: Application deletes and erases data from selected teacher account
Test Status: Passed


Test 13: Delete course Quiz successfully
Steps
1: User launches application and successfully signs into teacher account
2: User selects 'delete quiz' text button
3: User inputs old course name via keyboard and selects 'OK' text button; Ex: Computer Science
4: User input old course quiz name via keyboard and selects 'OK' text button; Ex: GUI
5: User receives quiz deletion successfully window
6: Quiz text file is deleted from application; Ex: Computer Science-GUI
Expected result: Application deletes course quiz and erases data from selected course from teacher
Test Status: Passed
