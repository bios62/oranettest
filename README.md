# oranettest
Simple java program for testing of Oracle Net round trip time
How to Compile and Run

    Download the JDBC Driver: You need the Oracle JDBC driver (e.g., ojdbc8.jar). You can download it from the Oracle website.

    Save the Code: Save the code above as OraclePerformanceTester.java.

    Compile: Open a terminal or command prompt and compile the program, including the JDBC driver in the classpath.

    javac -cp .:ojdbc8.jar OraclePerformanceTester.java

    (Note: On Windows, use a semicolon ; instead of a colon :)
    javac -cp .;ojdbc8.jar OraclePerformanceTester.java
    Run: Execute the compiled program, again including the driver in the classpath.

    java -cp .:ojdbc8.jar OraclePerformanceTester <username> <password> <tnsname> <delay> <tests>

    (Windows)

    java -cp .;ojdbc8.jar OraclePerformanceTester <username> <password> <tnsname> <delay> <tests>

Example Command:
java -cp .:ojdbc8.jar OraclePerformanceTester "scott" "tiger" "localhost:1521/orcl" 5 10

Program Parameters Help

The program requires five command-line parameters to run. You must provide them in the following order:

    <username>: Your Oracle database username.

    <password>: The password for the specified username.

    <tnsname>: The Oracle TNS (Transparent Network Substrate) name or connection string. This is typically in the format hostname:port/service_name.

    <delay>: The number of seconds the program should wait between each test query.

    <tests>: The total number of loops or queries to execute.
