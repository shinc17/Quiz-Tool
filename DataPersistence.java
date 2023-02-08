import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PJ 04 -- DataPersistence.java
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

public class DataPersistence {
    Scanner scanner = null;

    public DataPersistence() { // constructor for DataPersistence class, to be called in other classes

    }

    public void storeNewStudentAccount(String username, String password) throws IOException {
        /*
        Functionality: store student's account information to text file "StudentAccount.txt"
        Test: storeNewStudentAccount(username, password) -> "StudentAccount.txt" ->
            append line "username\npassword"
        Relationship to other classes: to be called when Login.signUp() were called.
        */
        File f = new File("StudentAccount.txt");
        if (f.createNewFile()) {
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(username);
            pw.println(password);
            pw.close();
        } else {
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(username);
            pw.println(password);
            pw.close();
        }
    }

    public void storeNewTeacherAccount(String username, String password) throws IOException {
        /*
        Functionality: store teacher's account information to text file "TeacherAccount.txt"
        Test: storeNewTeacherAccount(username, password) -> "TeacherAccount.txt" ->
            append line "username\npassword"
        Relationship to other classes: to be called when Login.signUp() were called.
        */
        File f = new File("TeacherAccount.txt");
        if (f.createNewFile()) {
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(username);
            pw.println(password);
            pw.close();
        } else {
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintWriter pw = new PrintWriter(fos);
            pw.println(username);
            pw.println(password);
            pw.close();
        }
    }

