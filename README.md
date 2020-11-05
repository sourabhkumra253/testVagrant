# testVagrant

## Project Structure:
 *Test Cases are divided into API & WEB tests. Api tests cover normal & exceptional cases independently.
 *WebTests cover the webApp normal & executional cases independently. 
 *There is E2E package which cover end to end scenario of fetching & comparing weather from both the sources.
 *Threshold is currently stored in properties file
 *TestNg xml has been created for all the cases (with parallel execution support)
 *PageObjects,Services, packages containing corresponding classes.
 *Pom.xml contains all the required dependencies and Maven Sure fire plugin to run Jobs from jenkins


## How to run the project:
 
 * Unzip the project folder
 * Run mvn clean compile test from command line
 * Check results on terminal
 
 --------------------
 
 * Open project in eclipse
 * Right click on testng.xml
 * Run as testNg suite
	
