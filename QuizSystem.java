import java.io.*;
import java.sql.Timestamp;
import java.util.Scanner;

/**
 * PJ 04 -- QuizSystem.java
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

public class QuizSystem {
    Scanner scanner = new Scanner(System.in);

    public QuizSystem() { // constructor for QuizSystem class, to be called in other classes

    }

    public void teacherQuizFilePrompt() throws IOException {
        /*
        Functionality: add quiz by letting user input file name only if user has teacher's account
        Test:
            Please choose course:
            cs
            Please input the file name:
            quiz2
            Quiz successfully added!
            1. add course
            2. add quiz
            3. edit quiz
            4. delete quiz
            5. view submission
            6. add quiz by importing file
            7. quit
        Relationship to other classes: called in QuizSystem.teacherMenu() when user choose to add quiz by importing
            file name
        */
        System.out.println("Please choose course: ");
        String courseName = scanner.nextLine();
        File course = new File("Course.txt");
        if (course.exists()) {
            FileReader cfr = new FileReader(course);
            BufferedReader cbr = new BufferedReader(cfr);
            String courses;
            boolean hasCourse = false;
            while ((courses = cbr.readLine()) != null) {
                if (courseName.equals(courses)) {
                    hasCourse = true;
                }
            }
            if (hasCourse) {
                System.out.println("Please input the file name: ");
                String fileName = scanner.nextLine();
                File userFile = new File(fileName);
                File newFile = new File(courseName + "-" + fileName);
                if (userFile.exists()) {
                    userFile.renameTo(newFile);
                    System.out.println("Quiz successfully added!");
                } else {
                    System.out.println("File does not exist!");
                }
            }
            if (!hasCourse) {
                System.out.println("Invalid course!");
            }
        } else {
            System.out.println("Course does not exist");
        }
    }

    public void studentAnswerFilePrompt() throws IOException {
        /*
        Functionality: add answer to quiz by letting user input file name only if user has student's account
        Test:
            Please choose course:
            cs
            Please input quiz name:
            quiz2
            Please input the file name:
            cs-quiz2studentSubmission
            File successfully detected.
            1. take quiz
            2. take quiz by importing answer file
            3. quit
        Relationship to other classes: called in QuizSystem.studentMenu() when user choose to add quiz answer by
            importing file name
        */
        while (true) {
            System.out.println("Please choose course: ");
            String courseName = scanner.nextLine();
            System.out.println("Please input quiz name: ");
            String quizName = scanner.nextLine();
            File questionFile = new File(courseName + "-" + quizName);
            if (questionFile.exists()) {
                System.out.println("Please input the file name: ");
                String fileName = scanner.nextLine();
                File answerFile = new File(fileName);
                if (fileName.equals(courseName + "-" + quizName + "studentSubmission")) {
                    if (answerFile.exists()) {
                        System.out.println("File successfully detected.");
                    } else {
                        System.out.println("The file does not exist!");
                        break;
                    }
                } else {
                    System.out.println("Invalid file format!");
                    break;
                }
                Timestamp newTime = new Timestamp(System.currentTimeMillis());
                File timeFile = new File(courseName + "-" + quizName + "studentSubmissionTime");
                FileOutputStream fosT = new FileOutputStream(timeFile, false);
                PrintWriter pwT = new PrintWriter(fosT);
                pwT.println(newTime);
                pwT.close();
                break;
            } else {
                System.out.println("Invalid course name or quiz name!");
                break;
            }
        }
    }

    public void teacherMenu() throws IOException {
        /*
        Functionality: teacher's menu, teacher can add course or quiz, modify quiz question or delete quiz,
            view student's quiz submission, add quiz by importing file and only teacher's account can access it.
        Test:
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
        Relationship to other classes: to be called when DataPersistence.SignInAsTeacher() was called and run properly
            in Login();
        */
        while (true) {
            System.out.println("1. add course");
            System.out.println("2. add quiz");
            System.out.println("3. edit quiz");
            System.out.println("4. delete quiz");
            System.out.println("5. view submission");
            System.out.println("6. add quiz by importing file");
            System.out.println("7. quit");
            String teacherMainChoice = scanner.nextLine();
            while (!teacherMainChoice.equals("1") && !teacherMainChoice.equals("2") &&
                    !teacherMainChoice.equals("3") && !teacherMainChoice.equals("4") && !teacherMainChoice.equals("5")
                    && !teacherMainChoice.equals("6") && !teacherMainChoice.equals("7")) {
                System.out.println("Invalid input!");
                System.out.println("1. add course");
                System.out.println("2. add quiz");
                System.out.println("3. edit quiz");
                System.out.println("4. delete quiz");
                System.out.println("5. view submission");
                System.out.println("6. quit");
                teacherMainChoice = scanner.nextLine();
            }
            if (teacherMainChoice.equals("7")) {
                break;
            }
            if (teacherMainChoice.equals("6")) {
                teacherQuizFilePrompt();
            }
            if (teacherMainChoice.equals("1")) {
                System.out.println("Please input course name: ");
                String addCourse = scanner.nextLine();
                File f = new File("Course.txt");
                if (f.createNewFile()) {
                    FileOutputStream fos = new FileOutputStream(f, true);
                    PrintWriter pw = new PrintWriter(fos);
                    pw.println(addCourse);
                    pw.close();
                    System.out.println("Course added success!");
                } else {
                    FileOutputStream fos = new FileOutputStream(f, true);
                    PrintWriter pw = new PrintWriter(fos);
                    pw.println(addCourse);
                    pw.close();
                    System.out.println("Course added success!");
                }
            }
            if (teacherMainChoice.equals("2")) {
                System.out.println("Please choose course: ");
                String courseName = scanner.nextLine();
                File course = new File("Course.txt");
                FileReader cfr = new FileReader(course);
                BufferedReader cbr = new BufferedReader(cfr);
                String courses;
                boolean hasCourse = false;
                while ((courses = cbr.readLine()) != null) {
                    if (courseName.equals(courses)) {
                        hasCourse = true;
                    }
                }
                if (hasCourse) {
                    System.out.println("Please input quiz name: ");
                    String addQuiz = scanner.nextLine();
                    File f = new File(courseName + "-" + addQuiz);
                    if (f.createNewFile()) {
                        System.out.println("Quiz added success!");
                    }
                }
                if (!hasCourse) {
                    System.out.println("Invalid course!");
                    System.out.println("Please input correct course name!");
                }
            }
            if (teacherMainChoice.equals("3")) {
                System.out.println("Please choose course: ");
                String courseName = scanner.nextLine();
                System.out.println("Please input quiz name: ");
                String quizName = scanner.nextLine();
                File questionFile = new File(courseName + "-" + quizName);
                if (questionFile.exists()) {
                    String question = "";
                    FileOutputStream fos = new FileOutputStream(questionFile, false);
                    PrintWriter pw = new PrintWriter(fos);
                    String keepAddQuestion = "";
                    if (questionFile.createNewFile()) {
                        do {
                            System.out.println("Please choose question format: ");
                            System.out.println("1. multiple choice question. ");
                            System.out.println("2. fill in the blank");
                            System.out.println("3. true / false");
                            String questionFormat = scanner.nextLine();
                            while (!questionFormat.equals("1") && !questionFormat.equals("2") &&
                                    !questionFormat.equals("3")) {
                                System.out.println("Invalid input!");
                                System.out.println("Please choose question format: ");
                                System.out.println("1. multiple choice question. ");
                                System.out.println("2. fill in the blank");
                                System.out.println("3. true / false");
                                questionFormat = scanner.nextLine();
                            }
                            if (questionFormat.equals("1") || questionFormat.equals("3")) {
                                System.out.println("Please input question and choices in one line: ");
                                question = scanner.nextLine();
                            } else if (questionFormat.equals("2")) {
                                System.out.println("Please input question and answer blank in one line: ");
                                question = scanner.nextLine();
                            }
                            pw.println(question);
                            System.out.println("Do you want keep add questions? y/n");
                            keepAddQuestion = scanner.nextLine();
                            while (!keepAddQuestion.equals("y") && !keepAddQuestion.equals("n")) {
                                System.out.println("Invalid input!");
                                System.out.println("Do you want keep add questions? y/n");
                                keepAddQuestion = scanner.nextLine();
                            }
                        } while (keepAddQuestion.equals("y"));
                        pw.close();
                        System.out.println("Question modify success!");
                    } else {
                        do {
                            System.out.println("Please choose question format: ");
                            System.out.println("1. multiple choice question. ");
                            System.out.println("2. fill in the blank");
                            System.out.println("3. true / false");
                            String questionFormat = scanner.nextLine();
                            while (!questionFormat.equals("1") && !questionFormat.equals("2") &&
                                    !questionFormat.equals("3")) {
                                System.out.println("Invalid input!");
                                System.out.println("Please choose question format: ");
                                System.out.println("1. multiple choice question. ");
                                System.out.println("2. fill in the blank");
                                System.out.println("3. true / false");
                                questionFormat = scanner.nextLine();
                            }
                            if (questionFormat.equals("1") || questionFormat.equals("3")) {
                                System.out.println("Please input question and choices in one line: ");
                                question = scanner.nextLine();
                            } else if (questionFormat.equals("2")) {
                                System.out.println("Please input question and answer blank in one line: ");
                                question = scanner.nextLine();
                            }
                            pw.println(question);
                            System.out.println("Do you want keep add questions? y/n");
                            keepAddQuestion = scanner.nextLine();
                            while (!keepAddQuestion.equals("y") && !keepAddQuestion.equals("n")) {
                                System.out.println("Invalid input!");
                                System.out.println("Do you want keep add questions? y/n");
                                keepAddQuestion = scanner.nextLine();
                            }
                        } while (keepAddQuestion.equals("y"));
                        pw.close();
                        System.out.println("Question modify success!");
                    }
                } else {
                    System.out.println("Invalid course name or quiz name!");
                }
            }
            if (teacherMainChoice.equals("4")) {
                System.out.println("Please choose course: ");
                String courseName = scanner.nextLine();
                System.out.println("Please input quiz name: ");
                String quizName = scanner.nextLine();
                File questionFile = new File(courseName + "-" + quizName);
                if (questionFile.exists()) {
                    questionFile.delete();
                    System.out.println("Quiz deleted success!");
                } else {
                    System.out.println("Invalid course name or quiz name!");
                }
            }
            if (teacherMainChoice.equals("5")) {
                System.out.println("Please choose course: ");
                String courseName = scanner.nextLine();
                System.out.println("Please input quiz name: ");
                String quizName = scanner.nextLine();
                File quizFile = new File(courseName + "-" + quizName);
                File answerFile = new File(courseName + "-" + quizName + "studentSubmission");
                File timeFile = new File(courseName + "-" + quizName + "studentSubmissionTime");
                if (answerFile.exists()) {
                    FileReader fr = new FileReader(answerFile);
                    BufferedReader bfr = new BufferedReader(fr);
                    FileReader quizfr = new FileReader(quizFile);
                    BufferedReader quizbfr = new BufferedReader(quizfr);
                    FileReader frT = new FileReader(timeFile);
                    BufferedReader bfrT = new BufferedReader(frT);
                    String answer;
                    String quiz;
                    String time = bfrT.readLine();
                    System.out.println("Submission time: " + time);
                    while ((answer = bfr.readLine()) != null && (quiz = quizbfr.readLine()) != null) {
                        System.out.println(quiz);
                        System.out.println(answer);
                    }
                } else {
                    System.out.println("Invalid course name or quiz name!");
                }
            }
        }
    }

    public void studentMenu() throws IOException {
        /*
        Functionality: student's quiz system menu, student can take quiz and submit it. Only student's account can
            access it.
        Test:
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
        Relationship to other classes: to be called when DataPersistence.SignInAsTeacher() was called and run properly
            in Login();
        */
        while (true) {
            System.out.println("1. take quiz");
            System.out.println("2. take quiz by importing answer file");
            System.out.println("3. quit");
            String studentMainChoice = scanner.nextLine();
            while (!studentMainChoice.equals("1") && !studentMainChoice.equals("2") && !studentMainChoice.equals("3")) {
                System.out.println("Invalid input!");
                System.out.println("1. take quiz");
                System.out.println("2. take quiz by importing answer file");
                System.out.println("3. quit");
                studentMainChoice = scanner.nextLine();
            }
            if (studentMainChoice.equals("3")) {
                break;
            }
            if (studentMainChoice.equals("2")) {
                studentAnswerFilePrompt();
            }
            if (studentMainChoice.equals("1")) {
                System.out.println("Please choose course: ");
                String courseName = scanner.nextLine();
                System.out.println("Please input quiz name: ");
                String quizName = scanner.nextLine();
                File questionFile = new File(courseName + "-" + quizName);
                File answerFile = new File(courseName + "-" + quizName + "studentSubmission");
                if (questionFile.exists()) {
                    boolean alreadySubmit = false;
                    do {
                        FileReader fr = new FileReader(questionFile);
                        BufferedReader bfr = new BufferedReader(fr);
                        FileOutputStream fos = new FileOutputStream(answerFile, false);
                        PrintWriter pw = new PrintWriter(fos);
                        String question;
                        String answer;
                        while ((question = bfr.readLine()) != null) {
                            System.out.println(question);
                            System.out.println("Please input your answer for the question: ");
                            answer = scanner.nextLine();
                            pw.println(answer);
                        }
                        pw.close();
                        System.out.println("Do you want to submit or do quiz again? y/n");
                        String submitOrNot = scanner.nextLine();
                        while (!submitOrNot.equals("y") && !submitOrNot.equals("n")) {
                            System.out.println("Invalid input!");
                            System.out.println("Do you want to submit or do quiz again? y/n");
                            submitOrNot = scanner.nextLine();
                        }
                        if (submitOrNot.equals("y")) {
                            Timestamp newTime = new Timestamp(System.currentTimeMillis());
                            File timeFile = new File(courseName + "-" + quizName + "studentSubmissionTime");
                            FileOutputStream fosT = new FileOutputStream(timeFile, false);
                            PrintWriter pwT = new PrintWriter(fosT);
                            pwT.println(newTime);
                            pwT.close();
                            alreadySubmit = true;
                        }
                    } while (!alreadySubmit);
                } else {
                    System.out.println("Invalid course name or quiz name!");
                }
            }
        }

    }
}
