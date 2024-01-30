To run this project, you need to follow the steps outlined below:
Step 1: Install Java
Make sure that you have Java installed on your computer. You can check this by running the command:
java -version
If Java is not installed, download and install it from the official Oracle website. (https://www.java.com/en/download/)

Step 2: Install Maven
Make sure that Maven is installed on your computer. You can check this by running the command:
mvn -version
If Maven is not installed, download and install it from the official Apache Maven website. (https://maven.apache.org/download.cgi)

Step 3: Build the project
Open a command prompt (terminal).
Navigate to the root directory of the project using the cd command, for example:
cd path/to/edlusLMT
Execute the following command to build the project:
mvn clean install
This will create a JAR file in the target directory.

Step 4: Run the project
After successful build, run the command to run the JAR file:
java -jar target/edlusLMT-1.0-SNAPSHOT.jar
The project should run successfully and you should see the result of the run.
