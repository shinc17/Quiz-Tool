import java.io.IOException;

/**
 * PJ 04 -- test.java
 *
 * This is a program which teacher can make courses and quizzes and student can take a quiz
 * User can sign up and sign in as either teacher or student
 * File can be stored for data persistence
 *
 * @author David Shin, Yuchen Gu, Atharva Patil, Will Clippardlab Thursday 3:30
 *
 * @version April 12, 2022
 *
 */

public class test {
    public static void main(String[] args) throws IOException {
        Login login = new Login();
        String isTeacher = login.menu();
        /*
        Invalid input:
        ex.A: *invalid input for login.mainPrompt()
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit
        [String other than 1,2,3,4,5] *invalid input for login.mainPrompt()
        Invalid input!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit

        ex.B: invalid input for login.signUp()
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit
        [2]
        Are you a teacher or student?
        1. teacher
        2. student
        [String other than 1,2] *invalid input for login.signUp()
        Invalid input! Please select options by input number!
        Are you a teacher or student?
        1. teacher
        2. student

        ex.C: *invalid input for login.signIn() when no existing account
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit
        [1]
        Are you a teacher or student?
        1. teacher
        2. student
        [1]
        There is no existing teacher account!!!
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit

        ex.D: *invalid input for login.signIn() when account or password not matched
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit
        [1]
        Are you a teacher or student?
        1. teacher
        2. student
        [1]
        Please enter your user name:
        [unmatched username] *invalid input for login.signIn() when account or password not matched
        Please enter password:
        [or matched password] *invalid input for login.signIn() when account or password not matched
        Invalid username or password!
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit

        ex.E *Invalid input for login.editAccount() before create account
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit
        [3]
        Are you a teacher or student?
        1. teacher
        2. student
        [1]
        Please enter your old user name:
        [David]
        Username does not exist!
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit

        ex.F *Invalid input for login.editAccount() with wrong password

        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit
        [3]
        Are you a teacher or student?
        1. teacher
        2. student
        [1]
        Please enter your old user name:
        [matched username]
        Please enter your old password:
        [unmatched password]
        Incorrect password!
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit

        ex.G *Invalid input for login.deleteAccount() before create accounts

        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit
        [4]
        Are you a teacher or student?
        1. teacher
        2. student
        [2]
        Please enter your user name:
        [any word]
        Username does not exist!
        Welcome to the quiz system!
        Please select options by typing option number.
        1. Sign in
        2. Sign up
        3. Edit account
        4. Delete account
        5. Exit

         */
        QuizSystem quizSystem = new QuizSystem();
        if (isTeacher.equals("Teacher")) {
            quizSystem.teacherMenu();
        }
        /*
        Invalid input:
        ex.A: *invalid input for QuizSystem.teacherMenu()
        Sign in success! Welcome teacher David
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit
        [String other than 1,2,3,4,5,6,7] *invalid input for QuizSystem.teacherMenu()
        Invalid input!
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. quit

        ex.B *Invalid input for QuizSystem.teacherMenu() (try to edit course that is not existed)
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit
        [3]
        Please choose course:
        [unmatched course name]
        Please input quiz name:
        [unmatched quiz name]
        Invalid course name or quiz name!
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. quit

        ex.C *Invalid input for QuizSystem.teacherMenu() (try to delete course that is not existed)
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit
        [4]
        Please choose course:
        [unmatched course name]
        Please input quiz name:
        [unmatched quiz name]
        Invalid course name or quiz name!
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit

        ex.D *Invalid input for QuizSystem.teacherMenu() (try to view submission of quiz in course that is not existed)
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit
        [5]
        Please choose course:
        [unmatched course name]
        Please input quiz name:
        [unmatched quiz name]
        Invalid course name or quiz name!
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit

        ex.E *Invalid input for QuizSystem.teacherMenu() (try to add quiz in course that is not existed)
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit
        [2]
        Please choose course:
        [unmatched course name]
        Invalid course!
        Please input correct course name!
        1. add course
        2. add quiz
        3. edit quiz
        4. delete quiz
        5. view submission
        6. add quiz by importing file
        7. quit

        */
        if (isTeacher.equals("Student")) {
            quizSystem.studentMenu();
        }

        /*
        Invalid input:
        ex.A: *invalid input for QuizSystem.studentMenu()
        Sign in success! Welcome student David
        1. take quiz
        2. take quiz by importing answer file
        3. quit
        [String other than 1,2,3] *invalid input for QuizSystem.studentMenu()
        Invalid input!
        1. take quiz
        2. take quiz by importing answer file
        3. quit

        ex.B: *invalid input for QuizSystem.studentMenu() (try to take quiz that is not existed)
        1. take quiz
        2. take quiz by importing answer file
        3. quit
        [1]
        Please choose course:
        [unmatched course name]
        Please input quiz name:
        [unmatched quiz name]
        Invalid course name or quiz name!
        1. take quiz
        2. take quiz by importing answer file
        3. quit

        ex.C: *invalid input for QuizSystem.studentMenu() (try to take quiz in the course that is not existed)
        1. take quiz
        2. take quiz by importing answer file
        3. quit
        [1]
        Please choose course:
        [unmatched course name]
        Please input quiz name:
        [unmatched quiz name]
        Invalid course name or quiz name!
        1. take quiz
        2. take quiz by importing answer file
        3. quit
        */

    }
}
