# Mobile Automation Testing with Appium

This repository contains automation scripts for testing mobile applications using Appium.

## Prerequisites

Before running the automation scripts, ensure you have the following installed:

1. Java Development Kit (JDK) - version 8 or higher
2. Maven - for managing project dependencies
3. Appium Server - for mobile automation
4. Android SDK or Xcode - depending on the mobile platform (Android/iOS) you are testing
5. IDE (Integrated Development Environment) - such as IntelliJ IDEA or Eclipse

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/mobile-automation.git
   ```

2. **Import Project**:
   - Open your preferred IDE (IntelliJ IDEA, Eclipse, etc.).
   - Import the cloned project as a Maven project.

3. **Install Dependencies**:
   - Open the project in your IDE.
   - Let Maven download and install the required dependencies specified in the `pom.xml` file.

4. **Configure Appium**:
   - Start the Appium server on your local machine or specify the server address in your test scripts.
   - Connect your mobile device or start an emulator/simulator.

5. **Run Tests**:
   - Navigate to the `src/test/java` .
   - Open the test class (`tests.java`).
   - Right-click on the test class or individual test methods and select "Run" to execute the tests.

## TestNG XML Configuration

You can also run tests using the testng_runner XML file to execute the tests according to the specified configuration.

## Generating Allure Reports

To generate Allure reports for detailed test results:

1. Install Allure command-line tool:
   ```bash
   brew install allure (for macOS)
   ```
   or download from [Allure website](https://docs.qameta.io/allure/).

2. Run tests and generate Allure report:
   ```bash
   mvn clean test
   allure serve
   ```

3. Open the generated Allure report in your browser to view test execution details.
