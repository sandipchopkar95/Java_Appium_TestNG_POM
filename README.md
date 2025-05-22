# 📱 Java Appium Test Automation Framework

This is a robust and scalable mobile automation testing framework built using **Java**, **Appium**, **TestNG**, and the **Page Object Model (POM)** design pattern. It supports modular test writing, parallel execution, and easy integration with CI/CD tools.

---

## 📂 Project Structure

```
project-root/
│
├── appfiles/                   # APKs or apps under test
├── reports/                    # HTML reports after test execution
├── screenshots/                # Screenshots captured on test failure
│
├── src/
│   ├── main/
│   │   ├── java/com/app/
│   │   │   ├── base/           # BasePage class
│   │   │   ├── config/         # Configuration setup
│   │   │   ├── constants/      # Element identifiers or test constants
│   │   │   ├── drivers/        # Appium driver setup and capability reader
│   │   │   ├── pages/          # Page Object Model (POM) classes
│   │   │   └── utils/          # Logger and other utilities
│   │   └── resources/
│   │       ├── config/         # Device and logging config
│   │       ├── logs/           # Generated log files
│   │       └── testdata/       # External test data (JSON, CSV, etc.)
│
│   └── test/
│       ├── java/com/app/
│       │   ├── base/           # BaseTest setup class
│       │   └── tests/          # Test classes
│       └── resources/
│           └── testng.xml      # TestNG suite file
│
├── target/                     # Maven-generated output files
├── .gitignore                  # Git ignored files
```

---

## 🔧 Installation & Setup

### ✅ Prerequisites

- Java 11 or later
- Maven
- Android SDK + emulator or real device
- Appium installed and running
- Node.js and npm (for Appium installation)
- IDE: IntelliJ IDEA / Eclipse

---

### 💻 Installing Dependencies

```bash
# 1. Clone the repository
git clone <your-repo-url>
cd <your-project-folder>

# 2. Install Maven dependencies
mvn clean install
```

---

### 📲 Appium & Android Setup

1. **Install Appium globally:**

```bash
npm install -g appium
```

2. **Start Appium server:**

```bash
appium
```

3. **Verify connected devices:**

```bash
adb devices
```

Make sure at least one emulator or real device is connected.

---

## 🚀 How to Run the Tests

### 🧪 Using TestNG from IDE

- Open `src/test/resources/testng.xml` in your IDE.
- Right-click and select **Run**.

### 🧪 Using Maven from Command Line

```bash
mvn clean test
```

This will:
- Read from `testng.xml`
- Start Appium driver
- Launch the app on the connected device/emulator
- Run the tests and generate reports

---

## 📝 Configuration

### `DeviceConfig.json`

Located in `src/main/resources/config/`, this file contains:
```json
{
  "platformName": "Android",
  "deviceName": "emulator-5554",
  "platformVersion": "13.0",
  "appPackage": "com.example.app",
  "appActivity": ".MainActivity"
}
```

> 📌 Update this based on your target app and device.

---

## 📋 Logs & Reports

- **Logs**: `src/main/resources/logs/`
- **Screenshots on failure**: `screenshots/`
- **Reports**: `reports/` (can be enhanced using extent reports)

---

## 🔄 Continuous Integration

This project is CI/CD friendly. You can integrate it with Jenkins, GitHub Actions, or GitLab CI. Here's a basic Jenkins command:

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## 🧱 Design Patterns Used

- **Page Object Model (POM)**
- **Data-driven testing (via JSON or external files)**
- **Driver Factory Pattern**

---

## ✅ Best Practices

- Keep locators and test logic separated.
- Use constants for identifiers (see `ProductPageConstants.java`).
- Create reusable page methods.
- Log every action (see `LoggerUtility.java`).
- Keep test data external (JSON/CSV).

---


