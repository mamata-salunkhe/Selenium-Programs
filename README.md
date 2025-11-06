# SELENIUM-Programs

A small Selenium + Java automation project (Eclipse workspace) that demonstrates launching browsers, navigating to Amazon, scrolling, taking screenshots, interacting with dropdowns, and basic test examples.

---

## Table of Contents

- About
- Features
- Prerequisites
- Installation & Setup
- Run from Eclipse
- Run from Command Line (Maven)
- Project Structure
- Important Notes & Troubleshooting
- Suggested Next Steps
- License

---

## About

This repository contains simple Selenium automation examples written in Java. It uses WebDriverManager to handle browser driver binaries and demonstrates core WebDriver actions such as navigating to a website, scrolling, taking screenshots, refreshing, and selecting items from a dropdown.

The example shown in the project opens `https://www.amazon.in/`, scrolls the page using JavaScript, takes a screenshot, refreshes the page, and selects a dropdown value (e.g., "Baby").

---

## Features

- Launch Chrome using WebDriverManager
- Navigate to Amazon
- Scroll page using JavaScriptExecutor
- Capture screenshots with `TakesScreenshot`
- Interact with dropdowns using `Select`
- Example test/main classes for launching and basic interaction

---

## Prerequisites

- Java JDK 8 or later (project shows JavaSE-1.8 but newer JDKs should work)
- Maven (if running from command line)
- Internet connection (for WebDriverManager to download driver, and to load test site)
- Chrome browser installed (ensure Chrome version is supported by the driver)

Dependencies used (examples; see `pom.xml`):
- Selenium Java
- WebDriverManager
- Apache Commons IO (for file copy utilities)

---

## Installation & Setup

1. Clone this repository:
   - git clone <your-repo-url>

2. Open the project in Eclipse:
   - File → Import → Existing Maven Projects (or Import → General → Existing Projects into Workspace if not using Maven).

3. Ensure Maven dependencies are downloaded:
   - Right-click the project → Maven → Update Project (or run `mvn clean install`).

4. If you prefer not to use WebDriverManager, download the correct chromedriver executable for your Chrome version and add it to your PATH (or set `webdriver.chrome.driver` system property).

---

## Running the code

### Run from Eclipse
- Locate the Java class (for example `seleniumJAVA.AmazonLaunch`) in `src/test/java` or `src`.
- Right click → Run As → Java Application (or JUnit test, if converted into tests).
- Console output will show the progress (page scroll, screenshot saved, dropdown actions, etc.).

### Run from Command Line (Maven)
If you have tests configured as JUnit/TestNG, run:
- mvn test

If the classes are plain Java mains, you can run via `mvn exec:java` with proper configuration in `pom.xml` or package and run the jar:
- mvn package
- java -cp target/<artifact>.jar <main-class>

---

## Project Structure (example)

- src/test/java/seleniumJAVA/
  - AmazonLaunch.java        // Main example - opens Amazon, scrolls, screenshot, dropdown
  - eZTestTestMamata.java    // Another example/test
  - FlipkartLaunch.java      // Example for Flipkart (if present)
  - Practice.java            // Practice scripts
- pom.xml                    // Maven dependencies and build settings
- target/                    // Maven build output

---

## Important Notes & Troubleshooting

- WebDriverManager is used (WebDriverManager.chromedriver().setup()) so you generally don't need to manually download chromedriver. It will attempt to download a driver matching your browser.
- If you see SLF4J warnings like "No SLF4J providers were found" — that is a logging provider warning. Add an SLF4J binding (e.g., slf4j-simple or logback) if you want to remove the warning.
- If you see warnings about CDP (Chrome DevTools Protocol) version or "Unable to find version of CDP to use", make sure your Chrome is up to date or use a chromedriver version compatible with your Chrome browser. Updating WebDriverManager or your local Chrome may resolve the mismatch.
- Screenshot path: the code saves screenshots to a local path (example: `C:\Users\...`). Make sure the folder exists or update the path to a project-relative folder (e.g., `./screenshots/`) and ensure write permission.
- Use of Thread.sleep() is shown in examples; prefer explicit waits (WebDriverWait) for reliable tests.
- When running in CI, ensure a display or use headless mode for Chrome (add ChromeOptions with `--headless`).

---

## Suggested Next Steps

- Refactor into a proper test framework (JUnit or TestNG) with setup/teardown methods.
- Move repeated logic to a base class or use Page Object Model (POM) for maintainability.
- Add configuration support (externalize base URL, browser type, timeouts).
- Add assertions / validations to convert examples into verifiable tests.
- Add CI (GitHub Actions) to run tests automatically.
- Store screenshots in a dedicated folder and attach them to test reports.

---

## License

This project does not include a license file. Add a LICENSE file if you plan to make this repository public and reusable.
