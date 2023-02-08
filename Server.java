import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.ArrayList;


public class Server {
    public static void main(String[] args) throws IOException {
        boolean keepServerOpen = true;
        BufferedReader reader = null;
        PrintWriter writer = null;
        ServerSocket serverSocket = new ServerSocket(2222);
        Socket socket = null;
        boolean keepQuizSystemOpen = true;
        boolean loginSuccess = false;
        String globalName = "";

        do {
            String loginInterfaceChoice = "";
            socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
            do {
                loginSuccess = false;
                loginInterfaceChoice = reader.readLine();
                int mainChoice = Integer.parseInt(loginInterfaceChoice);

                if (mainChoice == 0) {
                    String accountType = reader.readLine();
                    String signInName = reader.readLine();
                    String signInPassword = reader.readLine();
                    if (Integer.parseInt(accountType) == 0) {
                        File f = new File("TeacherAccount.txt");
                        if (f.createNewFile()) {
                            writer.write("AccountNotMatched");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            int passwordIndex = -1;
                            String line;
                            boolean accountNameMatched = false;
                            boolean accountPasswordMatched = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (signInName.equals(line)) {
                                        accountNameMatched = true;
                                        passwordIndex = indexCount + 1;
                                    }
                                } else {
                                    if (passwordIndex == indexCount) {
                                        if (signInPassword.equals(line)) {
                                            accountPasswordMatched = true;
                                        }
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameMatched && accountPasswordMatched) {
                                writer.write("SignInSuccess");
                                writer.println();
                                writer.flush();
                                loginSuccess = true;
                                globalName = signInName;
                            } else if (accountNameMatched && !accountPasswordMatched) {
                                writer.write("PasswordNotMatched");
                                writer.println();
                                writer.flush();
                            } else if (!accountNameMatched) {
                                writer.write("AccountNotMatched");
                                writer.println();
                                writer.flush();
                            }
                        }
                    }
                    if (Integer.parseInt(accountType) == 1) {
                        File f = new File("StudentAccount.txt");
                        if (f.createNewFile()) {
                            writer.write("AccountNotMatched");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            int passwordIndex = -1;
                            String line;
                            boolean accountNameMatched = false;
                            boolean accountPasswordMatched = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (signInName.equals(line)) {
                                        accountNameMatched = true;
                                        passwordIndex = indexCount + 1;
                                    }
                                } else {
                                    if (passwordIndex == indexCount) {
                                        if (signInPassword.equals(line)) {
                                            accountPasswordMatched = true;
                                        }
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameMatched && accountPasswordMatched) {
                                writer.write("SignInSuccess");
                                writer.println();
                                writer.flush();
                            } else if (accountNameMatched && !accountPasswordMatched) {
                                writer.write("PasswordNotMatched");
                                writer.println();
                                writer.flush();
                            } else if (!accountNameMatched) {
                                writer.write("AccountNotMatched");
                                writer.println();
                                writer.flush();
                            }
                        }
                    }
                }
                if (mainChoice == 1) {
                    String accountType = reader.readLine();
                    String signUpName = reader.readLine();
                    String signUpPassword = reader.readLine();
                    if (Integer.parseInt(accountType) == 0) {
                        File f = new File("TeacherAccount.txt");
                        if (f.createNewFile()) {
                            FileOutputStream fos = new FileOutputStream(f, true);
                            PrintWriter pw = new PrintWriter(fos);
                            pw.println(signUpName);
                            pw.println(signUpPassword);
                            pw.close();
                            writer.write("SignUpSuccess");
                            writer.println();
                            writer.flush();
                        } else {
                            FileOutputStream fos = new FileOutputStream(f, true);
                            PrintWriter pw = new PrintWriter(fos);
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            String line;
                            boolean accountNameExist = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (signUpName.equals(line)) {
                                        accountNameExist = true;
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameExist) {
                                writer.write("AccountExist");
                                writer.println();
                                writer.flush();
                            } else {
                                pw.println(signUpName);
                                pw.println(signUpPassword);
                                writer.write("SignUpSuccess");
                                writer.println();
                                writer.flush();
                            }
                            pw.close();
                        }
                    }
                    if (Integer.parseInt(accountType) == 1) {
                        File f = new File("StudentAccount.txt");
                        if (f.createNewFile()) {
                            FileOutputStream fos = new FileOutputStream(f, true);
                            PrintWriter pw = new PrintWriter(fos);
                            pw.println(signUpName);
                            pw.println(signUpPassword);
                            pw.close();
                            writer.write("SignUpSuccess");
                            writer.println();
                            writer.flush();
                        } else {
                            FileOutputStream fos = new FileOutputStream(f, true);
                            PrintWriter pw = new PrintWriter(fos);
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            String line;
                            boolean accountNameExist = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (signUpName.equals(line)) {
                                        accountNameExist = true;
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameExist) {
                                writer.write("AccountExist");
                                writer.println();
                                writer.flush();
                            } else {
                                pw.println(signUpName);
                                pw.println(signUpPassword);
                                writer.write("SignUpSuccess");
                                writer.println();
                                writer.flush();
                            }
                            pw.close();
                        }
                    }
                }
                if (mainChoice == 2) {
                    String accountType = reader.readLine();
                    String userName = reader.readLine();
                    String userPassword = reader.readLine();
                    String newPassword = reader.readLine();
                    if (Integer.parseInt(accountType) == 0) {
                        ArrayList<String> editContent = new ArrayList<String>();
                        File f = new File("TeacherAccount.txt");
                        if (f.createNewFile()) {
                            writer.write("AccountNotMatched");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            int passwordIndex = -1;
                            String line;
                            boolean accountNameMatched = false;
                            boolean accountPasswordMatched = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (userName.equals(line)) {
                                        accountNameMatched = true;
                                        passwordIndex = indexCount + 1;
                                    }
                                    editContent.add(line);
                                } else {
                                    if (passwordIndex == indexCount) {
                                        if (userPassword.equals(line)) {
                                            accountPasswordMatched = true;
                                            editContent.add(newPassword);
                                        } else {
                                            editContent.add(line);
                                        }
                                    } else {
                                        editContent.add(line);
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameMatched && accountPasswordMatched) {
                                FileOutputStream fos = new FileOutputStream(f, false);
                                PrintWriter pw = new PrintWriter(fos);
                                for (int i = 0; i < editContent.size(); i++) {
                                    pw.println(editContent.get(i));
                                }
                                pw.close();
                                writer.write("EditSuccess");
                                writer.println();
                                writer.flush();
                            }
                            if (!accountNameMatched) {
                                writer.write("AccountNotMatched");
                                writer.println();
                                writer.flush();
                            }
                            if (accountNameMatched && !accountPasswordMatched) {
                                writer.write("PasswordNotMatched");
                                writer.println();
                                writer.flush();
                            }
                        }
                    }
                    if (Integer.parseInt(accountType) == 1) {
                        ArrayList<String> editContent = new ArrayList<String>();
                        File f = new File("StudentAccount.txt");
                        if (f.createNewFile()) {
                            writer.write("AccountNotMatched");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            int passwordIndex = -1;
                            String line;
                            boolean accountNameMatched = false;
                            boolean accountPasswordMatched = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (userName.equals(line)) {
                                        accountNameMatched = true;
                                        passwordIndex = indexCount + 1;
                                    }
                                    editContent.add(line);
                                } else {
                                    if (passwordIndex == indexCount) {
                                        if (userPassword.equals(line)) {
                                            accountPasswordMatched = true;
                                            editContent.add(newPassword);
                                        } else {
                                            editContent.add(line);
                                        }
                                    } else {
                                        editContent.add(line);
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameMatched && accountPasswordMatched) {
                                FileOutputStream fos = new FileOutputStream(f, false);
                                PrintWriter pw = new PrintWriter(fos);
                                for (int i = 0; i < editContent.size(); i++) {
                                    pw.println(editContent.get(i));
                                }
                                pw.close();
                                writer.write("EditSuccess");
                                writer.println();
                                writer.flush();
                            } else if (!accountNameMatched) {
                                writer.write("AccountNotMatched");
                                writer.println();
                                writer.flush();
                            } else if (accountNameMatched && !accountPasswordMatched) {
                                writer.write("PasswordNotMatched");
                                writer.println();
                                writer.flush();
                            }
                        }
                    }
                }
                if (mainChoice == 3) {
                    String accountType = reader.readLine();
                    String userName = reader.readLine();
                    String userPassword = reader.readLine();
                    if (Integer.parseInt(accountType) == 0) {
                        ArrayList<String> editContent = new ArrayList<String>();
                        File f = new File("TeacherAccount.txt");
                        if (f.createNewFile()) {
                            writer.write("AccountNotMatched");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            int passwordIndex = -1;
                            String line;
                            boolean accountNameMatched = false;
                            boolean accountPasswordMatched = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (userName.equals(line)) {
                                        accountNameMatched = true;
                                        passwordIndex = indexCount + 1;
                                    } else {
                                        editContent.add(line);
                                    }
                                } else {
                                    if (passwordIndex == indexCount) {
                                        if (userPassword.equals(line)) {
                                            accountPasswordMatched = true;
                                        } else {
                                            editContent.add(line);
                                        }
                                    } else {
                                        editContent.add(line);
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameMatched && accountPasswordMatched) {
                                FileOutputStream fos = new FileOutputStream(f, false);
                                PrintWriter pw = new PrintWriter(fos);
                                for (int i = 0; i < editContent.size(); i++) {
                                    pw.println(editContent.get(i));
                                }
                                pw.close();
                                writer.write("DeleteSuccess");
                                writer.println();
                                writer.flush();
                            } else if (!accountNameMatched) {
                                writer.write("AccountNotMatched");
                                writer.println();
                                writer.flush();
                            } else if (accountNameMatched && !accountPasswordMatched) {
                                writer.write("PasswordNotMatched");
                                writer.println();
                                writer.flush();
                            }
                        }
                    }
                    if (Integer.parseInt(accountType) == 1) {
                        ArrayList<String> editContent = new ArrayList<String>();
                        File f = new File("StudentAccount.txt");
                        if (f.createNewFile()) {
                            writer.write("AccountNotMatched");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            int indexCount = 0;
                            int passwordIndex = -1;
                            String line;
                            boolean accountNameMatched = false;
                            boolean accountPasswordMatched = false;
                            while ((line = bfr.readLine()) != null) {
                                if (indexCount % 2 == 0) {
                                    if (userName.equals(line)) {
                                        accountNameMatched = true;
                                        passwordIndex = indexCount + 1;
                                    } else {
                                        editContent.add(line);
                                    }
                                } else {
                                    if (passwordIndex == indexCount) {
                                        if (userPassword.equals(line)) {
                                            accountPasswordMatched = true;
                                        } else {
                                            editContent.add(line);
                                        }
                                    } else {
                                        editContent.add(line);
                                    }
                                }
                                indexCount++;
                            }
                            if (accountNameMatched && accountPasswordMatched) {
                                FileOutputStream fos = new FileOutputStream(f, false);
                                PrintWriter pw = new PrintWriter(fos);
                                for (int i = 0; i < editContent.size(); i++) {
                                    pw.println(editContent.get(i));
                                }
                                pw.close();
                                writer.write("DeleteSuccess");
                                writer.println();
                                writer.flush();
                            } else if (!accountNameMatched) {
                                writer.write("AccountNotMatched");
                                writer.println();
                                writer.flush();
                            } else if (accountNameMatched && !accountPasswordMatched) {
                                writer.write("PasswordNotMatched");
                                writer.println();
                                writer.flush();
                            }
                        }
                    }
                }

            } while (!loginSuccess);
            do {
                keepQuizSystemOpen = true;
                String accountType = reader.readLine();
                if (accountType.equals("Teacher")) {
                    String teacherChoice = reader.readLine();
                    if (Integer.parseInt(teacherChoice) == 0) {
                        String newCourseName = reader.readLine();
                        File f = new File("Course.txt");
                        if (f.createNewFile()) {
                            FileOutputStream fos = new FileOutputStream(f, true);
                            PrintWriter pw = new PrintWriter(fos);
                            pw.println(newCourseName);
                            pw.close();
                            writer.write("CourseAddSuccess");
                            writer.println();
                            writer.flush();
                        } else {
                            FileOutputStream fos = new FileOutputStream(f, true);
                            PrintWriter pw = new PrintWriter(fos);
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            String line;
                            boolean courseExist = false;
                            while ((line = bfr.readLine()) != null) {
                                if (newCourseName.equals(line)) {
                                    courseExist = true;
                                }
                            }
                            if (courseExist) {
                                writer.write("CourseAlreadyExist");
                                writer.println();
                                writer.flush();
                            } else {
                                pw.println(newCourseName);
                                writer.write("CourseAddSuccess");
                                writer.println();
                                writer.flush();
                            }
                            pw.close();
                        }

                    }
                    if (Integer.parseInt(teacherChoice) == 1) {
                        File f = new File("Course.txt");
                        if (f.createNewFile()) {
                            writer.write("NoCourse");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            String line;
                            int count = 0;
                            while ((line = bfr.readLine()) != null) {
                                count++;
                            }
                            if (count == 0) {
                                writer.write("NoCourse");
                                writer.println();
                                writer.flush();
                            } else {
                                writer.write("HaveCourses");
                                writer.println();
                                writer.flush();
                                FileReader newfr = new FileReader(f);
                                BufferedReader newbfr = new BufferedReader(newfr);
                                String CourseName = reader.readLine();
                                boolean courseExist = false;
                                String newline;
                                while ((newline = newbfr.readLine()) != null) {
                                    if (CourseName.equals(newline)) {
                                        courseExist = true;
                                    }
                                }
                                if (courseExist) {
                                    writer.write("CourseAlreadyExist");
                                    writer.println();
                                    writer.flush();
                                    String QuizName = reader.readLine();
                                    File quizFile = new File(CourseName + "-" + QuizName);
                                    if (quizFile.createNewFile()) {
                                        writer.write("QuizAddSuccess");
                                        writer.println();
                                        writer.flush();
                                    } else {
                                        writer.write("QuizAlreadyExist");
                                        writer.println();
                                        writer.flush();
                                    }
                                } else {
                                    writer.write("CourseNotExist");
                                    writer.println();
                                    writer.flush();
                                }
                            }
                        }
                    }
                    if (Integer.parseInt(teacherChoice) == 2) {
                        File f = new File("Course.txt");
                        if (f.createNewFile()) {
                            writer.write("NoCourse");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            String line;
                            int count = 0;
                            while ((line = bfr.readLine()) != null) {
                                count++;
                            }
                            if (count == 0) {
                                writer.write("NoCourse");
                                writer.println();
                                writer.flush();
                            } else {
                                writer.write("HaveCourses");
                                writer.println();
                                writer.flush();
                                FileReader newfr = new FileReader(f);
                                BufferedReader newbfr = new BufferedReader(newfr);
                                String CourseName = reader.readLine();
                                boolean courseExist = false;
                                String newline;
                                while ((newline = newbfr.readLine()) != null) {
                                    if (CourseName.equals(newline)) {
                                        courseExist = true;
                                    }
                                }
                                if (courseExist) {
                                    writer.write("CourseMatched");
                                    writer.println();
                                    writer.flush();
                                    String QuizName = reader.readLine();
                                    File quizFile = new File(CourseName + "-" + QuizName);
                                    if (quizFile.exists()) {
                                        writer.write("QuizMatched");
                                        writer.println();
                                        writer.flush();
                                        String questionNumber = reader.readLine();
                                        FileOutputStream fos = new FileOutputStream(quizFile, false);
                                        PrintWriter pw = new PrintWriter(fos);
                                        for (int i = 0; i < Integer.parseInt(questionNumber); i++) {
                                            String question = reader.readLine();
                                            pw.println(question);
                                        }
                                        pw.close();
                                    } else {
                                        writer.write("QuizNotExist");
                                        writer.println();
                                        writer.flush();
                                    }
                                } else {
                                    writer.write("CourseNotExist");
                                    writer.println();
                                    writer.flush();
                                }
                            }
                        }
                    }
                    if (Integer.parseInt(teacherChoice) == 3) {
                        File f = new File("Course.txt");
                        if (f.createNewFile()) {
                            writer.write("NoCourse");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(f);
                            BufferedReader bfr = new BufferedReader(fr);
                            String line;
                            int count = 0;
                            while ((line = bfr.readLine()) != null) {
                                count++;
                            }
                            if (count == 0) {
                                writer.write("NoCourse");
                                writer.println();
                                writer.flush();
                            } else {
                                writer.write("HaveCourses");
                                writer.println();
                                writer.flush();
                                FileReader newfr = new FileReader(f);
                                BufferedReader newbfr = new BufferedReader(newfr);
                                String CourseName = reader.readLine();
                                boolean courseExist = false;
                                String newline;
                                while ((newline = newbfr.readLine()) != null) {
                                    if (CourseName.equals(newline)) {
                                        courseExist = true;
                                    }
                                }
                                if (courseExist) {
                                    writer.write("CourseAlreadyExist");
                                    writer.println();
                                    writer.flush();
                                    String QuizName = reader.readLine();
                                    File quizFile = new File(CourseName + "-" + QuizName);
                                    if (quizFile.exists()) {
                                        quizFile.delete();
                                        writer.write("QuizDeleted");
                                        writer.println();
                                        writer.flush();
                                    } else {
                                        writer.write("QuizNotExist");
                                        writer.println();
                                        writer.flush();
                                    }
                                } else {
                                    writer.write("CourseNotExist");
                                    writer.println();
                                    writer.flush();
                                }
                            }
                        }
                    }
                    if (Integer.parseInt(teacherChoice) == 4) {
                        String courseName = reader.readLine();
                        String quizName = reader.readLine();
                        File courseFile = new File("Course.txt");
                        if (!courseFile.exists()) {
                            writer.write("Error");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(courseFile);
                            BufferedReader bfr = new BufferedReader(fr);
                            String line;
                            boolean matchedCourse = false;
                            while((line = bfr.readLine()) != null) {
                                if (line.equals(courseName)) {
                                    matchedCourse = true;
                                }
                            }
                            if (!matchedCourse) {
                                writer.write("Error");
                                writer.println();
                                writer.flush();
                            } else {
                                File quizFile = new File(courseName + "-" + quizName);
                                FileReader Qfr = new FileReader(quizFile);
                                BufferedReader Qbfr = new BufferedReader(Qfr);
                                String QLine;
                                int count = 0;
                                while ((QLine = Qbfr.readLine()) != null) {
                                    count++;
                                }
                                File answerFile = new File(courseName + "-" + quizName + "-" + "answer");
                                if (quizFile.exists() && answerFile.exists()) {
                                    writer.write("Matched");
                                    writer.println();
                                    writer.flush();
                                    writer.write(String.valueOf(count));
                                    writer.println();
                                    writer.flush();
                                    for (int i = 0; i < count; i++) {
                                        FileReader Q2fr = new FileReader(quizFile);
                                        BufferedReader Q2bfr = new BufferedReader(Q2fr);
                                        FileReader Afr = new FileReader(answerFile);
                                        BufferedReader Abfr = new BufferedReader(Afr);
                                        String question = Q2bfr.readLine();
                                        String answer = Abfr.readLine();
                                        writer.write(question);
                                        writer.println();
                                        writer.flush();
                                        writer.write(answer);
                                        writer.println();
                                        writer.flush();
                                    }
                                } else {
                                    writer.write("Error");
                                    writer.println();
                                    writer.flush();
                                }
                            }
                        }
                    }
                    if (Integer.parseInt(teacherChoice) == 5) {
                        String userCourseName = reader.readLine();
                        File courseFile = new File("Course.txt");
                        if (!courseFile.exists()) {
                            writer.write("NoCourse");
                            writer.println();
                            writer.flush();
                        } else {
                            FileReader fr = new FileReader(courseFile);
                            BufferedReader bfr = new BufferedReader(fr);
                            String line;
                            boolean matchedCourse = false;
                            while((line = bfr.readLine()) != null) {
                                if (line.equals(userCourseName)) {
                                    matchedCourse = true;
                                }
                            }
                            if (!matchedCourse) {
                                writer.write("CourseNotExist");
                                writer.println();
                                writer.flush();
                            } else {
                                writer.write("CourseExist");
                                writer.println();
                                writer.flush();
                                String userFileName = reader.readLine();
                                File userFile = new File(userFileName);
                                if (!userFile.exists()) {
                                    writer.write("FileNotExist");
                                    writer.println();
                                    writer.flush();
                                } else {
                                    writer.write("FileExist");
                                    writer.println();
                                    writer.flush();
                                    File quizFile = new File(userCourseName + "-" + userFileName);
                                    userFile.renameTo(quizFile);
                                }
                            }
                        }
                    }
                    if (Integer.parseInt(teacherChoice) == 6) {
                        keepQuizSystemOpen = false;
                    }
                }
                if (accountType.equals("Student")) {
                    keepQuizSystemOpen = true;
                    String studentChoice = reader.readLine();
                    if (Integer.parseInt(studentChoice) == 0) {
                        String course = reader.readLine();
                        String quiz = reader.readLine();
                        File quizFile = new File(course + "-" + quiz);
                        if (quizFile.exists()) {
                            writer.write("Matched");
                            writer.println();
                            writer.flush();
                            FileReader oldfr = new FileReader(quizFile);
                            BufferedReader oldbfr = new BufferedReader(oldfr);
                            int count = 0;
                            String oldline;
                            while((oldline = oldbfr.readLine()) != null) {
                                count++;
                            }
                            writer.write(String.valueOf(count));
                            writer.println();
                            writer.flush();
                            FileReader fr = new FileReader(quizFile);
                            BufferedReader bfr = new BufferedReader(fr);
                            File answerFile = new File(course + "-" + quiz + "-" + "answer");
                            if (!answerFile.exists()) {
                                answerFile.createNewFile();
                            }
                            FileOutputStream fos = new FileOutputStream(answerFile, false);
                            PrintWriter pw = new PrintWriter(fos);
                            for (int i = 0; i < count; i++) {
                                String line = bfr.readLine();
                                writer.write(line);
                                writer.println();
                                writer.flush();
                                String userAnswer = reader.readLine();
                                pw.println(userAnswer);
                            }
                            pw.close();

                            Timestamp newTime = new Timestamp(System.currentTimeMillis());
                            File timeFile = new File(course + "-" + quiz
                                    + "studentSubmissionTime");
                            FileOutputStream fosT = new FileOutputStream(timeFile, false);
                            PrintWriter pwT = new PrintWriter(fosT);
                            pwT.println(newTime);
                            pwT.close();
                        } else {
                            writer.write("Unmatched");
                            writer.println();
                            writer.flush();
                        }
                    }
                    if (Integer.parseInt(studentChoice) == 1) {
                        keepQuizSystemOpen = false;
                    }
                }
            } while (keepQuizSystemOpen);
        } while (keepServerOpen);

        writer.close();
        reader.close();
    }
}
