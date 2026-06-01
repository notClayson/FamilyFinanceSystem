# Family Finance System

Family Finance System is a Java desktop application built for my Object-Oriented Programming module. The project simulates a family expense tracker where a family head can manage expense categories and allowances, while family members can record and review their spending.

The goal of this project was to practise object-oriented design, GUI development, user flows, and basic data management in Java.

## Features

- Register and log in as a family member or family head
- Add, edit, and view member expenses
- Create and manage spending categories
- Allocate and edit allowance records
- View family expense summaries
- Track user-specific spending data
- Navigate through multiple GUI screens using Java Swing

## Tech Stack

- Java
- Java Swing
- Object-Oriented Programming
- Eclipse project structure
- Local file/data handling

## Project Structure

```text
src/
  controller/
    Controller.java        # Connects GUI actions to data operations
    MainFrame.java         # Main application window and screen navigation

  data/
    User.java              # User model and user expense data
    DetailedExpense.java   # Expense model
    Allowance.java         # Allowance model
    Category.java          # Expense category model
    DataStorage.java       # In-memory storage for users, expenses, categories, and allowances

  gui/
    LoginHead.java
    LoginMember.java
    RegUserScreen.java
    Head_*.java            # Family head screens
    Mem_*.java             # Family member screens
```

## How To Run

### Option 1: Run the JAR

If Java is installed, run:

```bash
java -jar FamilyExpenseTracker.jar
```

### Option 2: Run from source

1. Open the project in Eclipse or another Java IDE.
2. Make sure `KControls-2.0.jar` is included in the build path.
3. Run `src/controller/MainFrame.java`.

## Main User Roles

### Family Head

The family head can manage categories, allocate allowances, and view family-level summaries.

### Family Member

Family members can log in, add expenses, edit expenses, and view their own spending records.

## What I Learned

- Designing a multi-screen Java Swing application
- Applying OOP concepts such as classes, encapsulation, and controller/data separation
- Managing application state across GUI screens
- Building role-based user flows
- Handling simple local data storage and retrieval
- Structuring a larger Java module project

## Future Improvements

- Replace in-memory storage with a database or persistent file format
- Add stronger input validation and error handling
- Improve password handling and user authentication
- Add charts for monthly spending trends
- Export expenses to CSV
- Improve the UI layout and responsiveness

## Status

This project was completed as part of an Object-Oriented Programming module and is kept as a record of my early Java and GUI development experience.
