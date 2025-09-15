# oranettest
Simple java program for testing of Oracle Net round trip time

How to Compile and Run

    Download the JDBC Driver: You need the Oracle JDBC driver (e.g., ojdbc8.jar). You can download it from the Oracle website.

    Save the Code: Save the code above as OraclePerformanceTester.java.

    Compile: Open a terminal or command prompt and compile the program, including the JDBC driver in the classpath.
    Bash

javac -cp .:ojdbc8.jar OraclePerformanceTester.java

(Note: On Windows, use a semicolon ; instead of a colon :)
Bash

javac -cp .;ojdbc8.jar OraclePerformanceTester.java

Run: Execute the compiled program, again including the driver in the classpath.
