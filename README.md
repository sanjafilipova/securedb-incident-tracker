# SecureDB Incident Tracker

**Java | Object-Oriented Programming | Cybersecurity | File Handling**

## Project Overview

SecureDB Incident Tracker is a Java console application I developed as part of my **Introduction to Java Programming coursework through Sophia Learning**.

The program is designed to help organize and track database security incidents. It allows users to record incidents, search for specific incidents, update their status, and identify incidents with higher severity levels.

I chose this project because I am interested in pursuing a career in cybersecurity, and I wanted to create something that connects programming with real-world security incident management.

## Features

- **Add Security Incidents:** Record the incident type, affected database or system, severity level, and status.
- **Automatic Incident IDs:** Assign unique incident IDs starting at 1001.
- **View All Incidents:** Display all recorded security incidents.
- **Search by ID:** Find specific incidents using their assigned IDs.
- **Update Incident Status:** Change the status of an existing incident.
- **Severity Filtering:** Display incidents classified as High or Critical.
- **File Persistence:** Save incident information to `incidents.txt` and load it when the program starts.
- **Input Validation:** Handle invalid menu selections and incident ID inputs.

## Technologies and Concepts

| Category | Skills Demonstrated |
|---|---|
| Programming Language | Java |
| Object-Oriented Programming | Classes, objects, constructors, encapsulation |
| Data Structures | ArrayList |
| Control Flow | Loops and conditional statements |
| User Input | Scanner and input validation |
| Error Handling | Exception handling |
| File Operations | Reading and writing text files |
| Cybersecurity Concepts | Incident tracking, severity classification, status management |

## Project Files

- `Main.java` — Contains the main menu, incident management functions, input validation, and file operations.
- `Incident.java` — Defines the Incident class and stores information about each security incident.
- `incidents.txt` — Stores incident records between program sessions.

## How to Run the Program

1. Install a Java Development Kit (JDK).
2. Download or clone this repository.
3. Open a terminal in the project directory.
4. Compile both Java files:

   ```bash
   javac Main.java Incident.java
   ```

5. Run the application:

   ```bash
   java Main
   ```

6. Follow the menu prompts to manage security incidents.

The application reads and writes `incidents.txt` in the current working directory.

## Application Menu

```text
==================================
 SecureDB Incident Tracker
==================================
1. Add New Incident
2. View All Incidents
3. Search Incident by ID
4. Update Incident Status
5. View High/Critical Incidents
6. Exit
```

## Testing and Debugging

During development, I tested each menu option, including adding incidents, searching for existing and nonexistent IDs, updating statuses, and checking the High/Critical severity filter.

I also tested whether incidents were saved correctly and loaded after restarting the program.

One issue I encountered was using `=` instead of `==` when comparing incident IDs. Another was an `InputMismatchException` caused by entering text instead of a number. I corrected these issues and tested the program again to confirm that the affected features worked.

## What I Learned

This project helped me become more comfortable working with Java and understanding how different parts of a program work together.

I gained experience creating classes, using ArrayLists, handling user input, reading and writing files, and debugging errors.

It also helped me understand how programming can be applied to cybersecurity tasks, especially when organizing information and tracking security incidents.

## About This Project

This application was created for educational purposes as part of my Sophia Learning Java coursework.

It is a basic incident tracking application intended to demonstrate programming concepts, not a production-ready security incident management system. Any incident records included in this repository are for demonstration purposes.
