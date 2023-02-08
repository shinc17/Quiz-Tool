Project 05 - Final Quiz Tool README

Submitted Report on Brightspace - Will Clippard
Submitted Vocareum workspace - Yuchen Gu
Submitted Presentation - David Shin

Description

For this Project, we implemented several classes: Server, Client, and ClientHandler to implement Concurrency, Network IO, and GUI to an initial  program which can do general quiz systems. There are two types of accounts that users can sign in: Teacher and Student. Teachers can manage courses and the same for quizzes in courses. They also can view student’s submissions. Students can join any courses they want and can take a quiz in it. 

Instruction on how to compile and run project

Run the Server.java
Run the Client.java
Sign up for both teacher and student in Client.java
Sign in as teacher using the existing teacher account, create a course, add a quiz to the existing course, modify the quiz to add questions with different formats, and quit
Return to sign in menu, sign in as student using the existing student account, do the existing quiz, submitted it, and quit
Return to sign in menu and sign in as teacher using existing teacher account, view the quiz submission of student and quit

Server.java

Functionality: 
Main server is implemented, Saving and managing data from clients. Server is a place where data will be stored for data persistence. 
It ise ServerSocket for network IO and BufferedReader and PrintWriter for data persistence. BufferedReader will read data from separate file and PrintWriter write data and flush it to client.

Relationship to other classes: 
Server should be run first to use programs. Opening clients without a server will make errors.

Client.java

Functionality: 
With a full GUI, get data from users and send those to the server. Every interface such as Login, Teacher menu, and Student menu will appear here and users only can control the client, not server. It ise ServerSocket for network IO and BufferedReader and PrintWriter for data persistence.
BufferedReader will read data from separate file and PrintWriter write data and flush it to server.

Relationship to other classes: 
Client should be run after the server starts to run. ClientHandler.java implements concurrency in Client.java

ClientHandler.java

Functionality:
ClientHandler implements Runnable and overrides run() for using concurrency.

Relationship to other classes: 
ClientHandler is directly related to Client.java to make users’ multiple simultaneous running programs. 
