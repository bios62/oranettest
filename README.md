# oranettest
Simple java program for testing of Oracle Net round trip time

# Simple Java Program for Testing Oracle Net Round Trip Time

---
## How to Compile and Run
1.  **Prereq**:
  
    - JDK 17 or newer
    - Oracle Instant client 23
      
2.  **Download the JDBC Driver**:
  
    You'll need the Oracle JDBC driver (e.g., `ojdbc8.jar`). You can download it directly from the Oracle website.
    If the instant client is installed, JDBC will be available from here.

3.  **Save the Code**:
  
    Save the provided Java code as `OraclePerformanceTester.java`.
    
4.  **Compile**:
  
    Open your terminal or command prompt and compile the program. Make sure to include the JDBC driver in the classpath.

    ```bash
    javac -cp .:ojdbc8.jar OraclePerformanceTester.java
    ```

    (On Windows, use a semicolon `;` instead of a colon `:`)

    ```bash
    javac -cp .;ojdbc8.jar OraclePerformanceTester.java
    ```

5.  **Run**:
  
    Execute the compiled program, including the driver in the classpath once more.

    ```bash
    java -cp .:ojdbc8.jar OraclePerformanceTester <username> <password> <tnsname> <delay> <tests>
    ```

---
### Program Parameters Help

The program requires five command-line parameters to run. You must provide them in the following order:

* **`<username>`**: Your Oracle database username.
* **`<password>`**: The password for the specified username.
* **`<tnsname>`**: The Oracle TNS (Transparent Network Substrate) name or connection string, typically in the format `hostname:port/service_name`.
* **`<delay>`**: The number of seconds the program should wait between each test query.
* **`<tests>`**: The total number of loops or queries to execute.

---
**Example Command:**

```bash
java -cp .:ojdbc8.jar OraclePerformanceTester "scott" "tiger" "localhost:1521/orcl" 5 10
