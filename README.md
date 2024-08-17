Notepad Clone

This is a simple Notepad clone application implemented in Java using Swing. It demonstrates basic functionalities like creating a new file, opening an existing file, and saving the current file. The application uses inheritance to separate concerns and maintain clean code.

Features

- Create a new file
- Open an existing file
- Save the current file
- Basic text editing with line wrapping and word wrapping

Project Structure

- NotepadClone.java: The main entry point of the application. It initializes and shows the main frame.
- BaseFrame.java: A base class that sets up the common UI components like the text area and scroll pane.
- NotepadFrame.java: Extends `BaseFrame` to add menu functionalities specific to the Notepad application, including New, Open, and Save operations.

Prerequisites

- Java Development Kit (JDK) 8 or later
- Any Java Integrated Development Environment (IDE) or a text editor with command-line tools

How to Build and Run

javac NotepadClone.java BaseFrame.java NotepadFrame.java
java NotepadClone
