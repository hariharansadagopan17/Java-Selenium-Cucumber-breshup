# Java Selenium Cucumber Framework

[![Java CI with Maven](https://github.com/$GITHUB_USERNAME/Java-Selenium-Cucumber-breshup/actions/workflows/maven.yml/badge.svg)](https://github.com/$GITHUB_USERNAME/Java-Selenium-Cucumber-breshup/actions/workflows/maven.yml)

This is a test automation framework built with Selenium WebDriver, Cucumber, and Java.

## Technologies Used

- Java 17
- Selenium WebDriver 4.21.0
- Cucumber 7.18.0
- JUnit 4.13.2
- TestNG 7.10.2
- Maven

## Project Structure

```
├── src
│   ├── main/java
│   │   └── org/example
│   └── test
│       ├── java
│       │   ├── Runner
│       │   │   └── TestRunner.java
│       │   └── StepDefinition
│       │       └── ContactUsSteps.java
│       └── resources
│           └── Feature
│               └── contact_us.feature
```

## Getting Started

1. Clone the repository
2. Install dependencies:
   ```bash
   mvn clean install
   ```
3. Run tests:
   ```bash
   mvn test
   ```

## CI/CD Pipeline

This project uses GitHub Actions for continuous integration and delivery. The pipeline:

1. Builds the project
2. Runs all tests
3. Generates test reports
4. Caches Maven dependencies

Test reports are available as artifacts in the GitHub Actions workflow runs.

## Test Reports

After running tests, reports can be found in:
- Cucumber Reports: `target/cucumber-reports`
- Surefire Reports: `target/surefire-reports` 