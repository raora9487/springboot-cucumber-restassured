# Spring Boot + Cucumber + Rest Assured

## Overview
This project is a Cucumber-based API automation framework integrated with Spring Boot and Rest Assured.

## Running Tests with Different Environments

Spring profiles (`dev`, `pre`, `prod`) are used to switch environments.  
By default, if no profile is provided, the framework falls back to **dev**.

### 1. Run from IntelliJ IDEA
1. Go to **Run → Edit Configurations**.
2. Select your `JUnit` or `Cucumber Test Runner` configuration (`runner.TestRunner`).
3. In **VM Options**, add one of the following:
   - `-Dspring.profiles.active=dev`
   - `-Dspring.profiles.active=pre`
   - `-Dspring.profiles.active=prod`
4. Apply and run.

You can create multiple run configs for convenience:
- **Cucumber - Dev** → `-Dspring.profiles.active=dev`
- **Cucumber - Pre** → `-Dspring.profiles.active=pre`
- **Cucumber - Prod** → `-Dspring.profiles.active=prod`

### 2. Run from Maven CLI
```bash
mvn clean test -Dspring.profiles.active=dev
mvn clean test -Dspring.profiles.active=pre
mvn clean test -Dspring.profiles.active=prod
```

### 3. Default Behavior
If no profile is set, the framework defaults to **dev** profile via `CucumberSpringConfiguration` fallback logic.

---

## Folder Structure
- `src/test/java/steps` → Step Definitions
- `src/test/java/config` → Test configuration (Spring + Cucumber integration)
- `src/test/resources/features` → Feature files
- `src/test/resources/application-*.properties` → Environment configs

src
└── test
└── java
└── automation         <-- ✅ ROOT package
├── TestApplication.java
│
├── config
│     ├── CucumberSpringConfiguration.java
│     └── ApiConfig.java
│
├── services
│     ├── PostService.java
│     ├── UserService.java
│     └── AuthService.java
│
├── steps
│     └── CrudStepDefinitions.java
│
└── runner
└── TestRunner.java


How each part works
1. Root package → automation

Contains TestApplication.java

Acts as the base for Spring Boot scanning

Everything inside (config, services, steps) will be scanned automatically

