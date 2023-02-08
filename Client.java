import javax.swing.*;
import java.io.*;
import java.net.*;
import java.sql.Timestamp;

public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        PrintWriter writer = null;
        Socket socket = null;

        boolean loginSuccess = false;
        boolean keepServerOpen = true;
        boolean keepQuizSystemOpen = true;
        String signInIdentity = "";

        do {
            if (!keepServerOpen) {
                break;
            }
            try {
                socket = new Socket("localhost", 2222);
            } catch (ConnectException | UnknownHostException e) {
                JOptionPane.showMessageDialog(null, "Connection fail!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());

            do {
                loginSuccess = false;
                JOptionPane.showMessageDialog(null, "Welcome to the login panel!",
                        "Welcome",
                        JOptionPane.INFORMATION_MESSAGE);
                String[] loginInterfaceOptions = {"Sign in", "Sign up", "Edit account", "Delete account", "Exit"};
                int loginInterfaceChoice = JOptionPane.showOptionDialog(null,
                        "Please select options", "Login Interface",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, loginInterfaceOptions,
                        loginInterfaceOptions[0]);
                writer.write(String.valueOf(loginInterfaceChoice));
                writer.println();
                writer.flush();

                if (loginInterfaceChoice == 0) {
                    String[] teacherOrStudent = {"Teacher", "Student"};
                    int accountType = JOptionPane.showOptionDialog(null,
                            "Please select account type of your account",
                            "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, teacherOrStudent, teacherOrStudent[0]);
                    writer.write(String.valueOf(accountType));
                    writer.println();
                    writer.flush();
                    String signInName;
                    do {
                        signInName = JOptionPane.showInputDialog(null,
                                "Please input your username",
                                "Username", JOptionPane.QUESTION_MESSAGE);
                    } while (signInName == null);
                    String signInPassword;
                    do {
                        signInPassword = JOptionPane.showInputDialog(null,
                                "Please input your password",
                                "Password", JOptionPane.QUESTION_MESSAGE);
                    } while (signInPassword == null);
                    writer.write(signInName);
                    writer.println();
                    writer.flush();
                    writer.write(signInPassword);
                    writer.println();
                    writer.flush();

                    String signUpResult = reader.readLine();

                    if (signUpResult.equals("SignInSuccess")) {
                        if (accountType == 0) {
                            signInIdentity = "Teacher";
                        } else {
                            signInIdentity = "Student";
                        }
                        JOptionPane.showMessageDialog(null,
                                "Sign in success!", "Welcome " + signInName,
                                JOptionPane.INFORMATION_MESSAGE);
                        loginSuccess = true;
                    }
                    if (signUpResult.equals("AccountNotMatched")) {
                        JOptionPane.showMessageDialog(null, "Username does not exist!",
                                "Username Unmatched", JOptionPane.ERROR_MESSAGE);
                    }
                    if (signUpResult.equals("PasswordNotMatched")) {
                        JOptionPane.showMessageDialog(null,
                                "Password does not matched your username!",
                                "Password Unmatched", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (loginInterfaceChoice == 1) { // signUp
                    String[] teacherOrStudent = {"Teacher", "Student"};
                    int accountType = JOptionPane.showOptionDialog(null,
                            "Please select account type of your account",
                            "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, teacherOrStudent, teacherOrStudent[0]);
                    writer.write(String.valueOf(accountType));
                    writer.println();
                    writer.flush();
                    String signUpName;
                    do {
                        signUpName = JOptionPane.showInputDialog(null,
                                "Please input your username",
                                "Username", JOptionPane.QUESTION_MESSAGE);
                    } while (signUpName == null);
                    String signUpPassword;
                    do {
                        signUpPassword = JOptionPane.showInputDialog(null,
                                "Please input your password",
                                "Password", JOptionPane.QUESTION_MESSAGE);
                    } while (signUpPassword == null);
                    writer.write(signUpName);
                    writer.println();
                    writer.flush();
                    writer.write(signUpPassword);
                    writer.println();
                    writer.flush();

                    String signUpResult = reader.readLine();

                    if (signUpResult.equals("AccountExist")) {
                        JOptionPane.showMessageDialog(null,
                                "The username already exist in the system!", "Username Exist",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    if (signUpResult.equals("SignUpSuccess")) {
                        JOptionPane.showMessageDialog(null, "Sign up success!",
                                "Sign up success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if (loginInterfaceChoice == 2) {
                    String[] teacherOrStudent = {"Teacher", "Student"};
                    int accountType = JOptionPane.showOptionDialog(null,
                            "Please select account type of your account",
                            "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, teacherOrStudent, teacherOrStudent[0]);
                    writer.write(String.valueOf(accountType));
                    writer.println();
                    writer.flush();

                    String oldUsername;
                    do {
                        oldUsername = JOptionPane.showInputDialog(null,
                                "Please input your username",
                                "Username", JOptionPane.QUESTION_MESSAGE);
                    } while (oldUsername == null);

                    String oldPassword;
                    do {
                        oldPassword = JOptionPane.showInputDialog(null,
                                "Please input your old password",
                                "Password", JOptionPane.QUESTION_MESSAGE);
                    } while (oldPassword == null);

                    String newPassword;
                    do {
                        newPassword = JOptionPane.showInputDialog(null,
                                "Please input your new password",
                                "Password", JOptionPane.QUESTION_MESSAGE);
                    } while (newPassword == null);
                    writer.write(oldUsername);
                    writer.println();
                    writer.flush();
                    writer.write(oldPassword);
                    writer.println();
                    writer.flush();
                    writer.write(newPassword);
                    writer.println();
                    writer.flush();

                    String editResult = reader.readLine();

                    if (editResult.equals("EditSuccess")) {
                        JOptionPane.showMessageDialog(null,
                                "Successful edited your password!", "Edit Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    if (editResult.equals("AccountNotMatched")) {
                        JOptionPane.showMessageDialog(null, "Username does not exist!",
                                "Username Unmatched", JOptionPane.ERROR_MESSAGE);
                    }
                    if (editResult.equals("PasswordNotMatched")) {
                        JOptionPane.showMessageDialog(null,
                                "Password does not matched your username!",
                                "Password Unmatched", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (loginInterfaceChoice == 3) {
                    String[] teacherOrStudent = {"Teacher", "Student"};
                    int accountType = JOptionPane.showOptionDialog(null,
                            "Please select account type of your account",
                            "Account Type", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, teacherOrStudent, teacherOrStudent[0]);
                    writer.write(String.valueOf(accountType));
                    writer.println();
                    writer.flush();

                    String oldUsername;
                    do {
                        oldUsername = JOptionPane.showInputDialog(null,
                                "Please input your username",
                                "Username", JOptionPane.QUESTION_MESSAGE);
                    } while (oldUsername == null);

                    String oldPassword;
                    do {
                        oldPassword = JOptionPane.showInputDialog(null,
                                "Please input your old password",
                                "Password", JOptionPane.QUESTION_MESSAGE);
                    } while (oldPassword == null);

                    writer.write(oldUsername);
                    writer.println();
                    writer.flush();
                    writer.write(oldPassword);
                    writer.println();
                    writer.flush();

                    String editResult = reader.readLine();

                    if (editResult.equals("DeleteSuccess")) {
                        JOptionPane.showMessageDialog(null,
                                "Successful deleted your account!", "Delete Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (editResult.equals("AccountNotMatched")) {
                        JOptionPane.showMessageDialog(null, "Username does not exist!",
                                "Username Unmatched", JOptionPane.ERROR_MESSAGE);
                    } else if (editResult.equals("PasswordNotMatched")) {
                        JOptionPane.showMessageDialog(null,
                                "Password does not matched your username!",
                                "Password Unmatched", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (loginInterfaceChoice == 4) {
                    keepQuizSystemOpen = false;
                    keepServerOpen = false;
                    JOptionPane.showMessageDialog(null, "Bye!",
                            "Farewell", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            } while (!loginSuccess);

            do {
                if (!keepServerOpen) {
                    break;
                }
                if (signInIdentity.equals("Teacher")) {
                    writer.write("Teacher");
                    writer.println();
                    writer.flush();

                    JOptionPane.showMessageDialog(null, "Welcome to the quiz system!",
                            "Welcome",
                            JOptionPane.INFORMATION_MESSAGE);
                    String[] teacherOptions = {"add course", "add quiz", "edit quiz", "delete quiz", "view submission",
                            "add quiz by importing file", "quit"};
                    int loginInterfaceChoice = JOptionPane.showOptionDialog(null,
                            "Please select options", "Login Interface",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, teacherOptions,
                            teacherOptions[0]);
                    writer.write(String.valueOf(loginInterfaceChoice));
                    writer.println();
                    writer.flush();
                    if (loginInterfaceChoice == 0) {
                        String newCourse = "";
                        do {
                            newCourse = JOptionPane.showInputDialog(null,
                                    "Please input course name",
                                    "New Course", JOptionPane.QUESTION_MESSAGE);
                        } while (newCourse == null);
                        writer.write(newCourse);
                        writer.println();
                        writer.flush();

                        String newCourseResult = reader.readLine();

                        if (newCourseResult.equals("CourseAlreadyExist")) {
                            JOptionPane.showMessageDialog(null,
                                    "The course already exist in the system!", "Course Exist",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        if (newCourseResult.equals("CourseAddSuccess")) {
                            JOptionPane.showMessageDialog(null,
                                    "The course added successfully", "Course Added",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                    if (loginInterfaceChoice == 1) {
                        String createQuizResult = reader.readLine();
                        if (createQuizResult.equals("NoCourse")) {
                            JOptionPane.showMessageDialog(null,
                                    "No course exist in the system!", "No Course",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            String choseCourse = "";
                            do {
                                choseCourse = JOptionPane.showInputDialog(null,
                                        "Please input course name",
                                        "Choose Course", JOptionPane.QUESTION_MESSAGE);
                            } while (choseCourse == null);
                            writer.write(choseCourse);
                            writer.println();
                            writer.flush();
                            String CourseExist = reader.readLine();
                            if (CourseExist.equals("CourseNotExist")) {
                                JOptionPane.showMessageDialog(null,
                                        "The course does not exist in the system!", "Unmatched Course",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                String quizName = "";
                                do {
                                    quizName = JOptionPane.showInputDialog(null,
                                            "Please input quiz name",
                                            "Quiz Name", JOptionPane.QUESTION_MESSAGE);
                                } while (quizName == null);
                                writer.write(quizName);
                                writer.println();
                                writer.flush();
                                String FinalResult = reader.readLine();
                                if (FinalResult.equals("QuizAlreadyExist")) {
                                    JOptionPane.showMessageDialog(null,
                                            "The quiz already exist in the course!", "Exist Quiz",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                                if (FinalResult.equals("QuizAddSuccess")) {
                                    JOptionPane.showMessageDialog(null,
                                            "The quiz added to the course", "Quiz Added",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                        }
                    }
                    if (loginInterfaceChoice == 2) {
                        String createQuizResult = reader.readLine();
                        if (createQuizResult.equals("NoCourse")) {
                            JOptionPane.showMessageDialog(null,
                                    "No course exist in the system!", "No Course",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            String choseCourse = "";
                            do {
                                choseCourse = JOptionPane.showInputDialog(null,
                                        "Please input course name",
                                        "Choose Course", JOptionPane.QUESTION_MESSAGE);
                            } while (choseCourse == null);
                            writer.write(choseCourse);
                            writer.println();
                            writer.flush();
                            String CourseExist = reader.readLine();
                            if (CourseExist.equals("CourseNotExist")) {
                                JOptionPane.showMessageDialog(null,
                                        "The course does not exist in the system!", "Unmatched Course",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                String quizName = "";
                                do {
                                    quizName = JOptionPane.showInputDialog(null,
                                            "Please input quiz name",
                                            "Quiz Name", JOptionPane.QUESTION_MESSAGE);
                                } while (quizName == null);
                                writer.write(quizName);
                                writer.println();
                                writer.flush();
                                String FinalResult = reader.readLine();
                                if (FinalResult.equals("QuizMatched")) {
                                    String questionNumber = "";
                                    do {
                                        questionNumber = JOptionPane.showInputDialog(null,
                                                "Please input question number",
                                                "How many questions", JOptionPane.QUESTION_MESSAGE);
                                    } while (questionNumber == null);
                                    boolean numberException = false;
                                    try {
                                        int num = Integer.parseInt(questionNumber);
                                    } catch (NumberFormatException e) {
                                        numberException = true;
                                        JOptionPane.showMessageDialog(null,
                                                "Please input number!", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                    while (numberException) {
                                        questionNumber = JOptionPane.showInputDialog(null,
                                                "Please input question number",
                                                "How many questions", JOptionPane.QUESTION_MESSAGE);
                                        try {
                                            int num = Integer.parseInt(questionNumber);
                                            numberException = false;
                                        } catch (NumberFormatException e) {
                                            numberException = true;
                                            JOptionPane.showMessageDialog(null,
                                                    "Please input number!", "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                    writer.write(questionNumber);
                                    writer.println();
                                    writer.flush();
                                    for (int i = 0; i < Integer.parseInt(questionNumber); i++) {
                                        String question = "";
                                        do {
                                            String[] questionChoice = {"multiple choice", "fill in the blank",
                                                    "dropdown", "matching", "true / false"};
                                            int questionType = JOptionPane.showOptionDialog(null,
                                                    "Please select question form you want to use",
                                                    "Question Type", JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE,
                                                    null, questionChoice, questionChoice[0]);
                                            question = JOptionPane.showInputDialog(null,
                                                    "Please input question in one line with question number",
                                                    "Questions", JOptionPane.QUESTION_MESSAGE);
                                        } while (question == null);
                                        writer.write(question);
                                        writer.println();
                                        writer.flush();
                                    }
                                    JOptionPane.showMessageDialog(null,
                                            "The quiz edited successfully!", "Quiz Questions Added",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                                if (FinalResult.equals("QuizNotExist")) {
                                    JOptionPane.showMessageDialog(null,
                                            "The quiz not exist in the course", "Quiz Not Exist",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                    if (loginInterfaceChoice == 3) {
                        String createQuizResult = reader.readLine();
                        if (createQuizResult.equals("NoCourse")) {
                            JOptionPane.showMessageDialog(null,
                                    "No course exist in the system!", "No Course",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            String choseCourse = "";
                            do {
                                choseCourse = JOptionPane.showInputDialog(null,
                                        "Please input course name",
                                        "Choose Course", JOptionPane.QUESTION_MESSAGE);
                            } while (choseCourse == null);
                            writer.write(choseCourse);
                            writer.println();
                            writer.flush();
                            String CourseExist = reader.readLine();
                            if (CourseExist.equals("CourseNotExist")) {
                                JOptionPane.showMessageDialog(null,
                                        "The course does not exist in the system!", "Unmatched Course",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                String quizName = "";
                                do {
                                    quizName = JOptionPane.showInputDialog(null,
                                            "Please input quiz name",
                                            "Quiz Name", JOptionPane.QUESTION_MESSAGE);
                                } while (quizName == null);
                                writer.write(quizName);
                                writer.println();
                                writer.flush();
                                String FinalResult = reader.readLine();
                                if (FinalResult.equals("QuizDeleted")) {
                                    JOptionPane.showMessageDialog(null,
                                            "The quiz deleted from the course!", "Quiz Deleted",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                                if (FinalResult.equals("QuizNotExist")) {
                                    JOptionPane.showMessageDialog(null,
                                            "The quiz not exist in the course", "Quiz Not Exist",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                    if (loginInterfaceChoice == 4) {
                        String courseName = "";
                        do {
                            courseName = JOptionPane.showInputDialog(null,
                                    "Please input course name",
                                    "Course Name", JOptionPane.QUESTION_MESSAGE);
                        } while (courseName == null);
                        String quizName = "";
                        do {
                            quizName = JOptionPane.showInputDialog(null,
                                    "Please input quiz name",
                                    "Quiz Name", JOptionPane.QUESTION_MESSAGE);
                        } while (quizName == null);
                        writer.write(courseName);
                        writer.println();
                        writer.flush();
                        writer.write(quizName);
                        writer.println();
                        writer.flush();
                        String result = reader.readLine();
                        if (result.equals("Error")) {
                            JOptionPane.showMessageDialog(null,
                                    "Wrong!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        if (result.equals("Matched")) {
                            String num = reader.readLine();
                            for (int i = 0; i < Integer.parseInt(num); i++) {
                                String question = reader.readLine();
                                JOptionPane.showMessageDialog(null,
                                        question, "question",
                                        JOptionPane.INFORMATION_MESSAGE);
                                String answer = reader.readLine();
                                JOptionPane.showMessageDialog(null,
                                        answer, "answer",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                    if (loginInterfaceChoice == 5) {
                        String courseName = "";
                        do {
                            courseName = JOptionPane.showInputDialog(null,
                                    "Please input course name",
                                    "Course Name", JOptionPane.QUESTION_MESSAGE);
                        } while (courseName == null);
                        writer.write(courseName);
                        writer.println();
                        writer.flush();

                        String courseExistence = reader.readLine();
                        if (courseExistence.equals("NoCourse")) {
                            JOptionPane.showMessageDialog(null,
                                    "There's no course in the system!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        if (courseExistence.equals("CourseNotExist")) {
                            JOptionPane.showMessageDialog(null,
                                    "There's no matched course!", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        if (courseExistence.equals("CourseExist")) {
                            String userQuiz = "";
                            do {
                                userQuiz = JOptionPane.showInputDialog(null,
                                        "Please input quiz file name that you want to import",
                                        "File Name", JOptionPane.QUESTION_MESSAGE);
                            } while (userQuiz == null);
                            writer.write(userQuiz);
                            writer.println();
                            writer.flush();
                            String quizExistence = reader.readLine();
                            if (quizExistence.equals("FileNotExist")) {
                                JOptionPane.showMessageDialog(null,
                                        "There's no matched quiz file!", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            if (quizExistence.equals("FileExist")) {
                                JOptionPane.showMessageDialog(null,
                                        "You successfully imported the quiz!", "Import Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                    if (loginInterfaceChoice == 6) {
                        break;
                    }
                }
                if (signInIdentity.equals("Student")) {
                    writer.write("Student");
                    writer.println();
                    writer.flush();

                    JOptionPane.showMessageDialog(null, "Welcome to the quiz system!",
                            "Welcome",
                            JOptionPane.INFORMATION_MESSAGE);
                    String[] teacherOptions = {"take quiz", "quit"};
                    int loginInterfaceChoice = JOptionPane.showOptionDialog(null,
                            "Please select options", "Login Interface",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, teacherOptions,
                            teacherOptions[0]);
                    writer.write(String.valueOf(loginInterfaceChoice));
                    writer.println();
                    writer.flush();
                    if (loginInterfaceChoice == 0) {
                        String UserInputCourseName = "";
                        do {
                            UserInputCourseName = JOptionPane.showInputDialog(null,
                                    "Please input course name",
                                    "Course Name", JOptionPane.QUESTION_MESSAGE);
                        } while (UserInputCourseName == null);
                        String UserInputQuizName = "";
                        do {
                            UserInputQuizName = JOptionPane.showInputDialog(null,
                                    "Please input quiz name",
                                    "Quiz Name", JOptionPane.QUESTION_MESSAGE);
                        } while (UserInputQuizName == null);

                        writer.write(String.valueOf(UserInputCourseName));
                        writer.println();
                        writer.flush();
                        writer.write(String.valueOf(UserInputQuizName));
                        writer.println();
                        writer.flush();

                        String matchResult = reader.readLine();
                        if (matchResult.equals("Unmatched")) {
                            JOptionPane.showMessageDialog(null,
                                    "Quiz name or course name incorrect!", "Unmatched Info",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        if (matchResult.equals("Matched")) {
                            String questionNumber = reader.readLine();
                            for (int i = 0; i < Integer.parseInt(questionNumber); i++) {
                                String question = reader.readLine();
                                String answer;
                                do {
                                    answer = JOptionPane.showInputDialog(null,
                                            question,
                                            "Please answer the question", JOptionPane.QUESTION_MESSAGE);
                                } while (answer == null);
                                writer.write(answer);
                                writer.println();
                                writer.flush();
                            }
                            JOptionPane.showMessageDialog(null,
                                    "Good job! You finished the quiz!", "Quiz Completed",
                                    JOptionPane.INFORMATION_MESSAGE);

                        }
                    }
                    if (loginInterfaceChoice == 1) {
                        break;
                    }
                }
            } while (keepQuizSystemOpen);
        } while (keepServerOpen);

        writer.close();
        reader.close();
    }
}
