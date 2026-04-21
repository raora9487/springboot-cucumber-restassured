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

## 🌐 Environment Configuration (DEV / PRE / PROD)

This framework supports multiple environments using Spring profiles:

- application-dev.properties
- application-pre.properties
- application-prod.properties

---

## 🔧 How Environment Selection Works

The active environment is controlled using JVM (VM) options.

Example:

-Dspring.profiles.active=dev

or

-Dspring.profiles.active=pre

Based on this, Spring Boot automatically loads:

application-{profile}.properties

---

## 🌍 Base URL Configuration

The base URL for APIs is configured in properties file:

api.base.url=...

Example:

# application-dev.properties
api.base.url=https://jsonplaceholder.typicode.com

---

## ⚠️ Note on jsonplaceholder API

This project uses:

https://jsonplaceholder.typicode.com

This is a **public mock API**, not a real production system.

### Important points:

- No separate environments (DEV / PRE / PROD)
- Same URL is used everywhere
- Data is fake and used only for testing/demo purposes

---

## 🤔 Why Still Use Environment Profiles?

Even though the URL is same for this demo API, the framework is designed for real-world usage.

In real projects, environments typically look like:

DEV  → https://dev.api.com  
PRE  → https://pre.api.com  
PROD → https://api.com

---

## ✅ Current Approach

Since jsonplaceholder has only one URL, we use the same value across profiles:

# application-dev.properties
api.base.url=https://jsonplaceholder.typicode.com

# application-pre.properties
api.base.url=https://jsonplaceholder.typicode.com

---

## 🚀 Why This Design is Useful

Even though the URL is same now, this setup allows:

- Easy switch to real environments later
- No code changes required
- Only property update needed

---

## 👍 Best Practices

- Avoid hardcoding base URLs in code
- Always use environment-based configuration
- Keep framework flexible and scalable

---

## 🔥 Example Run Commands

### Run DEV

-ea -Dspring.profiles.active=dev -Dcucumber.filter.tags="@demoApiTests"

### Run PRE

-ea -Dspring.profiles.active=pre -Dcucumber.filter.tags="@crud"

---

## 🎯 Summary

- Profiles control environment
- Properties control configuration
- Same URL used only because this is a mock API
- Framework is ready for real-world scaling