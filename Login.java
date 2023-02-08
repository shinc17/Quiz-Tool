import java.io.IOException;
import java.util.Scanner;

/**
 * PJ 04 -- Login.java
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

public class Login {
    Scanner scanner = null;

    public Login() { // constructor for Login class, to be called in other classes

    }

    public String mainPrompt() {
        /*
        Functionality: mainPrompt() of Login class, return user's choice to either sign in, sing up, edit account,
        or delete account, call mainPrompt() and return user choice.
        Test:
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

        Relationship to other classes: to be called when DataPersistence.SignInAsTeacher(), or Login.signUp(), or Login.menu(),
        or Login.editAccount(), or Login.deleteAccount() were called.
        */
        scanner = new Scanner(System.in);
        System.out.println("Welcome to the quiz system!");
        System.out.println("Please select options by typing option number.");
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        System.out.println("3. Edit account");
        System.out.println("4. Delete account");
        System.out.println("5. Exit");
        String mainChoice = scanner.nextLine();
        while (!mainChoice.equals("1") && !mainChoice.equals("2") && !mainChoice.equals("3") && !mainChoice.equals("4") && !mainChoice.equals("5")) {
            System.out.println("Invalid input!");
            System.out.println("Please select options by typing option number.");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Edit account");
            System.out.println("4. Delete account");
            System.out.println("5. Exit");
            mainChoice = scanner.nextLine();
        }
        return mainChoice;
    }

    public String signUp() throws IOException {
        /*
        Functionality: signUp new teacher or new student account, and store them in testFile using
            DataPersistence.storeNewStudentAccount() or DataPersistence.storeNewTeacherAccount(), call mainPrompt() and
            return user choice.
        Test:
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
        Relationship to other classes: to be called in Login.menu() when signUp was called and run properly
        */
        DataPersistence dataPersistence = new DataPersistence();
        scanner = new Scanner(System.in);
        boolean isTeacher = isTeacher();
        if (isTeacher) {
            System.out.println("Please enter your user name: ");
            String userName = scanner.nextLine();
            System.out.println("Please enter your password: ");
            String userPassword = scanner.nextLine();
            dataPersistence.storeNewTeacherAccount(userName, userPassword);
            System.out.println("sign up success!!!!");
        }
        if (!isTeacher) {
            System.out.println("Please enter your user name: ");
            String userName = scanner.nextLine();
            System.out.println("Please enter your password: ");
            String userPassword = scanner.nextLine();
            dataPersistence.storeNewStudentAccount(userName, userPassword);
            System.out.println("sign up success!!!!");
        }
        String mainChoice = mainPrompt();
        return mainChoice;
    }

    public boolean isTeacher() {
        /*
        Functionality: return boolean value checking if user is teacher or student by input 1 or 2 as user choice,
            call mainPrompt() and return user choice
        Test: copy information to here from test.java.
        Relationship to other classes: to be called in DataPersistence.SignInAsTeacher(), Login.signUp(), Login.menu();
        */
        scanner = new Scanner(System.in);
        System.out.println("Are you a teacher or student?");
        System.out.println("1. teacher");
        System.out.println("2. student");
        String reply = scanner.nextLine();
        while (!reply.equals("1") && !reply.equals("2")) {
            System.out.println("Invalid input! Please select options by input number!");
            System.out.println("Are you a teacher or student?");
            System.out.println("1. teacher");
            System.out.println("2. student");
            reply = scanner.nextLine();
        }
        if (Integer.parseInt(reply) == 1) {
            return true;
        }
        if (Integer.parseInt(reply) == 2) {
            return false;
        }
        return false;
    }

    public String editAccount() throws IOException {
        /*
        Functionality: edit account information that were stored in testFile using
            DataPersistence.editTeacherAccount() or DataPersistence.editStudentAccount(), call mainPrompt() and
            return user choice.
        Test:
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
        Relationship to other classes: to be called in Login.menu();
        */
        DataPersistence dataPersistence = new DataPersistence();
        boolean isTeacher = isTeacher();
        if (isTeacher) {
            dataPersistence.editTeacherAccount();
        }
        if (!isTeacher) {
            dataPersistence.editStudentAccount();
        }
        String mainChoice = mainPrompt();
        return mainChoice;
    }

    public String deleteAccount() throws IOException {
        /*
        Functionality: delete account information that were stored in testFile using
            DataPersistence.deleteTeacherAccount() or DataPersistence.deleteStudentAccount(), call mainPrompt() and
            return user choice.
        Test:
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
        Relationship to other classes: to be called in Login.menu();
        */
        DataPersistence dataPersistence = new DataPersistence();
        boolean isTeacher = isTeacher();
        if (isTeacher) {
            dataPersistence.deleteTeacherAccount();
        }
        if (!isTeacher) {
            dataPersistence.deleteStudentAccount();
        }
        String mainChoice = mainPrompt();
        return mainChoice;
    }

    public String menu() throws IOException {
        /*
        Functionality: loop Login menu until user signIn to the quiz system, return "Teacher" if user sign in using
            teacher's account, return "Student" if user sign in using student's account.
        Test: copy information to here from test.java.
        Relationship to other classes: to be called in the main method;
        */
        DataPersistence dataPersistence = new DataPersistence();
        String userChoice = mainPrompt();
        boolean signInSuccess = false;
        while (!signInSuccess) {
            if (userChoice.equals("1")) {
                userChoice = dataPersistence.SignInAsTeacher();
            } else if (userChoice.equals("2")) {
                userChoice = signUp();
            } else if (userChoice.equals("3")) {
                userChoice = editAccount();
            } else if (userChoice.equals("4")) {
                userChoice = deleteAccount();
            } else if (userChoice.equals("5")) {
                return "break";
            }
            if (userChoice.equals("Teacher") || userChoice.equals("Student")) {
                signInSuccess = true;
                break;
            }
        }
        return userChoice;
    }
}

