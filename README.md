This repository contains a Selenium-based automation framework that uses Cucumber for BDD (Behavior-Driven Development), Page Object Model (POM) design pattern, and Maven as the build tool. 
The framework is designed for automating web application tests and generating detailed reports with TestNG.


**Project Structure:**


Feature File: Contains Gherkin syntax for defining the BDD scenarios (located in src/test/resources/features).

Step Definitions: Implements the steps defined in the feature file (located in src/test/java/stepDefinitions).

Page Objects: Contains the page object classes, implementing the Page Object Model (POM) for elements and actions on the web pages (located in src/test/java/pages).

Test Runner: The TestNG runner class to execute the tests (located in src/test/java/testRunner).


**How to Run the Tests**
1. Run Tests Using Maven
You can run the tests using Maven from the command line. Navigate to the project directory and execute:mvn clean test


**Dependencies**
This project uses the following dependencies:

Selenium WebDriver: For automating browser interactions.

Cucumber: For Behavior-Driven Development (BDD).

Maven: For project build and dependency management.

TestNG: For running tests and generating reports.

Page Object Model: To maintain a clear structure for test automation.


