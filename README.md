command to run tests:
mvn clean test -DsuiteName=smoke.xml


Information about test framework:
UI Framework 

Structure of test framework:
1. Use *.xml files to organize tests (test/resources/suites)
2. Use pom.xml file to configure maven plugins
3. Screenshots, logs and report are saved in target folder and corresponding sub-folders
(results/, logs/, extent-reports/) 
Notes: logs are overridden each time after mvn clean 
4. common utils should be in main/java/com.bookstore.framework/utils folder
5. data files, drivers, properties files should be in main/resources/
6. default variables and settings should be in main/resources/common.properties file

7. Tests should be in TEST/java/com.bookstore.framework/ folder
8. Implementation of pages should be in main/java/com.bookstore.framework/pages folder
9. Common methods for pages should be in main/java/com.bookstore.framework/base/BasePage class
10. Common methods for tests should be in main/java/com.bookstore.framework/base/BaseTest class
11. Initiation of page objects should be in main/java/com.bookstore.framework/BookStore class





