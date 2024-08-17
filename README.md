<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Notepad Clone</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            color: #333;
        }
        header {
            background: #333;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }
        header img {
            height: 50px;
            vertical-align: middle;
        }
        main {
            padding: 20px;
            max-width: 800px;
            margin: auto;
        }
        h1 {
            color: #333;
        }
        a {
            color: #0066cc;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        code {
            background: #f4f4f4;
            padding: 2px 4px;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<header>
    <img src="java-logo.png" alt="Java Logo">
    <h1>Notepad Clone</h1>
</header>

<main>
    <h2>Overview</h2>
    <p>This is a simple Notepad clone application implemented in Java using Swing. It demonstrates basic functionalities like creating a new file, opening an existing file, and saving the current file. The application uses inheritance to separate concerns and maintain clean code.</p>
    
    <h2>Features</h2>
    <ul>
        <li>Create a new file</li>
        <li>Open an existing file</li>
        <li>Save the current file</li>
        <li>Basic text editing with line wrapping and word wrapping</li>
    </ul>
    
    <h2>Project Structure</h2>
    <ul>
        <li><code>NotepadClone.java</code>: The main entry point of the application. It initializes and shows the main frame.</li>
        <li><code>BaseFrame.java</code>: A base class that sets up the common UI components like the text area and scroll pane.</li>
        <li><code>NotepadFrame.java</code>: Extends <code>BaseFrame</code> to add menu functionalities specific to the Notepad application, including New, Open, and Save operations.</li>
    </ul>
    
    <h2>Prerequisites</h2>
    <ul>
        <li>Java Development Kit (JDK) 8 or later</li>
        <li>Any Java Integrated Development Environment (IDE) or a text editor with command-line tools</li>
    </ul>
    
    <h2>How to Build and Run</h2>
    <h3>Using Command Line</h3>
    <pre><code>
javac NotepadClone.java BaseFrame.java NotepadFrame.java
java NotepadClone
    </code></pre>

    <h3>Using an IDE</h3>
    <ul>
        <li>Create a new Java project.</li>
        <li>Add the above Java files (<code>NotepadClone.java</code>, <code>BaseFrame.java</code>, <code>NotepadFrame.java</code>) to the <code>src</code> directory of the project.</li>
        <li>Build and run the project using your IDE's build and run commands.</li>
    </ul>

    <h2>Usage</h2>
    <ul>
        <li><strong>Create a New File:</strong> Click on <code>File</code> > <code>New</code> to clear the text area and start a new file.</li>
        <li><strong>Open an Existing File:</strong> Click on <code>File</code> > <code>Open</code> to open a file chooser dialog. Select a file to open and its contents will appear in the text area.</li>
        <li><strong>Save the Current File:</strong> Click on <code>File</code> > <code>Save</code> to open a file chooser dialog. Choose the location and filename to save the current contents of the text area.</li>
    </ul>

    <h2>License</h2>
    <p>This project is licensed under the MIT License. See the <a href="LICENSE">LICENSE</a> file for details.</p>

    <h2>Acknowledgments</h2>
    <p>Java Swing for the graphical user interface</p>
    <p>Open source libraries and resources used in the project</p>

    <h2>Contact</h2>
    <p>For any questions or feedback, please contact <a href="mailto:your-email@example.com">your-email@example.com</a>.</p>
</main>

</body>
</html>