    public void editStudentAccount() throws IOException {
        /*
        Functionality: edit student's account information in the text file "StudentAccount.txt"
        Test: editStudentAccount() -> if "StudentAccount.txt" has contents ->
            find the position of old username and password -> update to new username and password
        Relationship to other classes: to be called when Login.editAccount() were called.
        */
        ArrayList<String> preAccount = new ArrayList<String>();
        File f = new File("StudentAccount.txt");
        if (f.createNewFile()) {
            System.out.println("There is no existing student account!!!");
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Please enter your old user name: ");
            String namePrompt = scanner.nextLine();
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            int matchedPasswordIndex = -1; // if name matched, the index of it plus 1 which indicate the index of it's paired password
            String matchedPassword = ""; // matched password
            String line;
            int indexCount = 0;
            while ((line = bfr.readLine()) != null) {
                if (indexCount % 2 == 0) {
                    if (line.equals(namePrompt)) {
                        matchedPasswordIndex = indexCount + 1;
                    }
                }
                if (matchedPasswordIndex == indexCount) {
                    matchedPassword = line;
                    break;
                }
                indexCount++;
            }
            if (matchedPassword.equals("")) {
                System.out.println("Username does not exist!");
            } else {
                System.out.println("Please enter your old password: ");
                String passwordPrompt = scanner.nextLine();
                if (passwordPrompt.equals(matchedPassword)) {
                    System.out.println("Please enter your new user name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Please enter your new password: ");
                    String newPassword = scanner.nextLine();
                    FileReader fr2 = new FileReader(f);
                    BufferedReader bfr2 = new BufferedReader(fr2);
                    String line2;
                    while ((line2 = bfr2.readLine()) != null) {
                        if (line2.equals(namePrompt)) {
                            preAccount.add(newName);
                        } else if (line2.equals(matchedPassword)) {
                            preAccount.add(newPassword);
                        } else {
                            preAccount.add(line2);
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(f, false);
                    PrintWriter pw = new PrintWriter(fos);
                    for (int i = 0; i < preAccount.size(); i++) {
                        pw.println(preAccount.get(i));
                    }
                    pw.close();
                    System.out.println("Account successfully edited!");
                } else {
                    System.out.println("Incorrect password!");
                }
            }
        }
    }

    public void editTeacherAccount() throws IOException {
        /*
        Functionality: edit teacher's account information in the text file "TeacherAccount.txt"
        Test: editTeacherAccount() -> if "TeacherAccount.txt" has contents ->
            find the position of old username and password -> update to new username and password
        Relationship to other classes: to be called when Login.editAccount() were called.
        */
        ArrayList<String> preAccount = new ArrayList<String>();
        File f = new File("TeacherAccount.txt");
        if (f.createNewFile()) {
            System.out.println("There is no existing teacher account!!!");
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Please enter your old user name: ");
            String namePrompt = scanner.nextLine();
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            int matchedPasswordIndex = -1; // if name matched, the index of it plus 1 which indicate the index of it's paired password
            String matchedPassword = ""; // matched password
            String line;
            int indexCount = 0;
            while ((line = bfr.readLine()) != null) {
                if (indexCount % 2 == 0) {
                    if (line.equals(namePrompt)) {
                        matchedPasswordIndex = indexCount + 1;
                    }
                }
                if (matchedPasswordIndex == indexCount) {
                    matchedPassword = line;
                    break;
                }
                indexCount++;
            }
            if (matchedPassword.equals("")) {
                System.out.println("Username does not exist!");
            } else {
                System.out.println("Please enter your old password: ");
                String passwordPrompt = scanner.nextLine();
                if (passwordPrompt.equals(matchedPassword)) {
                    System.out.println("Please enter your new user name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Please enter your new password: ");
                    String newPassword = scanner.nextLine();
                    FileReader fr2 = new FileReader(f);
                    BufferedReader bfr2 = new BufferedReader(fr2);
                    String line2;
                    while ((line2 = bfr2.readLine()) != null) {
                        if (line2.equals(namePrompt)) {
                            preAccount.add(newName);
                        } else if (line2.equals(matchedPassword)) {
                            preAccount.add(newPassword);
                        } else {
                            preAccount.add(line2);
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(f, false);
                    PrintWriter pw = new PrintWriter(fos);
                    for (int i = 0; i < preAccount.size(); i++) {
                        pw.println(preAccount.get(i));
                    }
                    pw.close();
                    System.out.println("Account successfully edited!");
                } else {
                    System.out.println("Incorrect password!");
                }
            }
        }
    }

    public void deleteStudentAccount() throws IOException {
        /*
        Functionality: delete student's account information in the text file "StudentAccount.txt"
        Test: deleteStudentAccount() -> "StudentAccount.txt" ->
            delete line "username\npassword"
        Relationship to other classes: to be called when Login.deleteAccount() were called.
        */
        ArrayList<String> preAccount = new ArrayList<String>();
        File f = new File("StudentAccount.txt");
        if (f.createNewFile()) {
            System.out.println("There is no existing student account!!!");
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Please enter your user name: ");
            String namePrompt = scanner.nextLine();
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            int matchedPasswordIndex = -1; // if name matched, the index of it plus 1 which indicate the index of it's paired password
            String matchedPassword = ""; // matched password
            String line;
            int indexCount = 0;
            while ((line = bfr.readLine()) != null) {
                if (indexCount % 2 == 0) {
                    if (line.equals(namePrompt)) {
                        matchedPasswordIndex = indexCount + 1;
                    }
                }
                if (matchedPasswordIndex == indexCount) {
                    matchedPassword = line;
                    break;
                }
                indexCount++;
            }
            if (matchedPassword.equals("")) {
                System.out.println("Username does not exist!");
            } else {
                System.out.println("Please enter your password: ");
                String passwordPrompt = scanner.nextLine();
                if (passwordPrompt.equals(matchedPassword)) {
                    FileReader fr2 = new FileReader(f);
                    BufferedReader bfr2 = new BufferedReader(fr2);
                    String line2;
                    while ((line2 = bfr2.readLine()) != null) {
                        if (line2.equals(namePrompt)) {

                        } else if (line2.equals(matchedPassword)) {

                        } else {
                            preAccount.add(line2);
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(f, false);
                    PrintWriter pw = new PrintWriter(fos);
                    for (int i = 0; i < preAccount.size(); i++) {
                        pw.println(preAccount.get(i));
                    }
                    pw.close();
                    System.out.println("Account successfully deleted!");
                } else {
                    System.out.println("Incorrect password!");
                }
            }
        }
    }

    public void deleteTeacherAccount() throws IOException {
        /*
        Functionality: delete teacher's account information in the text file "TeacherAccount.txt"
        Test: deleteTeacherAccount() -> "TeacherAccount.txt" ->
            delete line "username\npassword"
        Relationship to other classes: to be called when Login.deleteAccount() were called.
        */
        ArrayList<String> preAccount = new ArrayList<String>();
        File f = new File("TeacherAccount.txt");
        if (f.createNewFile()) {
            System.out.println("There is no existing teacher account!!!");
        } else {
            scanner = new Scanner(System.in);
            System.out.println("Please enter your user name: ");
            String namePrompt = scanner.nextLine();
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            int matchedPasswordIndex = -1; // if name matched, the index of it plus 1 which indicate the index of it's paired password
            String matchedPassword = ""; // matched password
            String line;
            int indexCount = 0;
            while ((line = bfr.readLine()) != null) {
                if (indexCount % 2 == 0) {
                    if (line.equals(namePrompt)) {
                        matchedPasswordIndex = indexCount + 1;
                    }
                }
                if (matchedPasswordIndex == indexCount) {
                    matchedPassword = line;
                    break;
                }
                indexCount++;
            }
            if (matchedPassword.equals("")) {
                System.out.println("Username does not exist!");
            } else {
                System.out.println("Please enter password: ");
                String passwordPrompt = scanner.nextLine();
                if (passwordPrompt.equals(matchedPassword)) {
                    FileReader fr2 = new FileReader(f);
                    BufferedReader bfr2 = new BufferedReader(fr2);
                    String line2;
                    while ((line2 = bfr2.readLine()) != null) {
                        if (line2.equals(namePrompt)) {

                        } else if (line2.equals(matchedPassword)) {

                        } else {
                            preAccount.add(line2);
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(f, false);
                    PrintWriter pw = new PrintWriter(fos);
                    for (int i = 0; i < preAccount.size(); i++) {
                        pw.println(preAccount.get(i));
                    }
                    pw.close();
                    System.out.println("Account successfully deleted!");
                } else {
                    System.out.println("Incorrect password!");
                }
            }
        }
    }

    public String SignInAsTeacher() throws IOException {
        /*
        Functionality: sign in using existing student or teacher account, return "Teacher" if successfully sign in
            using teacher's account, return "Student" if successfully sign in using student's account, print
            Login.mainPrompt() and return user's choice if sign in failed.
        Test: SignInAsTeacher() -> if "Teacher.txt" has contents/if "Student.txt" has contents
            (depends on which account type that used chose)->
            if password and username matched -> signIn
        Relationship to other classes: to be called when Login.menu() were called.
        */
        Login login = new Login();
        boolean isTeacher = login.isTeacher();
        scanner = new Scanner(System.in);
        if (isTeacher) {
            File f = new File("TeacherAccount.txt");
            if (f.createNewFile()) {
                System.out.println("There is no existing teacher account!!!");
            } else {
                System.out.println("Please enter your user name: ");
                String namePrompt = scanner.nextLine();
                System.out.println("Please enter password: ");
                String passwordPrompt = scanner.nextLine();
                FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr);
                String line;
                int index = 0;
                int matchedPasswordIndex = -1;
                boolean matchedAccount = false;
                while ((line = bfr.readLine()) != null) {
                    if (line.equals(namePrompt)) {
                        matchedPasswordIndex = index + 1;
                    }
                    if (index == matchedPasswordIndex) {
                        if (passwordPrompt.equals(line)) {
                            matchedAccount = true;
                        }
                    }
                    index++;
                }
                if (matchedAccount) {
                    System.out.println("Sign in success! Welcome teacher " + namePrompt);
                    return "Teacher";
                }
                if (!matchedAccount) {
                    System.out.println("Invalid username or password!");
                }
            }
        }
        if (!isTeacher) {
            File f = new File("StudentAccount.txt");
            if (f.createNewFile()) {
                System.out.println("There is no existing student account!!!");
            } else {
                System.out.println("Please enter your user name: ");
                String namePrompt = scanner.nextLine();
                System.out.println("Please enter password: ");
                String passwordPrompt = scanner.nextLine();
                FileReader fr = new FileReader(f);
                BufferedReader bfr = new BufferedReader(fr);
                String line;
                int index = 0;
                int matchedPasswordIndex = -1;
                boolean matchedAccount = false;
                while ((line = bfr.readLine()) != null) {
                    if (line.equals(namePrompt)) {
                        matchedPasswordIndex = index + 1;
                    }
                    if (index == matchedPasswordIndex) {
                        if (passwordPrompt.equals(line)) {
                            matchedAccount = true;
                        }
                    }
                    index++;
                }
                if (matchedAccount) {
                    System.out.println("Sign in success! Welcome student " + namePrompt);
                    return "Student";
                }
                if (!matchedAccount) {
                    System.out.println("Invalid username or password!");
                }
            }
        }
        String mainChoice = login.mainPrompt();
        return mainChoice;
    }

}
